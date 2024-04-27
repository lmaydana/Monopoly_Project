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
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.Jugador.Estado.*;
import org.fiuba.algo3.model.Terminable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Jugador implements Arrendador, Comprador{

    private String nombreJugador;
    private Color color;
    private Cartera cartera;
    private Estado estado;
    private Map<String, Propiedad> propiedades;
    private Contrato contratoActual;
    private HashMap<String, CasillaComprable> activos;

    public Jugador(String nombreJugador, Color color){
        this.nombreJugador = nombreJugador;
        this.activos = new HashMap<>();
        this.color = color;
        this.propiedades = new HashMap<>();
        this.contratoActual = new ContratoSinEfecto();
        this.cartera = new Billetera();
        this.estado = new EstadoNormal(this, this.propiedades,this.cartera);
    }

    @Override
    public void acordar(Jugador jugador, String propiedad) throws CantidadInsuficiente{
        this.estado.acordar(jugador,propiedad,this.activos);
    }

    @Override
    public void despojarseDeCasilla(String propiedad, Comprador comprador) {
        this.propiedades.remove(propiedad);
    }

    @Override
    public void informarDetalles(HashMap<String, String> detalles) {
            detalles.put("propietario", this.nombreJugador);
            detalles.put("color jugador", this.color.toString());
            detalles.put("dinero disponible", this.cartera.toString());
    }

    @Override
    public void recibir(Double monto) {
        this.cartera.recibir(monto);
    }

    @Override
    public void transferir(Double monto, org.fiuba.algo3.model.Jugador.Transferible transferible) throws CantidadInsuficiente{
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
        this.estado = new EstadoPreso(this, diasCondena, this.propiedades, this.cartera);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void construirEn(String nombrePropiedad) throws CantidadInsuficiente {
        this.estado.construirEn(nombrePropiedad);
    }

    public void venderConstruccion(String nombrePropiedad){
        this.estado.venderConstruccion(nombrePropiedad);
    }

    public void hipotecar(String nombrePropiedad){
        this.propiedades.get(nombrePropiedad).hipotecar();
    }
    public void deshipotecar(String nombrePropiedad) throws CantidadInsuficiente {
        this.propiedades.get(nombrePropiedad).deshipotecar(cartera);
    }

    public void comprarPropiedadOfrecida() throws CantidadInsuficiente{
        this.contratoActual.aceptar();
        this.contratoActual = new ContratoSinEfecto();
    }

    public void moverse(int tirada) throws JugadorEncarcelado {
        this.estado.moverse(tirada);
    }
    public void pagarFianza(double monto, Banco banco) throws CantidadInsuficiente{
        this.estado.pagarFianza(monto,banco);
    }

    public void cargarNombreDePropiedadesEnPosesion(ArrayList<String> propiedadesEnPosesion) {
        propiedadesEnPosesion.addAll(this.propiedades.keySet());
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

    public void desactivarActivos() {
        Iterator<String> clavesActivos = this.activos.keySet().iterator();
        while (clavesActivos.hasNext()){
            this.activos.get(clavesActivos.next()).desactivar();
        }
    }

    public void terminarJuego(Terminable juego) {
        for( Propiedad propiedad: this.propiedades.values() ){
            propiedad.terminarContrucciones(juego);
        }
    }

    @Override
    public String toString() {
        return this.nombreJugador;
    }
}
