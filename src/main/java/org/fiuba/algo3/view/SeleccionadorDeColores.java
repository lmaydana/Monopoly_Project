package org.fiuba.algo3.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.ArrayList;

public class SeleccionadorDeColores extends ComboBox<Color> {

    private ArrayList<Color> coloresSeleccionables;
    private Color colorActual;

    public SeleccionadorDeColores(ArrayList<Color> coloresSeleccionables){
        this.coloresSeleccionables = coloresSeleccionables;
        this.colorActual = null;
        this.definirVista();
    }




    private void definirVista() {

        this.setButtonCell(new ListCell<>(){
            @Override
            protected void updateItem(Color color, boolean b) {
                super.updateItem(color, b);
                if (color == null || b) {
                    setGraphic(null);
                }else {
                    Rectangle rectangulo = new Rectangle(15, 15);
                    rectangulo.setStroke(Color.BLACK);
                    rectangulo.setStrokeWidth(2);
                    rectangulo.setFill(color);
                    setGraphic(rectangulo);
                }
            }
        });
        this.setCellFactory(new Callback<>() {

            @Override
            public ListCell<Color> call(ListView<Color> colorListView) {
                return new ListCell<>(){

                    @Override
                    protected void updateItem(Color color, boolean b) {
                        super.updateItem(color, b);
                        if (color == null || b) {
                            setGraphic(null);
                        }else {
                            Rectangle rectangulo = new Rectangle(20, 20);
                            rectangulo.setStroke(Color.BLACK);
                            rectangulo.setStrokeWidth(2);
                            rectangulo.setFill(color);
                            setGraphic(rectangulo);
                        }

                    }
                };
            }
        });
    }


}
