package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador;

import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Jugador.Transferible;

public class HipotecadorNulo implements Hipotecador {

    private Arrendador arrendadorHipotecado;
    public HipotecadorNulo(Arrendador arrendadorHipotecado) {
        this.arrendadorHipotecado = arrendadorHipotecado;
    }

    @Override
    public Arrendador hipotecar(Transferible cartera) {
        return this.arrendadorHipotecado;
    }
}
