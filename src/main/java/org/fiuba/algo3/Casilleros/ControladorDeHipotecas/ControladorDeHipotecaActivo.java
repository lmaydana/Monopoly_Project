package org.fiuba.algo3.Casilleros.ControladorDeHipotecas;

import org.fiuba.algo3.Banco.Banco;
import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.Casilleros.Arrendador.ArrendadorHipotecado;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Deshipotecador.Deshipotecador;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorActivo;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorNulo;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Hipotecador.Hipotecador;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorActivo;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorNulo;

public class ControladorDeHipotecaActivo implements ControladorDeHipotecas {

    private String nombrePropiedad;
    private Arrendador arrendador;
    private Hipotecador hipotecador;
    private Deshipotecador deshipotecador;
    private Banco banco;

    public ControladorDeHipotecaActivo(String nombrePropiedad, Arrendador arrendador, Banco banco) {
        this.nombrePropiedad = nombrePropiedad;
        this.arrendador = arrendador;
        this.banco = banco;
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        Arrendador arrendador = this.deshipotecador.deshipotecar(cartera);
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
        return arrendador;
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        Arrendador arrendadorHipotecado = this.hipotecador.hipotecar(cartera);
        this.hipotecador = new HipotecadorNulo(arrendadorHipotecado);
        this.deshipotecador = new DeshipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        return arrendadorHipotecado;
    }
}
