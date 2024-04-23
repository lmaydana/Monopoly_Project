package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class Casillero {
        private ArrayList<Jugador> jugdoresEnCassila;

        public Casillero(){
                this.jugdoresEnCassila = new ArrayList<>();
        }

        public void recibirJugador(Jugador jugador) throws CantidadInsuficiente {
                this.jugdoresEnCassila.add(jugador);
        }

        public void sacarDeCasillero(Jugador jugador){
                this.jugdoresEnCassila.remove(jugador);
        }

        public TipoCasillero obtenerTipoCasillero(){
                return TipoCasillero.DE_PASO;
        }

       public HashMap<String, String> obtenerInfoCasillero(){
                HashMap<String, String> infoCasillero = new HashMap<>();
                infoCasillero.put("tipo", "De Paso");
                return infoCasillero;
       }


    public ArrayList<String> obtenerColoresJugadores() {
            ArrayList<String> coloresJugadores = new ArrayList<>();
            for (Jugador jugador: this.jugdoresEnCassila){
                coloresJugadores.add(jugador.obtenerColor());
            }
            return coloresJugadores;
    }
}
