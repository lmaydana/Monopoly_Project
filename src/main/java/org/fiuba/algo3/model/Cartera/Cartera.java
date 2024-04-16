package src.main.java.org.fiuba.algo3.model.Cartera;
import src.main.java.org.fiuba.algo3.model.Jugador.Transferible;

public interface Cartera extends Transferible{
    void transferir(Double monto, Transferible arrendador) throws CantidadInsuficiente;

}
