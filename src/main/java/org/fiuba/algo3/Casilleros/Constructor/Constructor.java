package org.fiuba.algo3.Casilleros.Constructor;

import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;

public interface Constructor {
    void construir(Cartera cartera) throws CantidadInsuficiente;
}
