package org.fiuba.algo3.model;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.Tablero;

import java.util.*;

public class Juego {
    private final Config configuracion;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Random dado;

    private Jugador jugadorActual;

    private Iterator<Jugador> jugadoresEnOrden;

    private Banco banco;

    public Juego(List<Jugador> jugadores, Tablero tablero, Config configuracion){
        this.configuracion = configuracion;
        this.banco = this.configuracion.obtenerBanco();
        this.jugadores = jugadores;
        this.jugadoresEnOrden = this.jugadores.iterator();
        this.jugadorActual = this.jugadoresEnOrden.next();
        this.tablero = tablero;
        this.dado = new Random();
    }

    public void moverJugador() throws Exception{
        this.tablero.mover(jugarDado(), this.jugadorActual);
    }

    private Integer jugarDado(){
        this.dado.setSeed(new Date().getTime());
        return this.dado.nextInt(1,7);
    }

    public void pasarTurno(){
        if(!this.jugadoresEnOrden.hasNext()){
            this.jugadoresEnOrden = this.jugadores.iterator();
        }
        this.jugadorActual = this.jugadoresEnOrden.next();
    }

    public void construirEn(String nombrePropiedad) throws CantidadInsuficiente {
        this.jugadorActual.construirEn(nombrePropiedad);
    }

    public void venderConstruccion(String nombrePropiedad){
        this.jugadorActual.venderConstruccion(nombrePropiedad);
    }

    public void hipotecar( String nombreDeLaConstruccion ){
        this.jugadorActual.hipotecar(nombreDeLaConstruccion);
    }
    public void deshipotecar( String nombrePropiedad ) throws CantidadInsuficiente {
        this.jugadorActual.deshipotecar(nombrePropiedad);
    }

    public void comprarPropiedadOfrecida() throws CantidadInsuficiente {
        this.jugadorActual.comprarPropiedadOfrecida();
    }

    public void pagarFianza() throws CantidadInsuficiente {
        this.jugadorActual.pagarFianza(this.configuracion.obtnerMontoFianza(), this.banco);
    }

    public boolean seAcabo(){
        //todo
        return false;
    }

    public void cargarConNombresPropiedadesEnPosesion(ArrayList<String> propiedadesEnPosesion) {
        jugadorActual.cargarNombreDePropiedadesEnPosesion(propiedadesEnPosesion);
    }

    public String obtenerNombreDelJugadorActual() {
        return this.jugadorActual.obtenerNombre();
    }

    public String obtenerColorJugadorActual() {
        return this.jugadorActual.obtenerColor();
    }

    public String obtenerPlataDisponibleDelJugadorActual() {
        return this.jugadorActual.obtenerPlataDisponible();
    }
}
