package org.fiuba.algo3.view.Principal.Tablero;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ColumnaTablero extends BordeTableroBase{


    public ColumnaTablero(Integer cantidadDeCasillasPorLado, Integer ladoActual, BorderPane disposicionPrincipal) {
        super(cantidadDeCasillasPorLado, ladoActual, disposicionPrincipal);
    }

    @Override
    protected Pane obtenerDisposicion() {
        return new VBox();
    }

    @Override
    protected Integer corrimiento() {
        return -1;
    }

    @Override
    protected BordeTablero devolverSiguienteBorde(Integer ladoActual, BorderPane disposicion) {
        return new FilaTablero(this.cantidadDeCasillasPorLado, ladoActual, disposicion);
    }

    @Override
    public Orientacion obtenerOrientacion() {
        return Orientacion.LANDSCAPE;
    }
}
