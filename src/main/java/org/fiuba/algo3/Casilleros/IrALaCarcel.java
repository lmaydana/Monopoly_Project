package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Jugador.Jugador;

public class IrALaCarcel extends Casillero{

    private Carcel carcel;

    public IrALaCarcel(Carcel carcel){
        this.carcel = carcel;
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        this.carcel.recibirJugador(jugador);
        this.carcel.encarcelar(jugador);
    }
}
