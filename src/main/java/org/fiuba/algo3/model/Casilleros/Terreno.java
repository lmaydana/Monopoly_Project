package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaActivo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecaNulo;
import org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.ControladorDeHipotecas;
import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.model.Jugador.Transferible;
import org.fiuba.algo3.model.Terminable;

import java.util.ArrayList;

public class Terreno {
    private ArrayList<Inmueble> inmueblesActuales;
    private ArrayList<Inmueble> inmueblesPorPoner;
    private Tasador tasador;

    private ControladorDeHipotecas controladorDeHipotecas;

    private Arrendador arrendador;

    private Double rentaBase;

    private String nombrePropiedad;

    private Banco banco;

    public Terreno(ArrayList<Inmueble> inmueblesPorPoner, Arrendador arrendador, Banco banco, String nombrePropiedad){
        this.inmueblesPorPoner = inmueblesPorPoner;
        this.inmueblesActuales = new ArrayList<>();
        this.nombrePropiedad = nombrePropiedad;
        this.banco = banco;
        this.rentaBase = 0.0;
        this.arrendador = arrendador;
        this.controladorDeHipotecas = new ControladorDeHipotecaNulo(this.arrendador);
        this.rentaBase = this.inmueblesPorPoner.removeFirst().devolverRentaSumadaA(this.rentaBase);
        this.tasador = new Tasador();
    }

    public void seCompradoPor( Arrendador arrendador ){
        this.arrendador = arrendador;
        this.controladorDeHipotecas = new ControladorDeHipotecaActivo(this.nombrePropiedad, this.arrendador, this.banco);
    }

    public void edificar(Cartera cartera) throws CantidadInsuficiente {
        if( !this.inmueblesPorPoner.isEmpty() ) {
            Inmueble inmuebleAPoner = this.inmueblesPorPoner.removeFirst();
            inmuebleAPoner.comprar(cartera);
            this.inmueblesActuales.add(inmuebleAPoner);
        }
    }

    public Double tasar( ){
        return this.rentaBase + this.tasador.tasarTerreno(this.inmueblesActuales);
    }

    public void venderInmueble(Transferible transferible){
        if( !inmueblesActuales.isEmpty() ) {
            Inmueble inmueble = this.inmueblesActuales.removeLast();
            inmueble.vender(transferible);
            this.inmueblesPorPoner.addFirst(inmueble);
        }
    }

    public String cantidadDeConstruccionesEdificadas() {
        return String.valueOf(this.inmueblesActuales.size());
    }

    public void quitarInmuebles() {
        this.inmueblesActuales.clear();
        this.inmueblesPorPoner.clear();
    }

    public boolean tieneCantidadDeConstruccionesAceptablesConRespectoA(Terreno terreno) {
        return terreno.inmueblesActuales.size() <=  this.inmueblesActuales.size() ;
    }

    public Arrendador hipotecar(){
        if( this.inmueblesActuales.isEmpty() ){
            return this.controladorDeHipotecas.hipotecar(this.arrendador);
        }
        return this.arrendador;
    }

    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        return this.controladorDeHipotecas.deshipotecar(cartera);
    }

    public void informarFinalizacionDeConstrucciones(ListaDeFirmas listaDeFirmas) {
        if( this.inmueblesPorPoner.isEmpty() ){
            listaDeFirmas.firmar();
        }
    }
}
