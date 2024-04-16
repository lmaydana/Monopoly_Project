package src.main.java.org.fiuba.algo3.model.Casilleros.Constructor;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;

public interface Constructor {
    void construir(Cartera cartera) throws CantidadInsuficiente;
}
