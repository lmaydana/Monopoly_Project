package org.fiuba.algo3.model.Cartera;
import org.fiuba.algo3.model.Jugador.Transferible;

public interface Cartera {
    void transferir(Double monto, Transferible arrendador) throws CantidadInsuficiente;

    void recibir(Double precioDeVenta);
}
