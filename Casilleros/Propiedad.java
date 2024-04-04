package Casilleros;

import java.util.ArrayList;

public class Propiedad extends CasillaComprable{

    private String nombrePropiedad;
    private Barrio barrio;
    private Constructor constructor;
    private Terreno terreno;
    private ControladorDeHipotecas controladorDeHipotecas;
    private ArrayList<Double> preciosDeVenta;
    public Propiedad(String nombrePropiedad, Double costoDeVenta, Barrio barrio, ArrayList<Inmueble> inmueblesPorPoner, ArrayList<Double> rentas, ArrayList<Double> preciosDeVenta) {
        super(costoDeVenta);
        this.nombrePropiedad = nombrePropiedad;
        this.barrio = barrio;
        this.constructor = new ConstructorNulo();
        Tasador tasador = new Tasador(rentas);
        this.terreno = new Terreno(inmueblesPorPoner, tasador, this.arrendador);
        this.controladorDeHipotecas = new ControladorDeHipotecaNulo(this.arrendador);
        this.preciosDeVenta = preciosDeVenta;
    }

    public void construirVivienda(Cartera cartera){
        this.constructor = this.barrio.obtenerConstructorAprobado(this.arrendador, this.terreno, this.preciosDeVenta);
        this.constructor.construir(cartera);
    }

    @Override
    public void seCompradaPor(Jugador jugador) throws CantidadInsuficiente {
        super.seCompradaPor(jugador);
        this.controladorDeHipotecas = new ControladorDeHipotecaActivo(this.nombrePropiedad, this.arrendador);
    }


    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        jugador.recibir(this);
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

}
