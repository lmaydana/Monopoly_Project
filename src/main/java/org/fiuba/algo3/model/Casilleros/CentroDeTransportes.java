package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;

import java.util.ArrayList;

public class CentroDeTransportes {
    private ArrayList<Transporte> transportes;

    public CentroDeTransportes(){
        this.transportes = new ArrayList<>();
    }

    public void agregarTransporte(Transporte transporte){
        this.transportes.add(transporte);
    }

    private int determinarMultiplicidadDeCosto(Arrendador arrendador){
        int multiplicidad = 0;
        for (Transporte transporte: this.transportes){
            if( transporte.tieneArrendador(arrendador) )
                multiplicidad++;
        }

        return multiplicidad;
    }

    private boolean esCompaniero(Arrendador arrendador) {
        boolean esCompaniero = false;
        for (Transporte transporte: this.transportes){
            if (transporte.tieneArrendador(arrendador)){
                esCompaniero = true;
            }
        }

        return esCompaniero;
    }

    public Double devolverPrecioTotal(Arrendador arrendadorDeTransporte, Arrendador arrendadorLLegado, Double precioBase){
        if( this.esCompaniero(arrendadorLLegado) ) {
            return 0.0;
        }
        int multiplicidad = this.determinarMultiplicidadDeCosto(arrendadorDeTransporte);
        return precioBase*multiplicidad;
    }
}
