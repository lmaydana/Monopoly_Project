package org.fiuba.algo3.model.Jugador.Estado;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Casilleros.Propiedad;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.Map;

public class EstadoNormal implements Estado {
    private Jugador jugador;

    private Map<String, Propiedad> propiedades;

    private Cartera cartera;

    public EstadoNormal(Jugador jugador, Map<String, Propiedad> propiedades, Cartera cartera) {
        this.jugador = jugador;
        this.propiedades = propiedades;
        this.cartera = cartera;
    }
    @Override
    public void moverse(int tirada) {
    }

    @Override
    public void pagarFianza(double monto, Banco banco) {

    }

    @Override
    public void acordar(Jugador jugador, String propiedad, Map<String, CasillaComprable> propiedades) throws CantidadInsuficiente {
        Double precioACobrar = propiedades.get(propiedad).tasar();
        jugador.transferir(precioACobrar, this.jugador);
    }

    @Override
    public void construirEn(String nombrePropiedad) throws CantidadInsuficiente {
        if(this.propiedades.containsKey(nombrePropiedad)) {
            this.propiedades.get(nombrePropiedad).construirVivienda(cartera);
        }
    }

    @Override
    public void venderConstruccion(String nombrePropiedad) {
        if( this.propiedades.containsKey(nombrePropiedad) ) {
            this.propiedades.get(nombrePropiedad).venderConstruccion();
        }
    }
}
