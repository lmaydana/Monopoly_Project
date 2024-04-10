package Casilleros.Constructor;

import Cartera.CantidadInsuficiente;
import Cartera.Cartera;

public interface Constructor {
    void construir(Cartera cartera) throws CantidadInsuficiente;
}
