package org.fiuba.algo3.model.Parsers;


import javafx.scene.paint.Color;
import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Casilleros.Carcel;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Casilleros.IrALaCarcel;
import org.fiuba.algo3.model.Tablero.ListaCircular;

import java.util.ArrayList;
import java.util.HashMap;

public class RecursosExternos {

    private TableroJsonParser tableroJsonParser;

    public RecursosExternos() {
        String rutaArchivoTableroJson = "src/main/java/org/fiuba/algo3/model/JSONFiles/tablero.json";
        try {
            this.tableroJsonParser = new TableroJsonParser(rutaArchivoTableroJson);
        } catch (InvalidJson e) {
            throw new RuntimeException(e);
        }
    }

  public ListaCircular<Casillero> obtenerCasilleros(){
        return this.tableroJsonParser.obtenerCasilleros();
  }

    public HashMap<Casillero, HashMap<String, String>> obtenerInfoCasilleros() {
        return this.tableroJsonParser.obtenerInfoCasilleros();
    }

    public ArrayList<String>[] obtenerInformacionInmueblesSobre( String nombrePropiedad){
        return this.tableroJsonParser.obtenerInformacionInmueblesSobre(nombrePropiedad);
    }

    public Color obtenerColorDePropiedad(String nombrePropiedad ){
        return this.tableroJsonParser.obtenerColorDePropiedad(nombrePropiedad);
    }

    public Banco obtenerBanco(){
        return this.tableroJsonParser.obtenerBanco();
    }

    public Carcel obtenerCarcel() {
        return this.tableroJsonParser.obtenerCarcel();
    }

    public String obtenerDireccionImagen(String nombreCasillero){
        return this.tableroJsonParser.obtenerDireccionImagen(nombreCasillero);
    }

    public ArrayList<IrALaCarcel> obtenerCasillerosIrALacarcel() {
        return this.tableroJsonParser.obtenerCasillerosIrALa8Carcel();
    }
}
