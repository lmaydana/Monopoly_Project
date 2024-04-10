package org.fiuba.algo3.Banco;

import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Jugador.Transferible;

public class Banco implements Transferible {

    public void transferir(Double monto, Transferible transferible){
        transferible.recibirTransferencia(monto);

    }
    @Override
    public void recibirTransferencia(Double monto) {

    }

    public void deshipotecar(String nombrePropiedad, Cartera cartera) throws CantidadInsuficiente {
    }

    public void hipotecar(String nombrePropiedad, Cartera cartera) {
    }
}
