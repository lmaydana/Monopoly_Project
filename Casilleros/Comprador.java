package Casilleros;

public interface Comprador {
    void transferir(Double monto, Transferible vendedor);

    void recibir(Comprable comprable);

    Arrendador tranformarEnArrendador();

}
