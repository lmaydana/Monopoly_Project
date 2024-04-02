package Casilleros;

import java.util.ArrayList;

public class Terreno {
    private Arrendador arrendador;
    private ArrayList<Inmueble> inmueblesActuales;
    private ArrayList<Inmueble> inmueblesPorPoner;
    private Tasador tasador;

    public Terreno(ArrayList<Inmueble> inmueblesPorPoner, Tasador tasador, Arrendador arrendador){
        this.inmueblesPorPoner = inmueblesPorPoner;
        this.inmueblesActuales = new ArrayList<>();
        this.tasador = tasador;
        this.arrendador = arrendador;
    }

    public void edificar(){
        this.inmueblesActuales.add(this.inmueblesPorPoner.removeFirst());
    }

    public Double tasar( ){
        return this.tasador.tasarTerreno(this.inmueblesActuales);
    }

    public void venderInmuebles(int cantidadAVender){
        for( int i = 0; !this.inmueblesActuales.isEmpty() && i < cantidadAVender; i ++) {
            Inmueble inmueble = this.inmueblesActuales.removeLast();
            inmueble.vender();
            this.inmueblesPorPoner.addFirst(inmueble);
        }
    }
}
