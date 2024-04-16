package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;

public interface Deshipotecador {
    Arrendador deshipotecar(Cartera cartera ) throws CantidadInsuficiente;
}
