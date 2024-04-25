package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;
import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Terminable;

import java.util.ArrayList;
import java.util.HashMap;

public class Propiedad extends CasillaComprable{

    private Barrio barrio;
    private Constructor constructor;
    private Terreno terreno;
    private Banco banco;
    public Propiedad(String nombrePropiedad, Double costoDeVenta, Barrio barrio, ArrayList<Inmueble> inmueblesPorPoner, Banco banco) {
        super(nombrePropiedad, costoDeVenta);
        this.barrio = barrio;
        this.constructor = new ConstructorNulo();
        this.banco = banco;
        this.terreno = new Terreno(inmueblesPorPoner, this.arrendador, this.banco, this.nombre);
    }

    public void construirVivienda(Cartera cartera) throws CantidadInsuficiente {
        this.constructor = this.barrio.obtenerConstructorAprobado(this.arrendador, this.terreno);
        this.constructor.construir(cartera);
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        super.seCompradaPor(jugador);
        jugador.recibir(this.nombre, this);
        this.terreno.seCompradoPor(jugador);
    }


    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente{
        super.recibir(jugador);
    }

    public void hipotecar(){
        this.arrendador = this.terreno.hipotecar();
    }

    public void venderConstruccion(){
        this.terreno.venderInmueble(this.arrendador);
    }

    public void deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        this.arrendador = this.terreno.deshipotecar(cartera);
    }

    @Override
    public Double tasar() {
        return this.terreno.tasar();
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.PROPIEDAD;
    }

    public void desactivar(){
        super.desactivar();
        this.terreno.quitarInmuebles();
    }

    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero){
        super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("tipo", "Propiedad");
        infoCasillero.put("cantidad de construcciones", this.terreno.cantidadDeConstruccionesEdificadas());
        this.barrio.agegarInformacionColor(infoCasillero);
    }

    public void terminarContrucciones(Terminable terminable) {
        this.barrio.terminarReformas(terminable);
    }

    public boolean tieneCantidadDeConstruccionesAceptablesEnComparacionCon(Terreno terreno) {
        return this.terreno.tieneCantidadDeConstruccionesAceptablesConRespectoA(terreno);
    }

    public void firmarFinalizacionDeObras(ListaDeFirmas listaDeFirmas) {
        this.terreno.informarFinalizacionDeConstrucciones(listaDeFirmas);
    }
}
