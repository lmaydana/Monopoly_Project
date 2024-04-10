package org.fiuba.algo3.Cartera;

import org.fiuba.algo3.Jugador.Transferible;

public interface Cartera {
    void transferir(Double monto, Transferible arrendador) throws CantidadInsuficiente;

    void recibir(Double precioDeVenta);
}
