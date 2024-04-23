package org.fiuba.algo3.model.Casilleros;

//Probablemente no se necesite esta clase, ya que el casillero de loteria hace lo mismo.

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class Inicio extends CasillaTransferidora {

    public Inicio(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente {
        super.recibir(jugador);
        this.banco.transferir(this.montoACobrar, jugador);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.INICIO;
    }

    public HashMap<String, String> obtenerInfoCasillero(){
        HashMap<String, String> infoCasillero = super.obtenerInfoCasillero();
        infoCasillero.put("tipo", "Inicio");
        return infoCasillero;
    }
}
