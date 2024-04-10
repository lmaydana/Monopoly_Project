package org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Deshipotecador;

import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Casilleros.Arrendador.Arrendador;

public interface Deshipotecador {
    Arrendador deshipotecar(Cartera cartera ) throws CantidadInsuficiente;
}
