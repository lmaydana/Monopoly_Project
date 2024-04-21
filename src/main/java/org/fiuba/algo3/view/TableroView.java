package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class TableroView extends BorderPane {
    public TableroView(){
        double alturaTotalUtilizable = (Screen.getPrimary().getBounds().getHeight()*0.865740741);
        this.setPrefSize(alturaTotalUtilizable, alturaTotalUtilizable);
        Image centroMonopolio = new Image("file:src/main/java/org/fiuba/algo3/view/imagenes/Monopoly-Logo-2008.png");
        ImageView centroMonopolioImageView = new ImageView(centroMonopolio);
        centroMonopolioImageView.setFitWidth(alturaTotalUtilizable*0.25);
        centroMonopolioImageView.setPreserveRatio(true);
        VBox contenedorCentral = new VBox();
        contenedorCentral.setAlignment(Pos.CENTER);
        centroMonopolioImageView.setRotate(45);
        contenedorCentral.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #5cd781, #577fe5 100%);");
        contenedorCentral.getChildren().add(new Group(centroMonopolioImageView));
        this.setCenter(contenedorCentral);
        Double anchoCasilla = alturaTotalUtilizable/7;
        Double altoCasilla = anchoCasilla*2;
        String direccion = "file:src/main/java/org/fiuba/algo3/view/imagenes/personaje_monopoly.png";
        CasilleroView cv = new CasilleroView(altoCasilla, altoCasilla, direccion, "Casilla de paso", Orientacion.PORTRAIT);
        HBox filaAbajo = new HBox(cv,new PropiedadView( anchoCasilla, altoCasilla, Color.RED, direccion, "La casa de donia florinda", "$30000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "La escuela del profesor jirafales","$30000", Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "La peluqueria de Don Ramon", "$35000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "La casa del senior Barriga", "$50000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "El barril del Chavo del 8", "$55000",Orientacion.PORTRAIT));
        VBox columnaIzquierda = new VBox(new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN,direccion,"La casa de la bruja del 71","$30000", Orientacion.LANDSCAPE),new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La casa de Jaimito", "$1000000", Orientacion.LANDSCAPE), new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion,  "La casa de Don Ramon", "$200000", Orientacion.LANDSCAPE));
        HBox filaArriba = new HBox(new PropiedadView( anchoCasilla, altoCasilla, Color.RED, direccion, "La fonda de donia florinda", "$10000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.RED, direccion, "La pileta de Acapulco", "$25000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.RED, direccion, "La casa de donia florinda", "$30000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "La escuela del profesor jirafales","$30000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "La peluqueria de Don Ramon", "$35000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "La casa del senior Barriga", "$50000",Orientacion.PORTRAIT),new PropiedadView( anchoCasilla, altoCasilla, Color.ORANGE, direccion, "El barril del Chavo del 8", "$55000",Orientacion.PORTRAIT));
        PropiedadView p = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La fuente de la vecindad", "$250000",Orientacion.LANDSCAPE);
        PropiedadView p2 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La fuente de la vecindad", "$250000",Orientacion.LANDSCAPE);
        TransporteView p3 = new TransporteView( anchoCasilla, altoCasilla, direccion,"El coche del señor Barriga","$30000",Orientacion.LANDSCAPE);
        VBox columnaDerecha = new VBox(p,p2,p3);
        PropiedadView p4 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La fuente de la vecindad", "$250000",Orientacion.PORTRAIT);
        PropiedadView p5 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La fuente de la vecindad", "$250000",Orientacion.PORTRAIT);
        PropiedadView p6 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN,direccion,"La casa de la bruja del 71","$30000",Orientacion.PORTRAIT);
        PropiedadView p7 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La fuente de la vecindad", "$250000",Orientacion.PORTRAIT);
        PropiedadView p8 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN, direccion, "La fuente de la vecindad", "$250000",Orientacion.PORTRAIT);
        PropiedadView p9 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN,direccion,"La casa de la bruja del 71","$30000",Orientacion.PORTRAIT);
        PropiedadView p10 = new PropiedadView( anchoCasilla, altoCasilla, Color.BROWN,direccion,"La casa de la bruja del 71","$30000",Orientacion.PORTRAIT);
        HBox pruebav = new HBox(new Group(p4),new Group(p5), new Group(p6));
        pruebav.setRotate(90);
        pruebav.setPrefWidth((Screen.getPrimary().getBounds().getHeight()-150)/7);
        //columnaIzquierda.setRotate(Orientacion.IZQUIERDA.obtenerGrados());
        filaArriba.setRotate(180);
        columnaIzquierda.setRotate(180);
        columnaIzquierda.setPrefWidth((Screen.getPrimary().getBounds().getHeight()-150)/7);
        this.setBottom(filaAbajo);
        this.setLeft(new Group(columnaIzquierda));
        //this.setLeft(new Group(pruebav));
        this.setTop(filaArriba);
        columnaDerecha.setPrefWidth((Screen.getPrimary().getBounds().getHeight()-150)/7);
        this.setRight(new Group(columnaDerecha));
    }
}
