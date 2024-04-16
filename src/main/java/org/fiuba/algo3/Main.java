package org.fiuba.algo3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.fiuba.algo3.view.Consola;
import org.fiuba.algo3.view.TableroView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new TableroView(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



