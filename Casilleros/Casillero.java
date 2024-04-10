package Casilleros;

import Jugador.Jugador;

import java.util.ArrayList;

public class Casillero {

        private ArrayList<Jugador> jugdoresEnCassila;

        public Casillero(){
                this.jugdoresEnCassila = new ArrayList<>();
        }

        public void recibirJugador(Jugador jugador){
                this.jugdoresEnCassila.add(jugador);
                jugador.posicionarEn(this);
        }

        public void sacarDeCasillero(Jugador jugador){
                this.jugdoresEnCassila.remove(jugador);
        }


}
