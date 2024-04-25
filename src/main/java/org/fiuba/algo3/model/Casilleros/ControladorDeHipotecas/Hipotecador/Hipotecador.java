package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador;

import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Jugador.Transferible;

public interface Hipotecador {
    Arrendador hipotecar(Transferible cartera );
}
