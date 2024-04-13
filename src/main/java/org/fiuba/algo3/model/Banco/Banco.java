package org.fiuba.algo3.model.Banco;
import org.fiuba.algo3.model.Jugador.Transferible;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Jugador.Transferible;

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
