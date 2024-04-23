package org.fiuba.algo3.view;

import javafx.scene.paint.Color;
import org.fiuba.algo3.model.Juego;

import java.util.ArrayList;

public class CartaDePropiedadVacia extends CartaDePropiedad{
    public CartaDePropiedadVacia(Double anchoCarta, Double altoCarta, Juego juego) {
        super(anchoCarta, altoCarta, Color.WHITE, "", juego, new ArrayList<>());
    }
}
