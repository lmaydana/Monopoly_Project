package org.fiuba.algo3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.fiuba.algo3.model.Tablero.Tablero;
import org.fiuba.algo3.view.OpcionesView;
import org.fiuba.algo3.view.TableroView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        System.out.println("Alto pantalla:" + screenHeight);
        TableroView t = new TableroView();
        BorderPane b = new BorderPane();
        b.setCenter(t);
        OpcionesView opcionesView = new OpcionesView();
        b.setRight(opcionesView);
        Scene scene = new Scene(b, screenHeight*0.865740741, screenHeight*0.865740741);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



