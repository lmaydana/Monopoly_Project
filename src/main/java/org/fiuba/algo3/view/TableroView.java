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
        this.agregarBordesDelTablero(config);
        this.crearCentroDelTablero();
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

    private void agregarBordesDelTablero(Config config) {
        ListaCircular<Casillero> casillas = config.obtenerCasilleros();
        Integer cantidadDeCasillasPorLado = casillas.getLen() / ladosDelTablero();
        this.casilleros = new ArrayList<>();
        BordeTablero bordeTablero = new FilaTablero(cantidadDeCasillasPorLado, 0, this);
        for (int i = 0; i < casillas.getLen(); i++){
            bordeTablero = bordeTablero.obtenerSiguienteBorde(this);
            this.llenarConCasilleroCorrespondiente(casillas.get(i), casillas.getLen(), i, bordeTablero);
        }

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
