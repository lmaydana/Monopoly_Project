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

    private Barrio barrio;
    private Constructor constructor;
    private Terreno terreno;
    private ControladorDeHipotecas controladorDeHipotecas;
    private Banco banco;
    public Propiedad(String nombrePropiedad, Double costoDeVenta, Barrio barrio, ArrayList<Inmueble> inmueblesPorPoner, Banco banco) {
        super(nombrePropiedad, costoDeVenta);
        this.barrio = barrio;
        this.constructor = new ConstructorNulo();
        this.terreno = new Terreno(inmueblesPorPoner);
        this.controladorDeHipotecas = new ControladorDeHipotecaNulo(this.arrendador);
        this.banco = banco;
    }

    public void construirVivienda(Cartera cartera) throws CantidadInsuficiente {
        this.constructor = this.barrio.obtenerConstructorAprobado(this.arrendador, this.terreno);
        this.constructor.construir(cartera);
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        super.seCompradaPor(jugador);
        jugador.recibir(this.nombre, this);
        this.controladorDeHipotecas = new ControladorDeHipotecaActivo(this.nombre, this.arrendador, this.banco);
    }


    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente{
        super.recibir(jugador);
    }



    public void hipotecar(Cartera cartera){
        this.arrendador = this.controladorDeHipotecas.hipotecar(cartera);
    }

    public void venderConstruccion(){
        this.terreno.venderInmueble(this.arrendador);
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
