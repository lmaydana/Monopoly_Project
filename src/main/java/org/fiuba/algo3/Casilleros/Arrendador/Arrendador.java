package org.fiuba.algo3.Casilleros.Arrendador;

import org.fiuba.algo3.Casilleros.CasillaComprable;
import org.fiuba.algo3.Jugador.Comprador;
import org.fiuba.algo3.Jugador.Jugador;
import org.fiuba.algo3.Jugador.Transferible;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, CasillaComprable propiedad);
    void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador);
}
