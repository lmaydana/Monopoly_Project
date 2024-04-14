package org.fiuba.algo3.model.Casilleros.Arrendador;

import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Jugador.Comprador;
import org.fiuba.algo3.model.Jugador.Jugador;

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
    public void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador) {
        arrendador.despojarseDeCasilla(propiedad, comprador);
    }

    @Override
    public void recibirTransferencia(Double monto) {
        arrendador.recibirTransferencia(monto);
    }
}
