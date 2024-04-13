package org.fiuba.algo3.model.Casilleros.Arrendador;
import org.fiuba.algo3.model.Jugador.Comprador;
import org.fiuba.algo3.model.Jugador.Transferible;
import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Jugador.Jugador;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, CasillaComprable propiedad);
    void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador);
}
