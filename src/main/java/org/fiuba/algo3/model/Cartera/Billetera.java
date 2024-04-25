package org.fiuba.algo3.model.Cartera;

public class Billetera implements Cartera {

    private Double montoDisponible;

    public Billetera(){
        this.montoDisponible = 0.0;
    }

    public void transferir(Double monto, org.fiuba.algo3.model.Jugador.Transferible transferible) throws CantidadInsuficiente{
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
