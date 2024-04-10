package Casilleros.ControladorDeHipotecas.Hipotecador;

import Casilleros.Arrendador.Arrendador;
import Cartera.Cartera;

public class HipotecadorNulo implements Hipotecador {

    private Arrendador arrendadorHipotecado;
    public HipotecadorNulo(Arrendador arrendadorHipotecado) {
        this.arrendadorHipotecado = arrendadorHipotecado;
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        return this.arrendadorHipotecado;
    }
}
