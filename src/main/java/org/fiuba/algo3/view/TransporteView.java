package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Configuracion;

public class TransporteView extends CasilleroView{

    protected Label propietario;

    public TransporteView(Double anchoCasilla, Double altoCasilla, Casillero casillero, Orientacion orientacion, Configuracion configuracion) {
        super(anchoCasilla, altoCasilla, casillero, orientacion, configuracion);
        this.orientacion = orientacion;
        Label precio = new Label(this.informacionCasillero.get("precio"));
        this.setearFormatoEtiqueta(precio);
        this.propietario = new Label("Dueño: " +this.informacionCasillero.get("propietario"));
        this.setearFormatoEtiqueta(this.propietario);
        cajaInformacion.getChildren().addFirst(new Group(propietario));
        this.cajaInformacion.getChildren().add(new Group(precio));
    }

    protected void setearFormatoEtiqueta( Label etiqueta ){
        etiqueta.setMaxWidth(this.anchoCasilla);
        etiqueta.setMaxHeight(altoMaximoEtiqueta());
        etiqueta.setWrapText(true);
        etiqueta.setFont(new Font(10));
        etiqueta.setAlignment(Pos.CENTER);
        etiqueta.setTextAlignment(TextAlignment.CENTER);
        etiqueta.setRotate(this.orientacion.obtenerGrados());
    }

    @Override
    public void dibujar() {
        super.dibujar();
        this.casillero.aportarInformacionCasillero(this.informacionCasillero);
        this.dibujarEtiqueta();
    }

    public void dibujarEtiqueta(){
        this.propietario.setText("Dueño: " +this.informacionCasillero.get("propietario"));
    }

    protected String claveTexto() {
        return "nombre";
    }

    public Double altoMaximoEtiqueta() {
        return super.altoMaximoNombre();
    }

    protected Double anchoMaximoPrecio() {
        return super.anchoImagen();
    }
}
