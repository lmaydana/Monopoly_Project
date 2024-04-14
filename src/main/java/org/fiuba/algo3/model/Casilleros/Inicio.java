package org.fiuba.algo3.model.Casilleros;

//Probablemente no se necesite esta clase, ya que el casillero de loteria hace lo mismo.

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Jugador.Jugador;

public class Inicio extends CasillaTransferidora {

    public Inicio(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        this.banco.transferir(this.montoACobrar, jugador);
    }
}
