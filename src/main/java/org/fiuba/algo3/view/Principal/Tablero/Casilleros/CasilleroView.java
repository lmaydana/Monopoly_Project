package org.fiuba.algo3.view.Principal.Tablero.Casilleros;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.view.Principal.Tablero.Orientacion;

import java.util.ArrayList;
import java.util.HashMap;

public class CasilleroView extends Pane {

    protected Double anchoCasilla;
    protected Double altoCasilla;
    protected Orientacion orientacion;
    protected Pane cajaInformacion;
    protected Casillero casillero;
    protected ArrayList<Node> jugadoresEnCasilla;
    protected HashMap<String, String> informacionCasillero;


    public CasilleroView(Double anchoCasilla, Double altoCasilla, Casillero casillero, Orientacion orientacion, Configuracion configuracion){
        this.orientacion = orientacion;
        this.jugadoresEnCasilla = new ArrayList<>();
        this.anchoCasilla = anchoCasilla;
        this.casillero = casillero;
        this.informacionCasillero = new HashMap<>();
        this.casillero.aportarInformacionCasillero(this.informacionCasillero);
        this.altoCasilla = altoCasilla;
        this.cajaInformacion = this.orientacion.obtenerPaneAcorde();
        cajaInformacion.setLayoutX(obtenerProyeccion(comienzoSectorInformacionX(), comienzoSectorInformacionY()));
        cajaInformacion.setLayoutY(obtenerProyeccion(comienzoSectorInformacionY(), comienzoSectorInformacionX()));
        cajaInformacion.setPrefHeight(obtenerProyeccion(altoSectorInformacion(), anchoSectorInformacion()));
        cajaInformacion.setPrefWidth(obtenerProyeccion(anchoSectorInformacion(), altoSectorInformacion()));
        Rectangle informacionDeLaCasilla = new Rectangle(obtenerProyeccion(comienzoCasillaX(),comienzoCasillaY()),obtenerProyeccion(comienzoCasillaY(),comienzoCasillaX()), obtenerProyeccion(this.anchoCasilla, this.altoCasilla), obtenerProyeccion(this.altoCasilla, this.anchoCasilla));
        informacionDeLaCasilla.setStrokeWidth(3);
        informacionDeLaCasilla.setFill(Color.WHITE);
        informacionDeLaCasilla.setStroke(Color.BLACK);
        String textoCasilla = this.obtenerTextoCasilla();
        Label nombreEtiqueta = new Label(textoCasilla);
        this.setearFormatoEtiqueta(nombreEtiqueta);
        nombreEtiqueta.setStyle("-fx-text-fill: blue;");
        ImageView imagenCasillero = new ImageView(  configuracion.obtenerDireccionImagen(textoCasilla)  );
        imagenCasillero.setFitWidth(anchoImagen());
        imagenCasillero.setFitHeight(altoImagen());
        imagenCasillero.setRotate(this.orientacion.obtenerGrados());
        cajaInformacion.getChildren().add(new Group(nombreEtiqueta));
        cajaInformacion.getChildren().add(new Group(imagenCasillero));
        this.getChildren().add(new Group(informacionDeLaCasilla));
        this.getChildren().add(new Group(cajaInformacion));
    }

    protected void setearFormatoEtiqueta( Label etiqueta ){
        etiqueta.setMaxWidth(this.anchoCasilla);
        etiqueta.setMaxHeight(altoMaximoEtiqueta());
        etiqueta.setWrapText(true);
        etiqueta.setFont(new Font(tamanioFuente()));
        etiqueta.setAlignment(Pos.CENTER);
        etiqueta.setTextAlignment(TextAlignment.CENTER);
        etiqueta.setRotate(this.orientacion.obtenerGrados());
    }

    protected Double altoMaximoEtiqueta() {
        return this.altoMaximoNombre();
    }

    protected Double tamanioFuente(){
        return this.altoCasilla * 0.06;
    }

    private String obtenerTextoCasilla(){
        return this.informacionCasillero.get(this.claveTexto());
    }

    protected String claveTexto() {
        return "tipo";
    }

    protected Double obtenerProyeccion(Double portraitValor, Double landScapeValor){
        ArrayList<Double> valoresPosibles = new ArrayList<>();
        valoresPosibles.add(portraitValor);
        valoresPosibles.add(landScapeValor);
        return valoresPosibles.get(this.obtenerIndice());
    }

    protected int obtenerIndice(){
        Double indiceDouble = Math.abs(Math.sin(Math.toRadians(this.orientacion.obtenerGrados())));
        int indice = indiceDouble.intValue();
        return indice;
    }

    protected Double altoImagen() {
        return altoCasilla * factorDeCrecimientoImagen();
    }

    protected double factorDeCrecimientoImagen() {
        return 0.5;
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
        return anchoCasilla * 0.9;
    }

    protected Double altoMaximoNombre() {
        return altoCasilla * 0.2;
    }

    protected Double altoSectorInformacion() {
        return altoCasilla * 0.8;
    }

    public void dibujar() {
        this.getChildren().removeAll(this.jugadoresEnCasilla);
        this.jugadoresEnCasilla.clear();
        ArrayList<String> coloresJugadores = this.casillero.obtenerColoresJugadores();
        for ( String colorJugador : coloresJugadores){
            Color color = Color.valueOf(colorJugador);
            this.dibujarJugador(color);
        }
    }

    private void dibujarJugador( Color color ) {
        Double posicionXJugador = this.obtenerProyeccion(posicionXJugadorCasillaVertical(), posicionYJugadorCasillaVertical());
        Double posicionYJugador = this.obtenerProyeccion(posicionYJugadorCasillaVertical(), posicionXJugadorCasillaVertical());
        Circle jugador = new Circle(posicionXJugador, posicionYJugador, radioCirculoJugador(), color);
        this.getChildren().add(jugador);
        this.jugadoresEnCasilla.add(jugador);
    }

    private double posicionYJugadorCasillaVertical() {
        return this.altoCasilla * 0.5 + diametroCirculoJugador() * this.jugadoresEnCasilla.size();
    }

    private double diametroCirculoJugador() {
        return radioCirculoJugador() * 2;
    }

    private double posicionXJugadorCasillaVertical() {
        return this.anchoCasilla * 0.5;
    }

    private Double radioCirculoJugador(){
        return 10.0;
    }
}
