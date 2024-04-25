package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;

import java.util.HashMap;

public abstract class CasillaTransferidora extends Casillero {

    protected Double montoACobrar;
    protected Banco banco;

    public CasillaTransferidora(Double montoACobrar, Banco banco){
        this.montoACobrar = montoACobrar;
        this.banco = banco;
    }
    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero ){
        super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("monto", montoACobrar.toString());
    }
}
