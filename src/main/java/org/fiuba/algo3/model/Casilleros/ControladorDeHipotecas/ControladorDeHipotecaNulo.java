package src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas;

import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;

public class ControladorDeHipotecaNulo implements ControladorDeHipotecas {

    private Arrendador arrendador;

    public ControladorDeHipotecaNulo(Arrendador arrendador) {
        this.arrendador = arrendador;
    }

    @Override
    public Arrendador hipotecar( Cartera cartera ) {
        return this.arrendador;
    }

    @Override
    public Arrendador deshipotecar( Cartera cartera ) {
        return this.arrendador;
    }
}
