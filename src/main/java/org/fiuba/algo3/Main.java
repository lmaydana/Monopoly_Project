package org.fiuba.algo3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.fiuba.algo3.model.Tablero.Tablero;
import org.fiuba.algo3.view.OpcionesView;
import org.fiuba.algo3.view.TableroView;

import javafx.geometry.Rectangle2D;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Rectangle2D dimensionesPantalla = Screen.getPrimary().getBounds();
        Double altoPantalla = dimensionesPantalla.getHeight();
        Double anchoPantalla = dimensionesPantalla.getWidth();
        TableroView tablero = new TableroView();
        BorderPane disposicionPrincipal = new BorderPane();
        disposicionPrincipal.setCenter(tablero);
        OpcionesView opcionesView = new OpcionesView();
        disposicionPrincipal.setRight(opcionesView);
        Scene scene = new Scene(disposicionPrincipal, anchoPantalla, altoPantalla*0.865740741);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



