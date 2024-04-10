package Casilleros;

public class Vivienda implements Inmueble{

    private Double precioDeVenta;

    public Vivienda(Double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    @Override
    public void vender(Cartera cartera) {
        cartera.recibir(this.precioDeVenta);
    }
}
