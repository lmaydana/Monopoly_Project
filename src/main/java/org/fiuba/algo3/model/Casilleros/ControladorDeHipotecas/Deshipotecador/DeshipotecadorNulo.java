package src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;

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
