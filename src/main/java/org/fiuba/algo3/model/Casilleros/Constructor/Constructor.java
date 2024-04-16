package org.fiuba.algo3.model.Casilleros.Constructor;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;

public interface Constructor {
    void construir(Cartera cartera) throws CantidadInsuficiente;
}
