package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;

import java.util.HashMap;

public class Inicio extends Loteria {

    public Inicio(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.INICIO;
    }

    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero ){
        super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("tipo", "Inicio");
    }
}
