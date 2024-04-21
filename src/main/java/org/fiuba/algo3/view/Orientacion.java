package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;

public enum Orientacion {
    PORTRAIT(0),
    LANDSCAPE(3);

    private Orientacion(Integer valor){
        this.valor = valor;
    }

    public Integer obtenerGrados(){
        return this.valor*this.valorAnguloRecto();
    }

    private Integer valorAnguloRecto(){
        return 90;
    }

    public Pane obtenerPaneAcorde(){
        HashMap<Integer,Pane> panesPosibles = new HashMap<>();
        VBox cajaVertical = new VBox();
        cajaVertical.setAlignment(Pos.CENTER);
        HBox cajaHorizontal = new HBox();
        cajaHorizontal.setAlignment(Pos.CENTER);
        panesPosibles.put(0, cajaVertical);
        panesPosibles.put(3, cajaHorizontal);
        return panesPosibles.get(this.valor);
    }

    private Integer valor;
}
