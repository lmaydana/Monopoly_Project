package org.fiuba.algo3.model.Casilleros.Arrendador;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Comprador;
import org.fiuba.algo3.model.Jugador.Transferible;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, String propiedad) throws CantidadInsuficiente;
    void despojarseDeCasilla(String propiedad, Comprador comprador);

    void informarDetalles(HashMap<String, String> detalles);
}
