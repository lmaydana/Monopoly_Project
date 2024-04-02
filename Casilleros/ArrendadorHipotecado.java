package Casilleros;

public class ArrendadorHipotecado implements Arrendador {

    private Arrendador arrendador;

    public ArrendadorHipotecado(Arrendador arrendador) {
        this.arrendador = arrendador;
    }

    @Override
    public void acordar(Jugador jugador, CasillaComprable propiedad) {
        //Poner Log
    }

    @Override
    public void cesarPropiedad(CasillaComprable propiedad, Comprador comprador) {
        arrendador.cesarPropiedad(propiedad, comprador);
    }

    @Override
    public void recibirTransferencia(Double monto) {
        arrendador.recibirTransferencia(monto);
    }
}
