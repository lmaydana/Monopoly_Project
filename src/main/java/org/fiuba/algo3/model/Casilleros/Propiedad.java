package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaActivo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaNulo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecas;
import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class Propiedad extends CasillaComprable{

    private String nombrePropiedad;
    private Barrio barrio;
    private Constructor constructor;
    private Terreno terreno;
    private ControladorDeHipotecas controladorDeHipotecas;
    private ArrayList<Double> preciosDeCompraViviendas;
    private Banco banco;
    public Propiedad(String nombrePropiedad, Double costoDeVenta, Barrio barrio, ArrayList<Inmueble> inmueblesPorPoner, ArrayList<Double> rentas, ArrayList<Double> preciosDeCompraViviendas, Banco banco) {
        super(nombrePropiedad, costoDeVenta);
        this.barrio = barrio;
        this.constructor = new ConstructorNulo();
        Tasador tasador = new Tasador(rentas);
        this.terreno = new Terreno(inmueblesPorPoner, tasador);
        this.controladorDeHipotecas = new ControladorDeHipotecaNulo(this.arrendador);
        this.preciosDeCompraViviendas = preciosDeCompraViviendas;
        this.banco = banco;
    }

    public void construirVivienda(Cartera cartera) throws CantidadInsuficiente {
        this.constructor = this.barrio.obtenerConstructorAprobado(this.arrendador, this.terreno, this.preciosDeCompraViviendas);
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

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.PROPIEDAD;
    }

    public HashMap<String, String> obtenerInfoCasillero(){
        HashMap<String, String> infoCasillero = super.obtenerInfoCasillero();
        infoCasillero.put("tipo", "Propiedad");
        this.barrio.agegarInfoColor(infoCasillero);
        return infoCasillero;
    }

}
