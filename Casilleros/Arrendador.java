package Casilleros;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, CasillaComprable propiedad);
    void cesarPropiedad(CasillaComprable propiedad, Comprador comprador);
}
