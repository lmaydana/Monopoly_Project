package Casilleros;

import java.util.ArrayList;

public abstract class CasillaComprable implements Casillero, Comprable {
    private Double costoDeVenta;
    protected Arrendador arrendador;
    private Ofertador ofertador;

    public CasillaComprable(Double costoDeVenta){
        this.arrendador = new ArrendadorDeVenta();
        this.ofertador = new OfertadorDePropiedad(this);
        this.costoDeVenta = costoDeVenta;
    }

    @Override
    public void seCompradaPor(Comprador comprador) throws CantidadInsuficiente{
        comprador.transferir(this.costoDeVenta, this.arrendador);
        arrendador.cesarPropiedad(this, comprador);
        this.arrendador = comprador.tranformarEnArrendador();
        this.ofertador = new OfertadorNulo();
    }

    @Override
    public void recibirJugador(Jugador jugador) {

        if( !this.esElMismoPropietario(jugador) ) {
            this.ofertador.ofertar(jugador);
            this.arrendador.acordar(jugador, this);
        }

    }

    public abstract Double tasar();

    public boolean esElMismoPropietario(Arrendador arrendador) {
       return this.arrendador.equals(arrendador);
    }
}
