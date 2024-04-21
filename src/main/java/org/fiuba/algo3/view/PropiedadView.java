package org.fiuba.algo3.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PropiedadView extends TransporteView {

    protected Orientacion orientacion;

    public PropiedadView(Double anchoCasilla, Double altoCasilla, Color color, String direccionImagen, String nombrePropiedad, String precioPropiedad, Orientacion orientacion) {
        super(anchoCasilla, altoCasilla, direccionImagen,nombrePropiedad,precioPropiedad,orientacion);
        this.orientacion = orientacion;
        Rectangle sectorViviendas = new Rectangle(0,0, obtenerProyeccion(anchoSectorViviendas(), altoSectorViviendas()), obtenerProyeccion(altoSectorViviendas(), anchoSectorViviendas()));
        sectorViviendas.setStroke(Color.BLACK);
        sectorViviendas.setFill(color);
        sectorViviendas.setStrokeWidth(3);
        this.getChildren().add(sectorViviendas);
    }


    protected Double anchoSectorViviendas(){
        return anchoCasilla;
    }

    protected Double altoSectorViviendas(){
        return this.altoMaximoNombre();
    }

}