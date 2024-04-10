package Casilleros;

public interface Cartera {
    void transferir(Double monto, Transferible arrendador) throws CantidadInsuficiente;

    void recibir(Double precioDeVenta);
}
