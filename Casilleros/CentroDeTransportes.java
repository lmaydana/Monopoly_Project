package Casilleros;

import java.util.ArrayList;

public class CentroDeTransportes {
    private ArrayList<Transporte> transportes;

    public CentroDeTransportes(){
        this.transportes = new ArrayList<>();
    }

    public void agregarTransporte(Transporte transporte){
        this.transportes.add(transporte);
    }

    public int determinarMultiplicidadDeCosto(Arrendador arrendador){
        int multiplicidad = 0;
        for (Transporte transporte: this.transportes){
            if( transporte.esElMismoPropietario(arrendador) )
                multiplicidad++;
        }

        return multiplicidad;
    }
}
