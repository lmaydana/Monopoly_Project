package src.main.java.org.fiuba.algo3.model.Casilleros;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Jugador.Jugador;

public interface Comprable {
    void seCompradaPor(Jugador comprador ) throws CantidadInsuficiente;
}
