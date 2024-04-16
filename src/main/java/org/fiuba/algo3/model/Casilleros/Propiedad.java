package src.main.java.org.fiuba.algo3.model.Casilleros;

import src.main.java.org.fiuba.algo3.model.Banco.Banco;
import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;
import src.main.java.org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import src.main.java.org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaActivo;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaNulo;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecas;
import src.main.java.org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import src.main.java.org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;

public class Propiedad extends CasillaComprable{

    private String nombrePropiedad;
    private Barrio barrio;
    private Constructor constructor;
    private Terreno terreno;
    private ControladorDeHipotecas controladorDeHipotecas;
    private ArrayList<Double> preciosDeVenta;
    private Banco banco;
    public Propiedad(String nombrePropiedad, Double costoDeVenta, Barrio barrio, ArrayList<Inmueble> inmueblesPorPoner, ArrayList<Double> rentas, ArrayList<Double> preciosDeVenta, Banco banco) {
        super(costoDeVenta);
        this.nombrePropiedad = nombrePropiedad;
        this.barrio = barrio;
        this.constructor = new ConstructorNulo();
        Tasador tasador = new Tasador(rentas);
        this.terreno = new Terreno(inmueblesPorPoner, tasador);
        this.controladorDeHipotecas = new ControladorDeHipotecaNulo(this.arrendador);
        this.preciosDeVenta = preciosDeVenta;
        this.banco = banco;
    }

    public void construirVivienda(Cartera cartera) throws CantidadInsuficiente {
        this.constructor = this.barrio.obtenerConstructorAprobado(this.arrendador, this.terreno, this.preciosDeVenta);
        this.constructor.construir(cartera);
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        super.seCompradaPor(jugador);
        this.controladorDeHipotecas = new ControladorDeHipotecaActivo(this.nombrePropiedad, this.arrendador, this.banco);
    }


    @Override
    public void recibirJugador(Jugador jugador) throws CantidadInsuficiente{
        super.recibirJugador(jugador);
        jugador.recibir(nombrePropiedad, this);
    }

    public void hipotecar(Cartera cartera){
        this.arrendador = this.controladorDeHipotecas.hipotecar(cartera);
    }

    public void venderConstrucciones( int cantidadAVender){
        this.terreno.venderInmuebles(cantidadAVender, this.arrendador);
    }

    public void deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        this.arrendador = this.controladorDeHipotecas.deshipotecar(cartera);
    }

    @Override
    public Double tasar() {
        return this.terreno.tasar();
    }

}
