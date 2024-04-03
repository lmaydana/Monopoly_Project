package Casilleros;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, CasillaComprable propiedad);
    void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador);
}
