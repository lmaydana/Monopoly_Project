package org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Arrendador.ArrendadorSinAcuerdo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador.Deshipotecador;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorActivo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorNulo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador.Hipotecador;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorActivo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorNulo;
import org.fiuba.algo3.model.Jugador.Transferible;

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
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorSinAcuerdo(this.arrendador));
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        Arrendador arrendador = this.deshipotecador.deshipotecar(cartera);
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorSinAcuerdo(this.arrendador));
        return arrendador;
    }

    @Override
    public Arrendador hipotecar(Transferible cartera) {
        Arrendador arrendadorHipotecado = this.hipotecador.hipotecar(cartera);
        this.hipotecador = new HipotecadorNulo(arrendadorHipotecado);
        this.deshipotecador = new DeshipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        return arrendadorHipotecado;
    }
}
