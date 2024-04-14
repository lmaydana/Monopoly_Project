package org.fiuba.algo3.model.Tablero;

import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;

public class Tablero {
    private ListaCircular<Casillero> tablero;
    private Config config;
    private ArrayList<Iterador<Casillero>> iteradores;
    public Tablero(Integer cantJugadores){
        this.tablero = new ListaCircular<Casillero>();
        this.config = new Config();
        this.iteradores = this.obtenerIteradores(cantJugadores);
        this.inicializarTablero();
    }

    private ArrayList<Iterador<Casillero>> obtenerIteradores(Integer cantJugadores){
        ArrayList<Iterador<Casillero>> iteradores= new ArrayList<>();
        for(Integer i = 0; i < cantJugadores; i++){
            iteradores.add(this.tablero.iterador());
        }
        return iteradores;
    }

    private void inicializarTablero() {
        config.distribucion();
    }

    public void mover(int origen, int pasos, Jugador jugador) throws Exception{
        Iterador<Casillero> iterador = this.iteradores.get(origen);
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
