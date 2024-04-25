package org.fiuba.algo3.model.Casilleros.Inmueble;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;

public interface Inmueble {
    void vender(org.fiuba.algo3.model.Jugador.Transferible cartera);

    void comprar(Cartera cartera) throws CantidadInsuficiente;

    Double devolverRentaSumadaA( Double rentaActual );
}
