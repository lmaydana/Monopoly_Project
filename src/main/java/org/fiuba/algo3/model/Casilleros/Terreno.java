package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.model.Jugador.Transferible;

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

    public void venderInmuebles(int cantidadAVender, Transferible transferible){
        for( int i = 0; !this.inmueblesActuales.isEmpty() && i < cantidadAVender; i ++) {
            Inmueble inmueble = this.inmueblesActuales.removeLast();
            inmueble.vender(transferible);
            this.inmueblesPorPoner.addFirst(inmueble);
        }
    }
}
