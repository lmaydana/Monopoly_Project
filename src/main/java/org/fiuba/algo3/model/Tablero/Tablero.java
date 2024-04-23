package org.fiuba.algo3.model.Tablero;

import org.fiuba.algo3.model.Casilleros.Carcel;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Casilleros.IrALaCarcel;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Jugador.Estado.JugadorEncarcelado;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tablero {
    private final Carcel carcel;
    private ListaCircular<Casillero> tablero;
    private Config config;
    private HashMap<Jugador,Iterador<Casillero>> iteradores;

    private ArrayList<IrALaCarcel> casillerosIrALaCarcel;
    public Tablero(List<Jugador> jugadores, Config config){
        this.config = config;
        this.tablero = this.config.obtenerCasilleros();
        this.iteradores = new HashMap<>();
        this.carcel = this.config.obtenerCarcel();
        this.casillerosIrALaCarcel = this.config.obtenerCasillerosIrALaCarcel();
        this.llenarIteradores(jugadores);

    }

    private void llenarIteradores(List<Jugador> jugadores){
        for(Jugador jugador: jugadores){
            this.iteradores.put(jugador, this.tablero.iterador());
        }
    }

    public void mover(int pasos, Jugador jugador) throws Exception{
        Iterador<Casillero> iterador = this.iteradores.get(jugador);
        Casillero casillero = iterador.obtenerActual();
        jugador.moverse(pasos);
        casillero.sacar(jugador);
        for(int i = 0; i < pasos && iterador.tieneSiguiente(); i++){
            iterador.avanzar();
            if(iterador.estaAlPrincipio() && i < pasos - 1){
                casillero = iterador.obtenerActual();
                casillero.recibir(jugador);
                casillero.sacar(jugador);
            }
        }
        casillero = iterador.obtenerActual();
        casillero.recibir(jugador);
        if( this.casillerosIrALaCarcel.contains(casillero) ){
            iterador.avanzarHasta(this.carcel);
        }
    }

}
