package Casilleros;

public class Vivienda implements Inmueble{

    private Double precioVenta;
    private Arrendador arrendador;

    public Vivienda(Double precioRenta, Double precioVenta, Arrendador arrendador){
        this.precioVenta = precioVenta;
        this.arrendador = arrendador;
    }

    @Override
    public void vender() {
        Banco banco = Banco.getBanco();
        banco.transferir(precioVenta, arrendador);
    }
}
