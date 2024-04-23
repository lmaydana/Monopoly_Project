package org.fiuba.algo3.model.Cartera;

import org.fiuba.algo3.model.Jugador.Transferible;

public class Billetera implements Cartera{

    private Double montoDisponible;

    public Billetera(Double montoInicial){
        this.montoDisponible = montoInicial;
    }

    public void transferir(Double monto, Transferible transferible) throws CantidadInsuficiente{
        if(this.montoDisponible < monto)
            throw new CantidadInsuficiente("No hay suficientes existencias para afrontar el costo.");

        transferible.recibir(monto);
        this.montoDisponible -= monto;
    }

    public void recibir(Double monto){
        this.montoDisponible += monto;
    }

    public String toString(){
        return this.montoDisponible.toString();
    }
}
