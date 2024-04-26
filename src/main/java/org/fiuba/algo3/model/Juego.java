package org.fiuba.algo3.model;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.Tablero;

import java.util.*;

public class Juego implements Terminable {
    private final Configuracion configuracion;
    private List<Jugador> jugadoresEnPartida;
    private Tablero tablero;
    private Random dado;
    private Jugador jugadorActual;
    private Iterator<Jugador> jugadoresEnOrden;
    private Banco banco;
    private EstadoJuego estadoJuego;

    public Juego(List<Jugador> jugadores, Tablero tablero, Configuracion configuracion){
        this.configuracion = configuracion;
        this.banco = this.configuracion.obtenerBanco();
        this.jugadoresEnPartida = jugadores;
        this.tablero = tablero;
        this.dado = new Random();
        this.sortearOrden();
        this.repartirPlataInicial();
        this.estadoJuego = new JuegoEnProgreso();
    }

    private void repartirPlataInicial() {
        for ( Jugador jugador: this.jugadoresEnPartida ){
            this.banco.transferir(this.configuracion.obtenerMontoDePlataIncial(), jugador);
        }
    }

    private void sortearOrden(){
        Integer cantidadDeJugadores = this.jugadoresEnPartida.size();
        for( int i = cantidadDeJugadores; i > 0; i-- ){
            this.dado.setSeed(new Date().getTime());
            int posicionAAdelantar = this.dado.nextInt(0, i);
            Jugador jugador = this.jugadoresEnPartida.remove(posicionAAdelantar);
            this.jugadoresEnPartida.addFirst(jugador);
        }
        this.jugadoresEnPartida.add(this.jugadoresEnPartida.removeFirst());
        this.jugadoresEnOrden = this.jugadoresEnPartida.iterator();
        this.jugadorActual = this.jugadoresEnOrden.next();
    }

    public void moverJugador(){
        this.jugadorActual.perderOferta();
        try {
            this.tablero.mover(jugarDado(), this.jugadorActual);
        } catch (CantidadInsuficiente e) {
            this.hacerPerderAlJugadorActual();
        }
    }

    private Integer jugarDado(){
        this.dado.setSeed(new Date().getTime());
        return this.dado.nextInt(1,7);
    }

    public void pasarTurno(){
        if(!this.jugadoresEnOrden.hasNext()){
            this.jugadoresEnOrden = this.jugadoresEnPartida.iterator();
        }
        if( !this.jugadoresEnPartida.isEmpty() ) {
            this.jugadorActual = this.jugadoresEnOrden.next();
        }

    }

    public void construirEn(String nombrePropiedad) {
        try {
            this.jugadorActual.construirEn(nombrePropiedad);
            this.jugadorActual.terminarJuego(this);
        } catch (CantidadInsuficiente e) {
            this.hacerPerderAlJugadorActual();
        }
    }

    public void venderConstruccion(String nombrePropiedad){
        this.jugadorActual.venderConstruccion(nombrePropiedad);
    }

    public void hipotecar( String nombreDeLaConstruccion ){
        this.jugadorActual.hipotecar(nombreDeLaConstruccion);
    }
    public void deshipotecar( String nombrePropiedad ) {
        try {
            this.jugadorActual.deshipotecar(nombrePropiedad);
        } catch (CantidadInsuficiente e) {
            this.hacerPerderAlJugadorActual();
        }
    }

    public void comprarPropiedadOfrecida() {
        try {
            this.jugadorActual.comprarPropiedadOfrecida();
        } catch (CantidadInsuficiente e) {
            this.hacerPerderAlJugadorActual();
        }
    }

    public void pagarFianza() {
        try {
            this.jugadorActual.pagarFianza(this.configuracion.obtnerMontoFianza(), this.banco);
        } catch (CantidadInsuficiente e) {
            this.hacerPerderAlJugadorActual();
        }
    }

    public void cargarConNombresPropiedadesEnPosesion(ArrayList<String> propiedadesEnPosesion) {
        jugadorActual.cargarNombreDePropiedadesEnPosesion(propiedadesEnPosesion);
    }

    public String obtenerNombreDelJugadorActual() {
        return this.jugadorActual.toString();
    }

    public String obtenerColorJugadorActual() {
        return this.jugadorActual.obtenerColor();
    }

    public String obtenerPlataDisponibleDelJugadorActual() {
        return this.jugadorActual.obtenerPlataDisponible();
    }

    private void hacerPerderAlJugadorActual() {
        this.jugadoresEnPartida.remove(this.jugadorActual);
        this.jugadoresEnOrden = this.jugadoresEnPartida.iterator();
        this.jugadorActual.desactivarActivos();
        this.tablero.sacar(this.jugadorActual);
        this.pasarTurno();
        if(quedaUnJugador()){
            this.estadoJuego = new JuegoTerminado();
        }
    }

    private boolean quedaUnJugador() {
        return this.jugadoresEnPartida.size() == cantidadDeJugadoresParaTerminarElJuego();
    }

    public void terminar(){
        this.jugadoresEnPartida.remove(jugadorActual);
        for(Jugador jugador: this.jugadoresEnPartida){
            this.tablero.sacar(jugador);
        }
        this.jugadoresEnPartida.clear();
        this.jugadoresEnPartida.add(this.jugadorActual);
        this.jugadoresEnOrden = this.jugadoresEnPartida.iterator();
        this.estadoJuego = new JuegoTerminado();
    }

    public EstadoDeContinuidad estado(){
        return this.estadoJuego.obtenerEstado();
    }

    private int cantidadDeJugadoresParaTerminarElJuego() {
        return 1;
    }
}
