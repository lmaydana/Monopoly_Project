package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class Multa extends CasillaTransferidora{

    public Multa(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente {
        super.recibir(jugador);
        jugador.transferir(this.montoACobrar, this.banco);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.MULTA;
    }

    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero ){
        super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("tipo", "Multa");
    }
}
