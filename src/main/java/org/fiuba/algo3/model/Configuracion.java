package org.fiuba.algo3.model;
import javafx.scene.paint.Color;
import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Casilleros.Carcel;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Casilleros.IrALaCarcel;
import org.fiuba.algo3.model.Parsers.RecursosExternos;
import org.fiuba.algo3.model.Tablero.ListaCircular;

import java.util.ArrayList;
import java.util.HashMap;

public class Configuracion {

    public Integer cantTotalCasillas = 50;
    protected Integer cantCasillasPaso = 16;
    protected Integer cantCasillasPropiedades = 21;
    protected Integer cantCasillasLoterias = 4;
    protected Integer cantCasillasMulta= 2;
    protected Integer cantCasillasIrCarcel = 1;
    protected Integer cantCasillasCarcel = 1;
    protected Integer cantCasillasTransporte = 4;

    protected Double cantDineroJugadorInicial = 1500.0;
    protected Double cantDineroCasilleroInicial = 500.0;

    RecursosExternos parsers;
    private Integer cantidadMaximaDeJugadores = 4;

    private Double fianza = 50.0;

    private ArrayList<Color> coloresJugadores;

    public Configuracion(){
        this.parsers = new RecursosExternos();
        this.coloresJugadores = new ArrayList<>();
    }

    private void cargarColoreJugadores(){
        this.coloresJugadores.add(Color.BLUE);
        this.coloresJugadores.add(Color.RED);
        this.coloresJugadores.add(Color.GREEN);
        this.coloresJugadores.add(Color.YELLOW);
    }

    public ArrayList<Color> obtenerColoresJugadores(){
        return coloresJugadores;
    }

    public HashMap<Casillero, HashMap<String, String>> obtenerInfoCasilleros(){
        return this.parsers.obtenerInfoCasilleros();
    }

    public Color obtenerColorDePropiedad(String nombrePropiedad ){
        return this.parsers.obtenerColorDePropiedad(nombrePropiedad);
    }

    public Banco obtenerBanco(){
        return this.parsers.obtenerBanco();
    }

    public ListaCircular<Casillero> obtenerCasilleros(){
        return this.parsers.obtenerCasilleros();
    }

    public ArrayList<ArrayList<String>> obtenerInformacionDeInmueblesSobre( String nombrePropiedad){
        return this.parsers.obtenerInformacionInmueblesSobre(nombrePropiedad);
    }

    public Double obtenerMontoDePlataIncial() {
        return this.cantDineroJugadorInicial;
    }

    public Integer obtenerCantidadMaximaDeJugadores(){
        return this.cantidadMaximaDeJugadores;
    }

    public Double obtnerMontoFianza(){
        return this.fianza;
    }

    public Carcel obtenerCarcel() {
        return this.parsers.obtenerCarcel();
    }

    public ArrayList<IrALaCarcel> obtenerCasillerosIrALaCarcel() {
        return this.parsers.obtenerCasillerosIrALacarcel();
    }
}
