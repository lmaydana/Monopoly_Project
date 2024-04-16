package org.fiuba.algo3.view;

import javafx.scene.layout.*;
import javafx.scene.image.Image;

public class TableroView extends BorderPane {
    public TableroView(){
        Image centroMonopolio = new Image("file:/home/lionel/tps_paradigmas/polimorphic/src/main/java/org/fiuba/algo3/view/imagenes/tablero.png");
        BackgroundImage backgroundImage = new BackgroundImage(centroMonopolio, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        VBox contenedorCentral = new VBox();
        contenedorCentral.setBackground(new Background(backgroundImage));
        this.setCenter(contenedorCentral);
    }
}
