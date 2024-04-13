package org.fiuba.algo3.model.Casilleros.Inmueble;

import org.fiuba.algo3.model.Cartera.Cartera;

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
