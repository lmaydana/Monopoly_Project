package Casilleros.Arrendador;

import Casilleros.CasillaComprable;
import Jugador.Comprador;
import Jugador.Jugador;
import Jugador.Transferible;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, CasillaComprable propiedad);
    void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador);
}
