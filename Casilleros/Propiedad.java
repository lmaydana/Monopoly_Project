package Casilleros;

import java.util.ArrayList;

public class Propiedad extends CasillaComprable{

    private String nombrePropiedad;
    private Grupo grupo;
    private Constructor constructor;
    private Terreno terreno;
    private ControladorDeHipotecas controladorDeHipotecas;
    private ArrayList<Double> preciosDeVenta;
    public Propiedad(String nombrePropiedad, Double costoDeVenta, Grupo grupo, ArrayList<Inmueble> inmueblesPorPoner, ArrayList<Double> rentas) {
        super(costoDeVenta);
        this.nombrePropiedad = nombrePropiedad;
        this.grupo = grupo;
        this.constructor = new ConstructorNulo();
        Tasador tasador = new Tasador(rentas);
        this.terreno = new Terreno(inmueblesPorPoner, tasador, this.arrendador);
        this.controladorDeHipotecas = new ControladorDeHipotecaNulo(this.arrendador);
    }

    public void construirVivienda(Cartera cartera){
        this.constructor = this.grupo.obtenerConstructor(this.arrendador, this.terreno, this.preciosDeVenta);
        this.constructor.construir(cartera);
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        super.seCompradaPor(jugador);
        this.controladorDeHipotecas = new ControladorDeHipotecaActivo(this.nombrePropiedad, this.arrendador);
    }

    public void hipotecar(Cartera cartera){
        this.arrendador = this.controladorDeHipotecas.hipotecar(cartera);
    }

    public void venderConstrucciones( int cantidadAVender ){
        this.terreno.venderInmuebles(cantidadAVender);
    }

    public void deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        this.arrendador = this.controladorDeHipotecas.deshipotecar(cartera);
    }

    @Override
    public Double tasar() {
        return this.terreno.tasar();
    }

    @Override
    protected void cesarA(Jugador jugador) {
        jugador.recibir(this);
    }

}
