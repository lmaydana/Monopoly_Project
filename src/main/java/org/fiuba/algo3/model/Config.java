package org.fiuba.algo3.model;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Parsers.RecursosExternos;
import org.fiuba.algo3.model.Tablero.ListaCircular;

import java.util.HashMap;

public class Config {

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

    public Config(){
        this.parsers = new RecursosExternos();
    }

    public HashMap<Casillero, HashMap<String, String>> obtenerInfoCasilleros(){
        return this.parsers.obtenerInfoCasilleros();
    }

    public ListaCircular<Casillero> obtenerCasilleros(){
        return this.parsers.obtenerCasilleros();
    }

    public Double obtenerMontoDePlataIncial() {
        return this.cantDineroJugadorInicial;
    }
}
