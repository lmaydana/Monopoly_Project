package org.fiuba.algo3.model.Casilleros.Inmueble;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;

public class Vivienda implements Inmueble {

    private Double precioDeVenta;
    private final Double costoDeCompra;
    private final Double costoDeRenta;
    private final Banco banco;


    public Vivienda(Double precioDeVenta, Double costoDeCompra, Double costoDeRenta, Banco banco ) {
        this.precioDeVenta = precioDeVenta;
        this.costoDeCompra = costoDeCompra;
        this.costoDeRenta = costoDeRenta;
        this.banco = banco;
    }

    @Override
    public void vender(org.fiuba.algo3.model.Jugador.Transferible transferible) {
        banco.transferir(this.precioDeVenta, transferible);
    }

    @Override
    public void comprar(Cartera cartera) throws CantidadInsuficiente {
        cartera.transferir(this.costoDeCompra, this.banco);
    }

    @Override
    public Double devolverRentaSumadaA(Double rentaActual) {
        return this.costoDeRenta + rentaActual;
    }
}
