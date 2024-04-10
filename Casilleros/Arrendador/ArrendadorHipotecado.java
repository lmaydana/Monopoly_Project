package Casilleros.Arrendador;

import Casilleros.CasillaComprable;
import Jugador.Comprador;
import Jugador.Jugador;

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
