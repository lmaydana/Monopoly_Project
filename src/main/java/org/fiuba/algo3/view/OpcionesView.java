package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class OpcionesView extends VBox {
    public OpcionesView(){
        Rectangle2D tamanioPantalla = Screen.getPrimary().getBounds();
        Double anchoUtilizable = tamanioPantalla.getWidth() - tamanioPantalla.getHeight()*0.865740741;
        this.setPrefSize(anchoUtilizable, tamanioPantalla.getHeight()*0.8);
        HBox sectorSeleccionDePropiedad = new HBox();
        Button botonIrHaciaIzquierda = new Button("<");
        Button botonIrHaciaDerecha = new Button(">");
        Double anchoCarta = anchoUtilizable/4;
        CartaDePropiedad cartaDePropiedad = this.getCartaDePropiedad(anchoCarta, anchoCarta);
        sectorSeleccionDePropiedad.getChildren().addAll(botonIrHaciaIzquierda, cartaDePropiedad, botonIrHaciaDerecha);
        sectorSeleccionDePropiedad.setMaxWidth(anchoCarta);
        Button salirDeLaCarcel = this.obtenerBotonDeOpcion("Salir de la carcel");
        Button terminarTurno = this.obtenerBotonDeOpcion("Terminar turno");
        Button construirReformar = this.obtenerBotonDeOpcion("Construir o reformar");
        Button venderConstruccion = this.obtenerBotonDeOpcion("Vender Construccion");
        Button hipotecar = this.obtenerBotonDeOpcion("Hipotecar");
        Button comprarPropiedad = this.obtenerBotonDeOpcion("Comprar propiedad");
        this.getChildren().addAll(salirDeLaCarcel, sectorSeleccionDePropiedad, terminarTurno, construirReformar, venderConstruccion, hipotecar, comprarPropiedad);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setSpacing(20);
    }

    private Button obtenerBotonDeOpcion(String texto){
        Button botonDeOpcion = new Button(texto);

        return botonDeOpcion;
    }

    private CartaDePropiedad getCartaDePropiedad(Double anchoCarta, Double altoCarta){
        /*--------------ArrayLists que se deben obtener de Config harcodeados para muestra------------------------*/
        ArrayList<String> columnaCantidadDeViviendas = new ArrayList<>();
        columnaCantidadDeViviendas.add("Viviendas");
        columnaCantidadDeViviendas.add("0 casas");
        columnaCantidadDeViviendas.add("1 casa");
        columnaCantidadDeViviendas.add("2 casas");
        columnaCantidadDeViviendas.add("3 casas");
        columnaCantidadDeViviendas.add("4 casas");
        columnaCantidadDeViviendas.add("1 hotel");
        ArrayList<String> columnaPreciosDeRentaPorConstrucciones = new ArrayList<>();
        columnaPreciosDeRentaPorConstrucciones.add("Renta");
        columnaPreciosDeRentaPorConstrucciones.add("200.0");
        columnaPreciosDeRentaPorConstrucciones.add("400.0");
        columnaPreciosDeRentaPorConstrucciones.add("600.0");
        columnaPreciosDeRentaPorConstrucciones.add("800.0");
        columnaPreciosDeRentaPorConstrucciones.add("1000.0");
        columnaPreciosDeRentaPorConstrucciones.add("1200.0");
        ArrayList<String> columnaPreciosDeCompraDeLasConstrucciones = new ArrayList<>();
        columnaPreciosDeCompraDeLasConstrucciones.add("P. Compra");
        columnaPreciosDeCompraDeLasConstrucciones.add("0.0");
        columnaPreciosDeCompraDeLasConstrucciones.add("25.0");
        columnaPreciosDeCompraDeLasConstrucciones.add("50.0");
        columnaPreciosDeCompraDeLasConstrucciones.add("75.0");
        columnaPreciosDeCompraDeLasConstrucciones.add("100.0");
        columnaPreciosDeCompraDeLasConstrucciones.add("125.0");
        ArrayList<String> columnaPreciosDeVentaDeLasConstrucciones = new ArrayList<>();
        columnaPreciosDeVentaDeLasConstrucciones.add("P. Venta");
        columnaPreciosDeVentaDeLasConstrucciones.add("0.0");
        columnaPreciosDeVentaDeLasConstrucciones.add("20.0");
        columnaPreciosDeVentaDeLasConstrucciones.add("35.0");
        columnaPreciosDeVentaDeLasConstrucciones.add("50.0");
        columnaPreciosDeVentaDeLasConstrucciones.add("70.0");
        columnaPreciosDeVentaDeLasConstrucciones.add("90.0");
        /*-------------------------------------------------------------------------------------------*/
        Image imagen = new Image("file:src/main/java/org/fiuba/algo3/view/imagenes/personaje_monopoly.png");

        return new CartaDePropiedad(anchoCarta, altoCarta, Color.RED, "El barril del chavo del 8", imagen,columnaCantidadDeViviendas, columnaPreciosDeRentaPorConstrucciones, columnaPreciosDeCompraDeLasConstrucciones, columnaPreciosDeVentaDeLasConstrucciones);

    }
}
