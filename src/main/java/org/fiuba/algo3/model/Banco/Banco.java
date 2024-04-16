package src.main.java.org.fiuba.algo3.model.Banco;
import src.main.java.org.fiuba.algo3.model.Jugador.Transferible;
import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;

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
