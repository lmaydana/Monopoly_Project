package org.fiuba.algo3.model.Jugador.Estado;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Casilleros.Propiedad;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.Map;

public class EstadoPreso implements Estado {
    private int diasCondena;
    private Jugador jugador;
    public EstadoPreso(Jugador jugador, Integer diasCondena){
        this.diasCondena  = diasCondena;
        this.jugador = jugador;
    }
    @Override
    public void moverse(int tirada) throws JugadorEncarcelado {

        if (diasCondena > tirada){
            diasCondena -=1;
            if (diasCondena == 0){
                jugador.setEstado( new  EstadoNormal(this.jugador));
                throw new JugadorEncarcelado("No pudo moverse pero ya no esta en la carcel");
            }else {
                throw new JugadorEncarcelado("No tuvo suerte sigue en la carcel quedan, " + diasCondena + " dias de condena");
            }
        }
        diasCondena = 0;
        jugador.setEstado( new  EstadoNormal(this.jugador) );
        throw new JugadorEncarcelado("No pudo moverse pero ya no esta en la carcel");
    }

    @Override
    public void pagarFianza(double monto,Banco banco) throws CantidadInsuficiente {
            jugador.transferir(monto,banco);
            jugador.setEstado( new  EstadoNormal(this.jugador));
    }

    @Override
    public void acordar(Jugador jugador, String propiedad, Map<String, CasillaComprable> propiedades) throws CantidadInsuficiente {

    }
}
