package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

public class Loteria extends CasillaTransferidora{

    public Loteria(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibirJugador(Jugador jugador) throws CantidadInsuficiente {
        super.recibirJugador(jugador);
        banco.transferir(this.montoACobrar, jugador);
    }
}
