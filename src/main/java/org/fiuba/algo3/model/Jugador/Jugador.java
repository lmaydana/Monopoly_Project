package org.fiuba.algo3.model.Jugador;

import javafx.scene.paint.Color;
import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.Billetera;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.*;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Contrato.Contrato;
import org.fiuba.algo3.model.Casilleros.Contrato.ContratoSinEfecto;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Jugador.Estado.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Jugador implements Arrendador, Comprador{

    //faltaria un atributo para el color de cada jugador y el nombre
    private String nombreJugador;
    private Color color;
    private Cartera cartera;
    private Estado estado;
    private Map<String, Propiedad> propiedades;
    private Contrato contratoActual;

    private HashMap<String, CasillaComprable> activos;

    public Jugador(String nombreJugador, Color color, Config config){
        this.nombreJugador = nombreJugador;
        this.activos = new HashMap<>();
        this.color = color;
        this.propiedades = new HashMap<>();
        this.contratoActual = new ContratoSinEfecto();
        this.estado = new EstadoNormal(this);
        this.cartera = new Billetera(config.obtenerMontoDePlataIncial());
    }

    @Override
    public void acordar(Jugador jugador, String propiedad) throws CantidadInsuficiente{
        estado.acordar(jugador,propiedad,this.activos);
    }

    @Override
    public void despojarseDeCasilla(String propiedad, Comprador comprador) {
        this.propiedades.remove(propiedad);
    }

    @Override
    public void recibir(Double monto) {
        this.cartera.recibir(monto);
    }

    @Override
    public void transferir(Double monto, Transferible transferible) throws CantidadInsuficiente{
        cartera.transferir(monto, transferible);

    }

    public void recibir(String nombrePropiedad,Propiedad propiedad) {
        this.propiedades.putIfAbsent(nombrePropiedad, propiedad);
    }

    public void recibir(Contrato contratoDeVenta){
        this.contratoActual = contratoDeVenta;
    }

    public void perderOferta() {
        this.contratoActual = new ContratoSinEfecto();
    }

    public void encarcelar(Integer diasCondena) {
        estado = new EstadoPreso(this, diasCondena);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<String> getNombrePropiedades(){
        ArrayList<String> propiedadesNombres = new ArrayList<>(this.propiedades.keySet());
        return propiedadesNombres;
    }

    public void construirEn(String nombrePropiedad) throws CantidadInsuficiente {
        this.propiedades.get(nombrePropiedad).construirVivienda(cartera);
    }

    public void venderConstruccion(String nombrePropiedad){
        this.propiedades.get(nombrePropiedad).venderConstruccion();
    }

    public void hipotecar(String nombrePropiedad){
        this.propiedades.get(nombrePropiedad).hipotecar(cartera);
    }
    public void deshipotecar(String nombrePropiedad) throws CantidadInsuficiente {
        this.propiedades.get(nombrePropiedad).deshipotecar(cartera);
    }

    public void comprarPropiedadOfrecida() throws CantidadInsuficiente{
        this.contratoActual.aceptar();
        this.contratoActual = new ContratoSinEfecto();
    }

    public void moverse(int tirada) throws JugadorEncarcelado {
        estado.moverse(tirada);
    }
    public void pagarFianza(double monto, Banco banco) throws CantidadInsuficiente{
        estado.pagarFianza(monto,banco);
    }

    public void cargarNombreDePropiedadesEnPosesion(ArrayList<String> propiedadesEnPosesion) {
        propiedadesEnPosesion.addAll(this.propiedades.keySet());
    }

    public String obtenerNombre() {
        return this.nombreJugador;
    }

    public String obtenerColor() {
        return this.color.toString();
    }

    public String obtenerPlataDisponible() {
        return this.cartera.toString();
    }

    public void recibir(String nombreActivo, CasillaComprable activo) {
        this.activos.put(nombreActivo, activo);
    }
}
