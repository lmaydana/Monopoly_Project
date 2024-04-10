package org.fiuba.algo3.Casilleros.Inmueble;

import org.fiuba.algo3.Cartera.Cartera;

public class Vivienda implements Inmueble {

    private Double precioDeVenta;

    public Vivienda(Double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    @Override
    public void vender(Cartera cartera) {
        cartera.recibir(this.precioDeVenta);
    }
}
