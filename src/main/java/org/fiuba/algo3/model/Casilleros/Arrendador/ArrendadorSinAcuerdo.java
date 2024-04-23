package org.fiuba.algo3.model.Casilleros.Arrendador;

import org.fiuba.algo3.model.Jugador.Comprador;
import org.fiuba.algo3.model.Jugador.Jugador;

public class ArrendadorSinAcuerdo implements Arrendador {

    private Arrendador arrendador;

    public ArrendadorSinAcuerdo(Arrendador arrendador) {
        this.arrendador = arrendador;
    }

    @Override
    public void acordar(Jugador jugador, String propiedad) {
        //Poner Log
    }

    @Override
    public void despojarseDeCasilla(String propiedad, Comprador comprador) {
        arrendador.despojarseDeCasilla(propiedad, comprador);
    }

    @Override
    public void recibir(Double monto) {
        arrendador.recibir(monto);
    }
}
