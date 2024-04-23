package org.fiuba.algo3.model.Casilleros.Inmueble;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Jugador.Transferible;

public interface Inmueble {
    void vender(Transferible cartera);

    void comprar(Cartera cartera) throws CantidadInsuficiente;

    Double devolverRentaSumadaA( Double rentaActual );
}
