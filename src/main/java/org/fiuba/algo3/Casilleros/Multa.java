package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Banco.Banco;
import org.fiuba.algo3.Jugador.Jugador;

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
