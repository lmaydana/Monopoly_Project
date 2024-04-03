package Casilleros;

public class Transporte extends CasillaComprable{


    public Transporte(Double costoDeVenta, Double costoRenta) {
        super(costoDeVenta);
    }

    @Override
    public Double tasar() {
        return null;
    }

    @Override
    protected void cesarA(Jugador jugador) {
        jugador.recibir(this);
    }

}
