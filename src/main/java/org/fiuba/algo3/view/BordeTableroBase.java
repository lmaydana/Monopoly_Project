package org.fiuba.algo3.view;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class BordeTableroBase implements BordeTablero{
    protected Integer cantidadDeCasillasPorLado;

    protected Pane disposicion;

    private Consumer<Node> funcionPosicionar;

    private Integer ladoActual;

    public BordeTableroBase(Integer cantidadDeCasillasPorLado, Integer ladoActual, BorderPane disposicionPrincipal){
        this.cantidadDeCasillasPorLado = cantidadDeCasillasPorLado;
        this.ladoActual = ladoActual;
        this.disposicion = this.obtenerDisposicion();
        this.funcionPosicionar = this.obtenerLadoDeTableroAAgreegar(disposicionPrincipal);
        this.invertir();
    }

    private void invertir(){
        if (this.hayQueDarVuelta()){
            this.darVuelta();
        }
    }

    private boolean hayQueDarVuelta(){
        return (this.ladoActual == 1 || this.ladoActual == 2);
    }

    protected abstract Pane obtenerDisposicion();

    private Integer cantidadDeHijosAceptados(){
        return this.cantidadDeCasillasPorLado + corrimiento();
    }

    protected abstract Integer corrimiento();

    protected boolean puedoAceptarMasHijos(){
        return this.disposicion.getChildren().size() < this.cantidadDeHijosAceptados();
    }

    @Override
    public BordeTablero obtenerSiguienteBorde( BorderPane disposicion ) {
        if( !puedoAceptarMasHijos() ){
            return this.devolverSiguienteBorde(ladoActual+1, disposicion);
        }
        return this;
    }

    protected abstract BordeTablero devolverSiguienteBorde(Integer ladoActual, BorderPane disposicion);

    @Override
    public void agregar(Node vista) throws Exception {
        Integer hijos = this.disposicion.getChildren().size();
        if( !puedoAceptarMasHijos() ){
            throw new Exception("No se aceptan mas hijos");
        }
        this.disposicion.getChildren().add(vista);
    }

    @Override
    public void darVuelta() {
        this.disposicion.setRotate(gradosParaDarLaVuelta());
    }

    private Double gradosParaDarLaVuelta(){return 180.0;}

    @Override
    public void posicionar() {
        this.funcionPosicionar.accept(this.disposicion);
    }

    private Consumer<Node> obtenerLadoDeTableroAAgreegar(BorderPane disposicion){
        ArrayList<Consumer<Node>> funcionesPosiblesAAplicar = new ArrayList<>();
        funcionesPosiblesAAplicar.add(disposicion::setBottom);
        funcionesPosiblesAAplicar.add(disposicion::setLeft);
        funcionesPosiblesAAplicar.add(disposicion::setTop);
        funcionesPosiblesAAplicar.add(disposicion::setRight);
        return funcionesPosiblesAAplicar.get(this.ladoActual);
    }
}
