package org.fiuba.algo3.view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import java.util.ArrayList;

public class CasilleroView extends Pane {

    protected double anchoCasilla;
    protected double altoCasilla;
    private Orientacion orientacion;
    protected Pane cajaInformacion;

    public CasilleroView(Double anchoCasilla, Double altoCasilla, String direccionImagen, String nombre, Orientacion orientacion){
        this.orientacion = orientacion;
        this.anchoCasilla = anchoCasilla;
        this.altoCasilla = altoCasilla;
        this.cajaInformacion = this.orientacion.obtenerPaneAcorde();
        cajaInformacion.setLayoutX(obtenerProyeccion(comienzoSectorInformacionX(), comienzoSectorInformacionY()));
        cajaInformacion.setLayoutY(obtenerProyeccion(comienzoSectorInformacionY(), comienzoSectorInformacionX()));
        cajaInformacion.setPrefHeight(obtenerProyeccion(altoSectorInformacion(), anchoSectorInformacion()));
        cajaInformacion.setPrefWidth(obtenerProyeccion(anchoSectorInformacion(), altoSectorInformacion()));
        Rectangle informacionDeLaCasilla = new Rectangle(obtenerProyeccion(comienzoCasillaX(),comienzoCasillaY()),obtenerProyeccion(comienzoCasillaY(),comienzoCasillaX()), obtenerProyeccion(this.anchoCasilla, this.altoCasilla), obtenerProyeccion(this.altoCasilla, this.anchoCasilla));
        informacionDeLaCasilla.setStrokeWidth(3);
        informacionDeLaCasilla.setFill(Color.rgb(149,213,227));
        informacionDeLaCasilla.setStroke(Color.BLACK);
        Label nombreEtiqueta = new Label(nombre);
        nombreEtiqueta.setMaxWidth(anchoMaximoNombre());
        nombreEtiqueta.setMaxHeight(altoMaximoNombre());
        nombreEtiqueta.setTextAlignment(TextAlignment.CENTER);
        nombreEtiqueta.setWrapText(true);
        nombreEtiqueta.setRotate(this.orientacion.obtenerGrados());
        Image imagen = new Image(direccionImagen);
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(anchoImagen());
        imageView.setFitHeight(altoImagen());
        imageView.setRotate(this.orientacion.obtenerGrados());
        cajaInformacion.getChildren().add(new Group(nombreEtiqueta));
        cajaInformacion.getChildren().add(new Group(imageView));
        this.getChildren().add(new Group(informacionDeLaCasilla));
        this.getChildren().add(new Group(cajaInformacion));
    }

    protected Double obtenerProyeccion(Double portraitValor, Double landscapeValor){
        ArrayList<Double> valoresPosibles = new ArrayList<>();
        valoresPosibles.add(portraitValor);
        valoresPosibles.add(landscapeValor);
        return valoresPosibles.get(this.obtenerIndice());
    }

    protected int obtenerIndice(){
        Double indiceDouble = Math.abs(Math.sin(Math.toRadians(this.orientacion.obtenerGrados())));
        int indice = indiceDouble.intValue();
        return indice;
    }

    protected Double altoImagen() {
        return altoCasilla * 0.3;
    }

    protected Double comienzoCasillaX(){
        return 0.0;
    }

    protected Double comienzoCasillaY(){
        return 0.0;
    }

    protected Double comienzoSectorInformacionX(){
        return 0.0;
    }

    protected Double comienzoSectorInformacionY(){
        return altoMaximoNombre();
    }

    protected Double anchoSectorInformacion(){
        return anchoCasilla;
    }

    protected Double anchoImagen(){
        return anchoCasilla * 0.5;
    }

    protected Double altoMaximoNombre() {
        return altoCasilla * 0.2;
    }

    protected Double anchoMaximoNombre() {
        return anchoCasilla * 0.75;
    }

    protected Double altoSectorInformacion() {
        return altoCasilla * 0.8;
    }

}
