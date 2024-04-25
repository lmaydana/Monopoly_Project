package org.fiuba.algo3.model.Casilleros;

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
        return this.centroDeTransportes.devolverPrecioTotal(this.arrendador, this.jugdoresEnCassila.getLast(), this.costoRenta);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.TRANSPORTE;
    }

    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero){
        super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("tipo", "Transporte");
    }

}
