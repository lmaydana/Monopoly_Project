package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Arrendador.ArrendadorHipotecado;

public class HipotecadorActivo implements Hipotecador{


    private String nombrePropiedad;
    private Arrendador arrendador;
    private Banco banco;

    public HipotecadorActivo(String nombrePropiedad, Arrendador arrendador, Banco banco) {
        this.nombrePropiedad = nombrePropiedad;
        this.arrendador = arrendador;
        this.banco = banco;
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        this.banco.hipotecar( this.nombrePropiedad, cartera );
        return new ArrendadorHipotecado(this.arrendador);
    }
}
