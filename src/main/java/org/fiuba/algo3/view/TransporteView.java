package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import org.fiuba.algo3.model.Casilleros.Casillero;

import java.util.HashMap;

public class TransporteView extends CasilleroView{

    private Orientacion orientacion;

    public TransporteView(Double anchoCasilla, Double altoCasilla, Casillero casillero, HashMap<String, String> informacionCasillero, String direccionImagen, Orientacion orientacion) {
        super(anchoCasilla, altoCasilla, casillero, informacionCasillero, direccionImagen, orientacion);
        this.orientacion = orientacion;
        Label precio = new Label(this.informacionCasillero.get("precio"));
        precio.setMaxWidth(anchoMaximoPrecio());
        precio.setMaxHeight(altoMaximoPrecio());
        precio.setWrapText(true);
        precio.setAlignment(Pos.CENTER);
        precio.setRotate(this.orientacion.obtenerGrados());
        this.cajaInformacion.getChildren().add(new Group(precio));
    }

    public TransporteView(Double anchoCasilla, Double altoCasilla, Casillero casillero, HashMap<String, String> informacionCasillero, Orientacion orientacion){
        this(anchoCasilla, altoCasilla, casillero,informacionCasillero,rutaImagenPorDefecto(), orientacion);
    }

    protected String obtenerTextoCasilla(){
        return this.casillero.obtenerInfoCasillero().get("nombre");
    }

    public Double altoMaximoPrecio() {
        return super.altoMaximoNombre();
    }

    protected Double anchoMaximoPrecio() {
        return super.anchoImagen();
    }
}
