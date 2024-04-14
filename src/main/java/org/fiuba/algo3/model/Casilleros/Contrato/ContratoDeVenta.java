package org.fiuba.algo3.model.Casilleros.Contrato;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Jugador.Jugador;

public class ContratoDeVenta implements Contrato{

    Jugador comprador;
    CasillaComprable propiedad;
    public ContratoDeVenta(Jugador comprador, CasillaComprable propiedad) {
        this.comprador = comprador;
        this.propiedad = propiedad;
    }

    public void aceptar() throws CantidadInsuficiente{
        propiedad.seCompradaPor(this.comprador);
    }

    @Override
    public void rechazar() {
        this.comprador.perderOferta();
    }
}
