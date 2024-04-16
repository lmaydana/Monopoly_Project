package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;

public abstract class CasillaTransferidora extends Casillero {

    protected Double montoACobrar;
    protected Banco banco;

    public CasillaTransferidora(Double montoACobrar, Banco banco){
        this.montoACobrar = montoACobrar;
        this.banco = banco;
    }
}
