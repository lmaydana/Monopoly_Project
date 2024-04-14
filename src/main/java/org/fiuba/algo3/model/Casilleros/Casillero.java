package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;

public class Casillero {
        private ArrayList<Jugador> jugdoresEnCassila;

        public Casillero(){
                this.jugdoresEnCassila = new ArrayList<>();
        }

        public void recibirJugador(Jugador jugador) throws CantidadInsuficiente {
                this.jugdoresEnCassila.add(jugador);
                //jugador.posicionarEn(this);
        }

        public void sacarDeCasillero(Jugador jugador){
                this.jugdoresEnCassila.remove(jugador);
        }


}
