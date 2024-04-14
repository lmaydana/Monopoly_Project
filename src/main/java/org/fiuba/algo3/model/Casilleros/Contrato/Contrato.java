package org.fiuba.algo3.model.Casilleros.Contrato;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;

public interface Contrato {
    void aceptar() throws CantidadInsuficiente;
    void rechazar();
}
