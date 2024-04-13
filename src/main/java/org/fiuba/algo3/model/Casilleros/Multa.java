package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Jugador.Jugador;

public class Multa extends CasillaTransferidora{

    public Multa(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        jugador.transferir(this.montoACobrar, this.banco);
    }
}
