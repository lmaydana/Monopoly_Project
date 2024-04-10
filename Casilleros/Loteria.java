package Casilleros;

import Banco.Banco;
import Jugador.Jugador;

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
