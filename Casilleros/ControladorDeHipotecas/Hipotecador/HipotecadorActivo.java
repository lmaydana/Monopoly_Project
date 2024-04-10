package Casilleros.ControladorDeHipotecas.Hipotecador;

import Casilleros.Arrendador.Arrendador;
import Casilleros.Arrendador.ArrendadorHipotecado;
import Banco.Banco;
import Cartera.Cartera;

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
