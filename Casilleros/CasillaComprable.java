package Casilleros;

import Cartera.CantidadInsuficiente;
import Casilleros.Arrendador.Arrendador;
import Casilleros.Arrendador.ArrendadorDeVenta;
import Jugador.Jugador;

public abstract class CasillaComprable extends Casillero implements Comprable {
    private Double costoDeVenta;
    protected Arrendador arrendador;

    public CasillaComprable(Double costoDeVenta){
        super();
        this.arrendador = new ArrendadorDeVenta();
        this.costoDeVenta = costoDeVenta;
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        jugador.transferir(this.costoDeVenta, this.arrendador);
        this.arrendador.despojarseDeCasilla(this, jugador);
        this.arrendador = jugador;
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        if( !this.tieneArrendador(jugador) ) {
            this.arrendador.acordar(jugador, this);
        }
    }

    public abstract Double tasar();

    public boolean tieneArrendador(Arrendador arrendador) {
       return this.arrendador.equals(arrendador);
    }

}
