package org.fiuba.algo3.model.Casilleros;


import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class Transporte extends CasillaComprable{

    private Double costoRenta;

    private CentroDeTransportes centroDeTransportes;


    public Transporte(String nombreTransporte, Double costoDeVenta, Double costoRenta, CentroDeTransportes centroDeTransportes) {
        super(nombreTransporte, costoDeVenta);
        this.costoRenta = costoRenta;
        this.centroDeTransportes = centroDeTransportes;
    }

    @Override
    public Double tasar() {
        return this.centroDeTransportes.devolverPrecioTotal(this.arrendador, this.costoRenta);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.TRANSPORTE;
    }

    public HashMap<String, String> obtenerInfoCasillero(){
        HashMap<String, String> infoCasillero = super.obtenerInfoCasillero();
        infoCasillero.put("tipo", "Transporte");
        return infoCasillero;
    }

}
