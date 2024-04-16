package org.fiuba.algo3.model.Jugador;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;

public interface Comprador {
    void transferir(Double monto, Transferible vendedor) throws CantidadInsuficiente;

}
