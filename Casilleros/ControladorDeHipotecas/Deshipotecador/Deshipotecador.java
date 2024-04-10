package Casilleros.ControladorDeHipotecas.Deshipotecador;

import Casilleros.Arrendador.Arrendador;
import Cartera.CantidadInsuficiente;
import Cartera.Cartera;

public interface Deshipotecador {
    Arrendador deshipotecar(Cartera cartera ) throws CantidadInsuficiente;
}
