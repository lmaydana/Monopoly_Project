package src.main.java.org.fiuba.algo3.model.Jugador;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;

public interface Comprador {
    void transferir(Double monto, Transferible vendedor) throws CantidadInsuficiente;

}
