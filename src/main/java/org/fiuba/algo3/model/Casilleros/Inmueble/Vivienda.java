package src.main.java.org.fiuba.algo3.model.Casilleros.Inmueble;

import src.main.java.org.fiuba.algo3.model.Jugador.Transferible;

public class Vivienda implements Inmueble {

    private Double precioDeVenta;

    public Vivienda(Double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    @Override
    public void vender(Transferible cartera) {
        cartera.recibir(this.precioDeVenta);
    }
}
