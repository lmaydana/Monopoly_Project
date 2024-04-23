package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class IrALaCarcel extends Casillero{

    private Carcel carcel;

    public IrALaCarcel(Carcel carcel){
        this.carcel = carcel;
    }

    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente {
        super.recibir(jugador);
        this.sacar(jugador);
        this.carcel.recibir(jugador);
        this.carcel.encarcelar(jugador);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.IR_A_LA_CARCEL;
    }

    public void obtenerInfoCasillero( HashMap<String, String> infoCasillero ){
        super.obtenerInfoCasillero(infoCasillero);
        infoCasillero.put("tipo", "Ir A La Carcel");
    }
}
