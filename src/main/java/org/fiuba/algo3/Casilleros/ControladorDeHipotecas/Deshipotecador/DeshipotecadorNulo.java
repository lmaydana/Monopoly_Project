package org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Deshipotecador;

import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Casilleros.Arrendador.Arrendador;

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
