package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Casilleros.Inmueble.Inmueble;

import java.util.ArrayList;

public class Terreno {
    private ArrayList<Inmueble> inmueblesActuales;
    private ArrayList<Inmueble> inmueblesPorPoner;
    private Tasador tasador;

    public Terreno(ArrayList<Inmueble> inmueblesPorPoner, Tasador tasador){
        this.inmueblesPorPoner = inmueblesPorPoner;
        this.inmueblesActuales = new ArrayList<>();
        this.tasador = tasador;}

    public void edificar(){
        this.inmueblesActuales.add(this.inmueblesPorPoner.removeFirst());
    }

    public Double tasar( ){
        return this.tasador.tasarTerreno(this.inmueblesActuales);
    }

    public void venderInmuebles(int cantidadAVender, Cartera cartera){
        for( int i = 0; !this.inmueblesActuales.isEmpty() && i < cantidadAVender; i ++) {
            Inmueble inmueble = this.inmueblesActuales.removeLast();
            inmueble.vender(cartera);
            this.inmueblesPorPoner.addFirst(inmueble);
        }
    }
}
