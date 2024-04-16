package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador;

import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;

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
