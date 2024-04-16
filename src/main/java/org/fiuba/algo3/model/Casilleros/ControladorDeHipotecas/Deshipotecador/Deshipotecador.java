package src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;

public interface Deshipotecador {
    Arrendador deshipotecar(Cartera cartera ) throws CantidadInsuficiente;
}
