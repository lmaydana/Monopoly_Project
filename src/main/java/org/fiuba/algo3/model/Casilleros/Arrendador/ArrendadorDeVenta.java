package org.fiuba.algo3.model.Casilleros.Arrendador;

import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Casilleros.Contrato.ContratoDeVenta;
import org.fiuba.algo3.model.Casilleros.Propiedad;
import org.fiuba.algo3.model.Jugador.Comprador;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrendadorDeVenta implements Arrendador{

    private HashMap<String, CasillaComprable> propiedades;

    public ArrendadorDeVenta() {
        this.propiedades = new HashMap<>();
    }

    public void agregarPropiedad(String nombrePropiedad, CasillaComprable propiedad){
        this.propiedades.put(nombrePropiedad, propiedad);
    }

    @Override
    public void acordar(Jugador jugador, String propiedad) {
        ContratoDeVenta contrato = new ContratoDeVenta(jugador, this.propiedades.get(propiedad));
        jugador.recibir(contrato);
    }

    @Override
    public void recibir(Double monto) {

    }

    @Override
    public void despojarseDeCasilla(String propiedad, Comprador comprador) {
        this.propiedades.remove(propiedad);
    }
}
