package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Arrendador.ArrendadorSinAcuerdo;

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
