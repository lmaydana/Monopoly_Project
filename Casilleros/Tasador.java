package Casilleros;

import Casilleros.Inmueble.Inmueble;

import java.util.ArrayList;

public class Tasador {

    private ArrayList<Double> rentasPorCantidadDeInmuebles;

    public Tasador( ArrayList<Double> rentasPorCantidadDeInmuebles ){
        this.rentasPorCantidadDeInmuebles = rentasPorCantidadDeInmuebles;
    }

    public Double tasarTerreno(ArrayList<Inmueble> inmueblesActuales) {
        if( inmueblesActuales.size() + 1 > this.rentasPorCantidadDeInmuebles.size() )
            return rentasPorCantidadDeInmuebles.getLast();
        return this.rentasPorCantidadDeInmuebles.get(inmueblesActuales.size());
    }
}
