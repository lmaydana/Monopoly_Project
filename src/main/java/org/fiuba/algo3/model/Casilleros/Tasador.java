package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;

import java.util.ArrayList;

public class Tasador {

    public Double tasarTerreno(ArrayList<Inmueble> inmueblesActuales) {
        Double rentaTotal = 0.0;
        for( Inmueble inmueble: inmueblesActuales ){
            rentaTotal = inmueble.devolverRentaSumadaA(rentaTotal);
        }
        return rentaTotal;
    }
}
