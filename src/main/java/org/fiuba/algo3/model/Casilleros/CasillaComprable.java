package src.main.java.org.fiuba.algo3.model.Casilleros;

import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.ArrendadorDeVenta;
import src.main.java.org.fiuba.algo3.model.Jugador.Jugador;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;

public abstract class CasillaComprable extends Casillero implements Comprable {
    private Double costoDeVenta;
    protected Arrendador arrendador;
    private String nombre;
    public CasillaComprable(Double costoDeVenta){
        super();
        this.arrendador = new ArrendadorDeVenta();
        this.costoDeVenta = costoDeVenta;
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        jugador.transferir(this.costoDeVenta, this.arrendador);
        this.arrendador.despojarseDeCasilla(this.nombre, jugador);
        this.arrendador = jugador;
    }

    @Override
    public void recibirJugador(Jugador jugador) throws CantidadInsuficiente{
        super.recibirJugador(jugador);
        if( !this.tieneArrendador(jugador) ) {
            this.arrendador.acordar(jugador, this.nombre);
        }
    }

    public abstract Double tasar();

    public boolean tieneArrendador(Arrendador arrendador) {
       return this.arrendador.equals(arrendador);
    }

}
