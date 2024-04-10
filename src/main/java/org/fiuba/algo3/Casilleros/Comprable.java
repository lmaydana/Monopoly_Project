package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Jugador.Jugador;

public interface Comprable {
    void seCompradaPor(Jugador comprador ) throws CantidadInsuficiente;
}
