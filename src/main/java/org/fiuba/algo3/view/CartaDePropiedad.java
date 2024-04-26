package org.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Juego;

import java.util.ArrayList;

public class CartaDePropiedad extends VBox {

    private final String nombre;
    private final Juego juego;

    public CartaDePropiedad(Double anchoCarta, Double altoCarta, Color color, String nombre, Juego juego, ArrayList<String>... infoTabla) {
        this.nombre = nombre;
        this.juego = juego;
        Rectangle marcoConColor = new Rectangle(0,0, anchoCarta, altoCarta*0.2);
        marcoConColor.setStroke(null);
        marcoConColor.setFill(color);
        Label nombreEtiqueta = new Label(nombre);
        GridPane tabla = this.devolverTabla(infoTabla);
        tabla.setPrefWidth(anchoCarta);
        tabla.setPrefHeight(altoCarta*0.8);
        setMargin(marcoConColor, Insets.EMPTY);
        setMargin(nombreEtiqueta, Insets.EMPTY);
        setMargin(tabla, Insets.EMPTY);
        this.getChildren().add(marcoConColor);
        this.getChildren().add(nombreEtiqueta);
        this.getChildren().add(tabla);
        tabla.setAlignment(Pos.CENTER);
        Border borde = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));
        this.setBorder(borde);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setAlignment(Pos.CENTER);
    }

    private GridPane devolverTabla(ArrayList<String>... infoTabla){
        GridPane tabla = new GridPane(infoTabla.length,infoTabla[0].size());
        for( int i = 0; i < infoTabla.length; i++){
            ArrayList<String> campo = infoTabla[i];
            for(int  j = 0; j < campo.size(); j++) {
                tabla.add(this.obtenerEtiqueta(campo.get(j)), i, j );
            }
        }
        Border borde = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));
        tabla.setBorder(borde);
        return tabla;
    }

    private Label obtenerEtiqueta(String texto){
        Label etiqueta = new Label(texto);
        etiqueta.setTextAlignment(TextAlignment.CENTER);
        return etiqueta;
    }

    public void construirVivienda() {
            juego.construirEn(this.nombre);
    }

    public void venderConstruccion() {
        this.juego.venderConstruccion(this.nombre);
    }

    public void hipotecar() {
        this.juego.hipotecar(this.nombre);
    }

    public void deshipotecar() {
        this.juego.deshipotecar(this.nombre);
    }
    
}
