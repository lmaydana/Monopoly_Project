package org.fiuba.algo3.view;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class FilaTablero extends BordeTableroBase{


    public FilaTablero(Integer cantidadDeCasillasPorLado, Integer ladoActual, BorderPane disposicionPrincipal) {
        super(cantidadDeCasillasPorLado, ladoActual, disposicionPrincipal);
    }

    @Override
    protected Pane obtenerDisposicion() {
        return new HBox();
    }

    @Override
    protected Integer corrimiento() {
        return 1;
    }

    @Override
    protected BordeTablero devolverSiguienteBorde(Integer ladoActual, BorderPane disposicion) {
        return new ColumnaTablero(this.cantidadDeCasillasPorLado, ladoActual, disposicion);
    }

    @Override
    public BordeTablero obtenerSiguienteBorde(BorderPane disposicion) {
        if(!puedoAceptarMasHijos()){
            List<Node> hijos = this.disposicion.getChildren().reversed();
            LinkedList<Node> hijosCopia = new LinkedList<>(hijos);
            this.disposicion.getChildren().clear();
            this.disposicion.getChildren().addAll(hijosCopia);
        }
        return super.obtenerSiguienteBorde(disposicion);
    }

    @Override
    public Orientacion obtenerOrientacion() {
        return Orientacion.PORTRAIT;
    }
}
