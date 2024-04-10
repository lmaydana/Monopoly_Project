package Casilleros.ControladorDeHipotecas.Deshipotecador;

import Casilleros.Arrendador.Arrendador;
import Cartera.CantidadInsuficiente;
import Cartera.Cartera;

public class DeshipotecadorNulo implements Deshipotecador {
    private Arrendador arrendador;

    public DeshipotecadorNulo(Arrendador arrendadorHipotecado) {
        this.arrendador = arrendadorHipotecado;
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        return this.arrendador;
    }
}
