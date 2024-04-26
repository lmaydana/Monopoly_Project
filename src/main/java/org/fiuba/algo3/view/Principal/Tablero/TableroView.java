package org.fiuba.algo3.view.Principal.Tablero;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.Tablero.ListaCircular;
import org.fiuba.algo3.view.Principal.Tablero.Casilleros.CasilleroView;
import org.fiuba.algo3.view.Principal.Tablero.Casilleros.PropiedadView;
import org.fiuba.algo3.view.Principal.Tablero.Casilleros.TransporteView;

import java.util.ArrayList;

public class TableroView extends BorderPane {

    private ArrayList<CasilleroView> casilleros;
    private Double largoLadoTablero;

    private Configuracion configuracion;

    public TableroView( Configuracion configuracion ){
        this.configuracion = configuracion;
        this.largoLadoTablero = (Screen.getPrimary().getBounds().getHeight() * factorCantidadUtilizable());
        this.setPrefSize(largoLadoTablero, largoLadoTablero);
        this.agregarBordesDelTablero(configuracion);
        this.agregarCentroDelTablero();
    }

    private void agregarCentroDelTablero() {
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

    private void agregarBordesDelTablero(Configuracion config) {
        ListaCircular<Casillero> casillas = config.obtenerCasilleros();
        Integer cantidadDeCasillasPorLado = casillas.getLen() / ladosDelTablero();
        this.casilleros = new ArrayList<>();
        BordeTablero bordeTablero = new FilaTablero(cantidadDeCasillasPorLado, 0, this);
        for (int i = 0; i < casillas.getLen(); i++){
            bordeTablero = bordeTablero.obtenerSiguienteBorde(this);
            this.llenarConCasilleroCorrespondiente(casillas.get(i), casillas.getLen(), bordeTablero, i);
        }
    }

    private void llenarConCasilleroCorrespondiente(Casillero casillero, Integer cantidadDeCasillerosEnElTablero, BordeTablero bordeTablero, Integer indice) {
        Integer espaciosOcupadosEnLasFilas = this.espaciosQueSeOcupanEnFilas(cantidadDeCasillerosEnElTablero);
        Double anchoCasilla = this.largoLadoTablero / espaciosOcupadosEnLasFilas;
        Double altoCasilla = anchoCasilla * incrementoDeAncho();
        anchoCasilla *= incrementoPorPosicion(indice, cantidadDeCasillerosEnElTablero);
        CasilleroView casilleroView;
        switch (casillero.obtenerTipoCasillero()){
            case TRANSPORTE:
                casilleroView = new TransporteView(anchoCasilla, altoCasilla, casillero, bordeTablero.obtenerOrientacion(), this.configuracion);
                break;
            case PROPIEDAD:
                casilleroView = new PropiedadView(anchoCasilla, altoCasilla, casillero, bordeTablero.obtenerOrientacion(), this.configuracion);
                break;
            default :
                casilleroView = new CasilleroView(anchoCasilla, altoCasilla, casillero, bordeTablero.obtenerOrientacion(), this.configuracion);
        }

        bordeTablero.agregar(casilleroView);
        this.casilleros.add(casilleroView);
        bordeTablero.posicionar();
    }

    private Double incrementoPorPosicion(Integer indice, Integer cantidadDeCasillerosEnElTablero) {
        if(esEsquina(cantidadDeCasillerosEnElTablero, indice)){
            return 2.0;
        }
        return 1.0;
    }

    private boolean esEsquina(Integer cantidadDeCasillerosEnElTablero, Integer indice) {
        return (indice % this.cantidadDeEspaciosPorLado(cantidadDeCasillerosEnElTablero)) == 0;
    }

    private String obtenerDireccionImagenCentral() {
        return "file:src/main/java/org/fiuba/algo3/view/imagenes/Monopoly-Logo-2008.png";
    }

    private double factorAnchoImagenCentral() {
        return 0.25;
    }

    private double factorCantidadUtilizable() {
        return 0.865740741;
    }

    private int incrementoDeAncho() {
        return 2;
    }

    private Integer espaciosQueSeOcupanEnFilas(Integer totalDeCasillas){
        return cantidadDeEspaciosPorLado(totalDeCasillas) + espaciosDeMasOcupadosPorLasEsquinas();
    }

    private int espaciosDeMasOcupadosPorLasEsquinas() {
        return 3;
    }

    private Integer cantidadDeEspaciosPorLado(Integer totalDeCasillas) {
        return totalDeCasillas / ladosDelTablero();
    }

    private int ladosDelTablero() {
        return 4;
    }


    public void dibujar() {
        for (CasilleroView casillero : this.casilleros){
            casillero.dibujar();
        }
    }
}
