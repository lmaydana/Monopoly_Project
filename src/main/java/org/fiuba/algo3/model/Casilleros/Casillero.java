package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class Casillero {
        protected ArrayList<Jugador> jugdoresEnCassila;

        public Casillero(){
                this.jugdoresEnCassila = new ArrayList<>();
        }

        public void recibir(Jugador jugador) throws CantidadInsuficiente {
                this.jugdoresEnCassila.add(jugador);
        }

        public void sacar(Jugador jugador){
                this.jugdoresEnCassila.remove(jugador);
        }

        public TipoCasillero obtenerTipoCasillero(){
                return TipoCasillero.DE_PASO;
        }

       public void aportarInformacionCasillero(HashMap<String, String> infoCasillero){
                infoCasillero.put("tipo", "De Paso");
       }

        public ArrayList<String> obtenerColoresJugadores() {
                ArrayList<String> coloresJugadores = new ArrayList<>();
                for (Jugador jugador: this.jugdoresEnCassila){
                    coloresJugadores.add(jugador.obtenerColor());
                }
                return coloresJugadores;
        }

}
