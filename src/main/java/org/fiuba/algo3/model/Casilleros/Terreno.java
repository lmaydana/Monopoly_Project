package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.model.Jugador.Transferible;

import java.util.ArrayList;

public class Terreno {
    private ArrayList<Inmueble> inmueblesActuales;
    private ArrayList<Inmueble> inmueblesPorPoner;
    private Tasador tasador;

    private Double rentaBase;

    public Terreno(ArrayList<Inmueble> inmueblesPorPoner){
        this.inmueblesPorPoner = inmueblesPorPoner;
        this.inmueblesActuales = new ArrayList<>();
        this.rentaBase = 0.0;
        this.rentaBase = this.inmueblesPorPoner.removeFirst().devolverRentaSumadaA(this.rentaBase);
        this.tasador = new Tasador();
    }

    public void edificar(Cartera cartera) throws CantidadInsuficiente {
        Inmueble inmuebleAPoner = this.inmueblesPorPoner.removeFirst();
        inmuebleAPoner.comprar(cartera);
        this.inmueblesActuales.add(inmuebleAPoner);
    }

    public Double tasar( ){
        return this.rentaBase + this.tasador.tasarTerreno(this.inmueblesActuales);
    }

    public void venderInmueble(Transferible transferible){
            Inmueble inmueble = this.inmueblesActuales.removeLast();
            inmueble.vender(transferible);
            this.inmueblesPorPoner.addFirst(inmueble);
    }
}
