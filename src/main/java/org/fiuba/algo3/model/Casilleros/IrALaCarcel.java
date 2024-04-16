package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

public class IrALaCarcel extends Casillero{

    private Carcel carcel;

    public IrALaCarcel(Carcel carcel){
        this.carcel = carcel;
    }

    @Override
    public void recibirJugador(Jugador jugador) throws CantidadInsuficiente {
        super.recibirJugador(jugador);
        this.carcel.recibirJugador(jugador);
        this.carcel.encarcelar(jugador);
    }
}
