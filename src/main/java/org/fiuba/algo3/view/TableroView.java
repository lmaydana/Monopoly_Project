package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Tablero.ListaCircular;

import java.util.ArrayList;
import java.util.HashMap;

public class TableroView extends BorderPane {

    private ArrayList<CasilleroView> casilleros;
    private Double largoLadoTablero;

    public TableroView( Config config ){
        this.largoLadoTablero = (Screen.getPrimary().getBounds().getHeight() * factorCantidadUtilizable());
        this.setPrefSize(largoLadoTablero, largoLadoTablero);
        this.llenarlistaCasilleros(config);
        this.crearCentroDelTablero();
        //this.crearLadosDelTablero();
    }

    private void crearCentroDelTablero() {
        Image centroMonopolio = new Image(obtenerDireccionImagenCentral());
        ImageView centroMonopolioImageView = new ImageView(centroMonopolio);
        centroMonopolioImageView.setFitWidth(largoLadoTablero * factorAnchoImagenCentral());
        centroMonopolioImageView.setPreserveRatio(true);
        VBox contenedorCentral = new VBox();
        contenedorCentral.setAlignment(Pos.CENTER);
        centroMonopolioImageView.setRotate(45);
        contenedorCentral.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #5cd781, #577fe5 100%);");
        contenedorCentral.getChildren().add(new Group(centroMonopolioImageView));
        this.setCenter(contenedorCentral);
    }

    private String obtenerDireccionImagenCentral() {
        return "file:src/main/java/org/fiuba/algo3/view/imagenes/Monopoly-Logo-2008.png";
    }

    private void crearLadosDelTablero() {
        Integer cantidadDeCasillasPorLado = this.casilleros.size() / ladosDelTablero();
        BordeTablero borde = new FilaTablero(cantidadDeCasillasPorLado, 0, this);
        for ( int i = 0; i < this.casilleros.size(); i++){
            borde = borde.obtenerSiguienteBorde( this );
            //borde.agregar(this.casilleros.get(i));
            borde.darVuelta();
            if( hayQueInvertir(i) ){

            }
            borde.posicionar();
        }
    }

    private Double obtenerGrados( Integer indice ) {
        return hayQueInvertir(indice) ? 180.0 : 0.0;
    }

    private boolean hayQueInvertir(Integer indice) {
        return ladoActual(indice) >= 2;
    }

    private Integer ladoActual(Integer indice) {
        Integer cantidadDeCasillasPorLado = this.casilleros.size() / ladosDelTablero();
        return indice / cantidadDeCasillasPorLado;
    }

    private boolean cambioDeLado(int i, Integer cantidadDeCasillasPorLado) {

        return i % cantidadDeCasillasPorLado == 1;
    }

    private Pane obtenerDisposicionAcorde(Integer indice) {
        Integer lado = ladoActual(indice);
        Pane disposicion;
        Integer espaciosOcupadosEnLasFilas = this.espaciosQueSeOcupaEnFilas( this.casilleros.size() );
        Double anchoCasilla = largoLadoTablero/espaciosOcupadosEnLasFilas;
        Double altoCasilla = anchoCasilla * 2;

        if(lado % 2 == 0){
            disposicion = new HBox();
            disposicion.setPrefHeight(altoCasilla);
            return disposicion;
        }

        disposicion  = new VBox();
        disposicion.setPrefWidth(altoCasilla);
        return disposicion;
    }

    private double factorAnchoImagenCentral() {
        return 0.25;
    }

    private double factorCantidadUtilizable() {
        return 0.865740741;
    }

    private void llenarlistaCasilleros(Config config) {
        ListaCircular<Casillero> casillas = config.obtenerCasilleros();
        Integer cantidadDeCasillasPorLado = casillas.getLen() / ladosDelTablero();
        this.casilleros = new ArrayList<>();
        BordeTablero bordeTablero = new FilaTablero(cantidadDeCasillasPorLado, 0, this);
        for (int i = 0; i < casillas.getLen(); i++){
            bordeTablero = bordeTablero.obtenerSiguienteBorde(this);
            this.llenarConCasilleroCorrespondiente(casillas.get(i), casillas.getLen(), i, bordeTablero);

        }

    }

    private Double obtenerGrados( Integer cantidadDeCasillasPorLado,Integer indice ) {
        return hayQueInvertir(cantidadDeCasillasPorLado, indice) ? 180.0 : 0.0;
    }

    private boolean hayQueInvertir( Integer cantidadDeCasillasPorLado, Integer indice) {
        return ladoActual(cantidadDeCasillasPorLado, indice) == 1 && ladoActual(cantidadDeCasillasPorLado, indice) == 2;
    }


    private Integer ladoActual(Integer cantidadDeCasillasPorLado, Integer indice){
        return indice / cantidadDeCasillasPorLado;
    }

    private void llenarConCasilleroCorrespondiente(Casillero casillero, Integer largoCasillas, Integer indice, BordeTablero bordeTablero){
        Integer espaciosOcupadosEnLasFilas = this.espaciosQueSeOcupaEnFilas( largoCasillas );
        Double anchoCasilla = this.largoLadoTablero/espaciosOcupadosEnLasFilas;
        Double altoCasilla = anchoCasilla*incrementoDeAncho();
        HashMap<String, String> informacionCasillero = casillero.obtenerInfoCasillero();
        CasilleroView casilleroView;
        switch (casillero.obtenerTipoCasillero()){
            case TRANSPORTE:
                casilleroView = new TransporteView(anchoCasilla, altoCasilla, casillero, informacionCasillero, bordeTablero.obtenerOrientacion());
                break;
            case PROPIEDAD:
                casilleroView = new PropiedadView(anchoCasilla, altoCasilla, casillero, informacionCasillero, bordeTablero.obtenerOrientacion());
                break;
            case MULTA:
                casilleroView = new CasilleroView(anchoCasilla, altoCasilla, casillero, informacionCasillero, bordeTablero.obtenerOrientacion());
                break;
            case LOTERIA:
                casilleroView = new CasilleroView(anchoCasilla, altoCasilla, casillero, informacionCasillero, bordeTablero.obtenerOrientacion());
                break;
            default :
                casilleroView = new CasilleroView(altoCasilla, altoCasilla, casillero, informacionCasillero, bordeTablero.obtenerOrientacion());
        }

        try {
            bordeTablero.agregar(casilleroView);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bordeTablero.posicionar();
    }

    private int incrementoDeAncho() {
        return 2;
    }

    private Orientacion obtenerOrientacionCorrecta(Integer indice, Integer largoLadoTablero){
         if( laCasillaActualEstaEnFila(indice, largoLadoTablero) ) return Orientacion.PORTRAIT;
         return Orientacion.LANDSCAPE;
    }

    private boolean laCasillaActualEstaEnFila(Integer indice, Integer largoLadoTablero) {
        return (indice / largoLadoTablero) % 2 == 0;
    }

    private Integer espaciosQueSeOcupaEnFilas(Integer totalDeCasillas){
        return cantidadDeEspaciosPorLado(totalDeCasillas) + 3;
    }

    private Integer cantidadDeEspaciosPorLado(Integer totalDeCasillas) {
        return totalDeCasillas / ladosDelTablero();
    }

    private int ladosDelTablero() {
        return 4;
    }


}
