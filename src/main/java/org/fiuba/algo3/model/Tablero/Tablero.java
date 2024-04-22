package org.fiuba.algo3.model.Tablero;

import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;
import java.util.List;

public class Tablero {
    private ListaCircular<Casillero> tablero;
    private Config config;
    private HashMap<Jugador,Iterador<Casillero>> iteradores;
    public Tablero(List<Jugador> jugadores){
        this.config = new Config();
        this.tablero = this.config.obtenerCasilleros();
        this.iteradores = new HashMap<>();
        this.llenarIteradores(jugadores);
        this.inicializarTablero();
    }

    private void llenarIteradores(List<Jugador> jugadores){
        for(Jugador jugador: jugadores){
            this.iteradores.put(jugador, this.tablero.iterador());
        }
    }

    private void inicializarTablero() {
        config.obtenerCasilleros();
    }

    public void mover(int pasos, Jugador jugador) throws Exception{
        Iterador<Casillero> iterador = this.iteradores.get(jugador);
        Casillero casillero = iterador.obtenerActual();
        casillero.sacarDeCasillero(jugador);
        for(int i = 0; i < pasos && iterador.tieneSiguiente(); i++){
            iterador.avanzar();
            if(iterador.estaAlPrincipio() && i < pasos - 1){
                casillero = iterador.obtenerActual();
                casillero.recibirJugador(jugador);
                casillero.sacarDeCasillero(jugador);
            }
        }
        casillero = iterador.obtenerActual();
        casillero.recibirJugador(jugador);

    }

    public void addCasillero(Casillero casillero){
        this.tablero.append(casillero);
    }

    public Casillero getCasillero(int indice){
        return this.tablero.get(indice);
    }
}
