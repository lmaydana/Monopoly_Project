package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class TransporteView extends CasilleroView{

    private Orientacion orientacion;

    public TransporteView(Double anchoCasilla, Double altoCasilla, String direccionImagen, String nombre, String precioPropiedad, Orientacion orientacion) {
        super(anchoCasilla, altoCasilla, direccionImagen, nombre, orientacion);
        this.orientacion = orientacion;
        Label precio = new Label(precioPropiedad);
        precio.setMaxWidth(anchoMaximoPrecio());
        precio.setMaxHeight(altoMaximoPrecio());
        precio.setWrapText(true);
        precio.setAlignment(Pos.CENTER);
        precio.setRotate(this.orientacion.obtenerGrados());
        this.cajaInformacion.getChildren().add(new Group(precio));
    }

    public Double altoMaximoPrecio() {
        return super.altoMaximoNombre();
    }

    protected Double anchoMaximoPrecio() {
        return super.anchoImagen();
    }
}
