package src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador;
import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Casilleros.Propiedad;
import src.main.java.org.fiuba.algo3.model.Jugador.Comprador;
import src.main.java.org.fiuba.algo3.model.Jugador.Transferible;
import src.main.java.org.fiuba.algo3.model.Casilleros.CasillaComprable;
import src.main.java.org.fiuba.algo3.model.Jugador.Jugador;

public interface Arrendador extends Transferible {

    void acordar(Jugador jugador, String propiedad) throws CantidadInsuficiente;
    void despojarseDeCasilla(String propiedad, Comprador comprador);
}
