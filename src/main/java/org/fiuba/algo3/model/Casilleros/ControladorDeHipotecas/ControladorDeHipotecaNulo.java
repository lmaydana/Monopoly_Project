package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas;

import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Jugador.Transferible;

public class ControladorDeHipotecaNulo implements ControladorDeHipotecas {

    private Arrendador arrendador;

    public ControladorDeHipotecaNulo(Arrendador arrendador) {
        this.arrendador = arrendador;
    }

    @Override
    public Arrendador hipotecar( Transferible cartera ) {
        return this.arrendador;
    }

    @Override
    public Arrendador deshipotecar( Cartera cartera ) {
        return this.arrendador;
    }
}
