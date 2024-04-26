package org.fiuba.algo3;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.view.Apertura.DisposicionDeApertura;

import javafx.geometry.Rectangle2D;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Rectangle2D dimensionesPantalla = Screen.getPrimary().getBounds();
        Double altoPantalla = dimensionesPantalla.getHeight();
        Double anchoPantalla = dimensionesPantalla.getWidth();
        Configuracion configuracion = new Configuracion();
        //--------------------Contenedor Principal-------------------------------
        /*TableroView tablero = new TableroView(configuracion);
        BorderPane disposicionPrincipal = new BorderPane();
        disposicionPrincipal.setCenter(tablero);
        OpcionesView opcionesView = new OpcionesView(juego);
        disposicionPrincipal.setRight(opcionesView);*/
        //--------------------------------------------------
        DisposicionDeApertura disposicionDeApertura = new DisposicionDeApertura(configuracion, stage);
        disposicionDeApertura.setAlignment(Pos.CENTER);
        Scene scene = new Scene(disposicionDeApertura, anchoPantalla, altoPantalla*0.865740741);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



