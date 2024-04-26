package org.fiuba.algo3.view.Principal.Tablero;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public interface BordeTablero {
    BordeTablero obtenerSiguienteBorde(BorderPane disposicion);

    void agregar(Node vista);

    void darVuelta();

    void posicionar();

    Orientacion obtenerOrientacion();
}