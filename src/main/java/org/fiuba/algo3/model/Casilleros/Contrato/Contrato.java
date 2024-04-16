package src.main.java.org.fiuba.algo3.model.Casilleros.Contrato;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;

public interface Contrato {
    void aceptar() throws CantidadInsuficiente;
    void rechazar();
}
