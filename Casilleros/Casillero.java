package Casilleros;

import java.util.ArrayList;

public abstract class Casillero {

        public void recibirJugador(Jugador jugador){
                jugador.posicionarEn(this);
        }


}
