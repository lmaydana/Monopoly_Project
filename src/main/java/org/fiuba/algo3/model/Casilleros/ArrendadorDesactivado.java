package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Jugador.Comprador;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class ArrendadorDesactivado implements Arrendador {
    public ArrendadorDesactivado() {
    }

    @Override
    public void acordar(Jugador jugador, String propiedad) throws CantidadInsuficiente {

    }

    @Override
    public void despojarseDeCasilla(String propiedad, Comprador comprador) {

    }

    @Override
    public void informarDetalles(HashMap<String, String> detalles) {
        detalles.put("propietario", "Desactivado");
    }

    @Override
    public void recibir(Double monto) {

    }

}
