package org.fiuba.algo3.model.Banco;
import org.fiuba.algo3.model.Jugador.Transferible;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;

public class Banco implements Transferible {

    public void transferir(Double monto, Transferible transferible){
        transferible.recibir(monto);

    }
    @Override
    public void recibir(Double monto) {

    }

    public void deshipotecar(String nombrePropiedad, Cartera cartera) throws CantidadInsuficiente {
    }

    public void hipotecar(String nombrePropiedad, Cartera cartera) {
    }
}
