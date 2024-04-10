package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Casilleros.Arrendador.Arrendador;

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

    public boolean esCompaniero(Arrendador arrendador) {
        boolean esCompaniero = false;
        for (Transporte transporte: this.transportes){
            if (transporte.tieneArrendador(arrendador)){
                esCompaniero = true;
            }
        }

        return esCompaniero;
    }

    public Double devolverPrecioTotal(Arrendador arrendador, Double precioBase){
        int multiplicidad = this.determinarMultiplicidadDeCosto(arrendador);
        return precioBase*multiplicidad;
    }
}
