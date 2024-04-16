package org.fiuba.algo3.model.Jugador;

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
    private String color;
    private Cartera cartera;
    private Estado estado;
    private Map<String, Propiedad> propiedades;
    private Contrato contratoActual;

    public Jugador(String nombreJugador, String color){
        this.nombreJugador = nombreJugador;
        this.color = color;
        this.propiedades = new HashMap<>();
        this.contratoActual = new ContratoSinEfecto();
        this.estado = new EstadoNormal(this);
        Config config = new Config();
        this.cartera = new Billetera(config.obtenerMontoDePlataIncial());
    }

    @Override
    public void acordar(Jugador jugador, String propiedad) throws CantidadInsuficiente{
        estado.acordar(jugador,propiedad,propiedades);
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
        this.propiedades.put(nombrePropiedad, propiedad);
    }

    public void recibir(Contrato contratoDeVenta){
        this.contratoActual = contratoDeVenta;
    }

    public void perderOferta() {
        this.contratoActual = new ContratoSinEfecto();
    }

    public void encarcelar() {
        estado = new EstadoPreso(this);
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

    public void venderPropiedades(String nombrePropiedad, Integer cantidadAVender){
        this.propiedades.get(nombrePropiedad).venderConstrucciones(cantidadAVender);
    }

    public void hipotecar(String nombrePropiedad){
        this.propiedades.get(nombrePropiedad).hipotecar(cartera);
    }
    public void deshipotecar(String nombrePropiedad) throws CantidadInsuficiente {
        this.propiedades.get(nombrePropiedad).deshipotecar(cartera);
    }

    public void comprarPropiedadOfrecida() throws CantidadInsuficiente{
        this.contratoActual.aceptar();
    }

    public void moverse(int tirada) throws NoPuedeMoverse{
        estado.moverse(tirada);
    }
    public void pagarFianza(double monto,Banco banco) throws CantidadInsuficiente{
        estado.pagarFianza(monto,banco);
    }
}
