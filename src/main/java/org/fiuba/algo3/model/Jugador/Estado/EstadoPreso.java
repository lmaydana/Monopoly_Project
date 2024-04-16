package src.main.java.org.fiuba.algo3.model.Jugador.Estado;

import src.main.java.org.fiuba.algo3.model.Banco.Banco;
import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Casilleros.Propiedad;
import src.main.java.org.fiuba.algo3.model.Jugador.Jugador;

import java.util.Map;

public class EstadoPreso implements Estado {
    private int diasCondena;
    private Jugador jugador;
    public EstadoPreso(Jugador jugador){
        this.diasCondena  = 3;
        this.jugador = jugador;
    }
    @Override
    public void moverse(int tirada) throws NoPuedeMoverse {

        if (diasCondena > tirada){
            diasCondena -=1;
            if (diasCondena == 0){
                jugador.setEstado( new  EstadoNormal(this.jugador));
                throw new NoPuedeMoverse("No pudo moverse pero ya no esta en la carcel");
            }else {
                throw new NoPuedeMoverse("No tuvo suerte sigue en la carcel quedan " + diasCondena + "dias de condena");
            }
        }
        diasCondena = 0;
        jugador.setEstado( new  EstadoNormal(this.jugador));
        throw new NoPuedeMoverse("No pudo moverse pero ya no esta en la carcel");
    }

    @Override
    public void pagarFianza(double monto,Banco banco) throws CantidadInsuficiente {
            jugador.transferir(monto,banco);
            jugador.setEstado( new  EstadoNormal(this.jugador));
    }

    @Override
    public void acordar(Jugador jugador, String propiedad, Map<String, Propiedad> propiedades) throws CantidadInsuficiente {

    }
}
