package org.fiuba.algo3.Casilleros;

import org.fiuba.algo3.Banco.Banco;
import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.Casilleros.Constructor.ConstructorNulo;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaActivo;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaNulo;
import org.fiuba.algo3.Casilleros.ControladorDeHipotecas.ControladorDeHipotecas;
import org.fiuba.algo3.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.Jugador.Jugador;

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
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        jugador.recibir(this);
    }

    public void hipotecar(Cartera cartera){
        this.arrendador = this.controladorDeHipotecas.hipotecar(cartera);
    }

    public void venderConstrucciones( int cantidadAVender, Cartera cartera ){
        this.terreno.venderInmuebles(cantidadAVender, cartera);
    }

    public void deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        this.arrendador = this.controladorDeHipotecas.deshipotecar(cartera);
    }

    @Override
    public Double tasar() {
        return this.terreno.tasar();
    }

}
