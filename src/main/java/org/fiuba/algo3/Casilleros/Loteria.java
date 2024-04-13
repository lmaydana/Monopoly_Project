package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Banco.Banco;
import org.fiuba.algo3.Jugador.Jugador;

public class Loteria extends CasillaTransferidora{

    public Loteria(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        banco.transferir(this.montoACobrar, jugador);
    }
}
