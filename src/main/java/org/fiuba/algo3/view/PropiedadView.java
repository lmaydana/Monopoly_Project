package org.fiuba.algo3.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.fiuba.algo3.model.Casilleros.Casillero;

import java.util.HashMap;

public class PropiedadView extends TransporteView {

    public PropiedadView(Double anchoCasilla, Double altoCasilla, Casillero casillero, HashMap<String, String> informacionCasillero, String direccionImagen, Orientacion orientacion) {
        super(anchoCasilla, altoCasilla, casillero, informacionCasillero, direccionImagen, orientacion);
        Rectangle sectorViviendas = new Rectangle(0,0, obtenerProyeccion(anchoSectorViviendas(), altoSectorViviendas()), obtenerProyeccion(altoSectorViviendas(), anchoSectorViviendas()));
        sectorViviendas.setStroke(Color.BLACK);
        Color color = Color.valueOf(this.informacionCasillero.get("color"));
        sectorViviendas.setFill(color);
        sectorViviendas.setStrokeWidth(3);
        this.getChildren().add(sectorViviendas);
    }

    public PropiedadView(Double anchoCasilla, Double altoCasilla, Casillero casillero, HashMap<String, String> informacionCasillero, Orientacion orientacion) {
        super(anchoCasilla, altoCasilla, casillero, informacionCasillero, rutaImagenPorDefecto(), orientacion);
        Rectangle sectorViviendas = new Rectangle(0,0, obtenerProyeccion(anchoSectorViviendas(), altoSectorViviendas()), obtenerProyeccion(altoSectorViviendas(), anchoSectorViviendas()));
        sectorViviendas.setStroke(Color.BLACK);
        Color color = Color.valueOf(this.informacionCasillero.get("color"));
        sectorViviendas.setFill(color);
        sectorViviendas.setStrokeWidth(3);
        this.getChildren().add(sectorViviendas);
    }

    protected Double anchoSectorViviendas(){
        return anchoCasilla;
    }

    protected Double altoSectorViviendas(){
        return this.altoMaximoNombre();
    }

}