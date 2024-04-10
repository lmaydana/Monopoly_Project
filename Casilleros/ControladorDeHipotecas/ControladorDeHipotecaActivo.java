package Casilleros.ControladorDeHipotecas;

import Banco.Banco;
import Cartera.Cartera;
import Casilleros.Arrendador.Arrendador;
import Casilleros.Arrendador.ArrendadorHipotecado;
import Casilleros.ControladorDeHipotecas.Deshipotecador.Deshipotecador;
import Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorActivo;
import Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorNulo;
import Casilleros.ControladorDeHipotecas.Hipotecador.Hipotecador;
import Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorActivo;
import Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorNulo;
import Cartera.CantidadInsuficiente;

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
    public Arrendador hipotecar(Cartera cartera) {
        Arrendador arrendadorHipotecado = this.hipotecador.hipotecar(cartera);
        this.hipotecador = new HipotecadorNulo(arrendadorHipotecado);
        this.deshipotecador = new DeshipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        return arrendadorHipotecado;
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        Arrendador arrendador = this.deshipotecador.deshipotecar(cartera);
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
        return arrendador;
    }
}
