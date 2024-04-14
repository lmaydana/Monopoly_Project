package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

public interface Comprable {
    void seCompradaPor(Jugador comprador ) throws CantidadInsuficiente;
}
