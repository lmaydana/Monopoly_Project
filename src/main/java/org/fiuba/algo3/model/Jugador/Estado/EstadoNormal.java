package org.fiuba.algo3.model.Jugador.Estado;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.Map;

public class EstadoNormal implements Estado {
    private Jugador jugador;
    public EstadoNormal(Jugador jugador) {
        this.jugador = jugador;
    }
    @Override
    public void moverse(int tirada) {
    }

    @Override
    public void pagarFianza(double monto,Banco banco) {

    }

    @Override
    public void acordar(Jugador jugador, String propiedad, Map<String, CasillaComprable> propiedades) throws CantidadInsuficiente {
        Double precioACobrar = propiedades.get(propiedad).tasar();
        jugador.transferir(precioACobrar, this.jugador);
    }
}
