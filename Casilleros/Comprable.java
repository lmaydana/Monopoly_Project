package Casilleros;

import Cartera.CantidadInsuficiente;
import Jugador.Jugador;

public interface Comprable {
    void seCompradaPor(Jugador comprador ) throws CantidadInsuficiente;
}
