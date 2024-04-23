package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Arrendador.ArrendadorDeVenta;
import org.fiuba.algo3.model.Jugador.Jugador;
import java.util.HashMap;

public abstract class CasillaComprable extends Casillero implements Comprable {
    private Double costoDeVenta;
    protected Arrendador arrendador;
    protected String nombre;
    public CasillaComprable(String nombre, Double costoDeVenta){
        super();
        this.nombre = nombre;
        ArrendadorDeVenta arrendadorDeVenta= new ArrendadorDeVenta();
        arrendadorDeVenta.agregarPropiedad(this.nombre, this);
        this.arrendador = arrendadorDeVenta;
        this.costoDeVenta = costoDeVenta;
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        jugador.transferir(this.costoDeVenta, this.arrendador);
        this.arrendador.despojarseDeCasilla(this.nombre, jugador);
        this.arrendador = jugador;
        jugador.recibir(this.nombre, this);
    }

    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente{
        super.recibir(jugador);
        if( !this.tieneArrendador(jugador) ) {
            this.arrendador.acordar(jugador, this.nombre);
        }
    }

    public HashMap<String, String> obtenerInfoCasillero(){
        HashMap<String, String> infoCasillero = super.obtenerInfoCasillero();
        infoCasillero.put("precio", this.costoDeVenta.toString());
        infoCasillero.put("nombre", new String(this.nombre));
        return infoCasillero;
    }

    public abstract Double tasar();

    public boolean tieneArrendador(Arrendador arrendador) {
       return this.arrendador.equals(arrendador);
    }

}
