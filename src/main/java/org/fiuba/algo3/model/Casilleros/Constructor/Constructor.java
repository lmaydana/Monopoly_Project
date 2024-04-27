package org.fiuba.algo3.model.Casilleros.Constructor;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Jugador.Transferible;

public interface Constructor {
    void construir(Cartera cartera) throws CantidadInsuficiente;
    void demoler(Transferible transferible);
}
