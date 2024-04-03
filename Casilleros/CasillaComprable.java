package Casilleros;

public abstract class CasillaComprable implements Casillero, Comprable {
    private Double costoDeVenta;
    protected Arrendador arrendador;
    private Ofertador ofertador;

    public CasillaComprable(Double costoDeVenta){
        this.arrendador = new ArrendadorDeVenta();
        this.ofertador = new OfertadorDePropiedad(this);
        this.costoDeVenta = costoDeVenta;
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente{
        jugador.transferir(this.costoDeVenta, this.arrendador);
        this.arrendador.despojarseDeCasilla(this, jugador);
        this.cesarA(jugador);
        this.arrendador = jugador;
        this.ofertador = new OfertadorNulo();
    }

    @Override
    public void recibirJugador(Jugador jugador) {

        if( !this.esElMismoPropietario(jugador) ) {
            this.ofertador.ofertar(jugador);
            this.arrendador.acordar(jugador, this);
        }

    }

    public abstract Double tasar();

    public boolean esElMismoPropietario(Arrendador arrendador) {
       return this.arrendador.equals(arrendador);
    }

    protected abstract void cesarA(Jugador jugador);

}
