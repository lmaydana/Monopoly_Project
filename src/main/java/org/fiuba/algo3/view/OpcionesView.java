package org.fiuba.algo3.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import java.util.ArrayList;
import java.util.ListIterator;

import javafx.scene.paint.Color;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Juego;

public class OpcionesView extends VBox {
    private Juego juego;
    private final Config configuracion;

    private ArrayList<CartaDePropiedad> cartasActuales;

    private ListIterator<CartaDePropiedad> iteradorDeCartas;

    private CartaDePropiedad cartaActual;

    private Pane contenedorDeCartaActual;
    
    private Double alto;
    
    private Double ancho;

    private TableroView tableroVista;

    public OpcionesView(Juego juego, Config configuracion, TableroView tableroVista){
        this.juego = juego;
        this.tableroVista = tableroVista;
        this.configuracion = configuracion;
        this.cartasActuales = new ArrayList<>();
        this.contenedorDeCartaActual = new VBox();
        HBox sectorSeleccionDePropiedad = new HBox();
        Rectangle2D tamanioPantalla = Screen.getPrimary().getBounds();
        this.ancho = tamanioPantalla.getWidth() - tamanioPantalla.getHeight()*0.865740741;
        this.alto = tamanioPantalla.getHeight()*0.8;
        this.setPrefSize(this.ancho, this.alto );
        actualizarCartas();
        this.cartaActual = new CartaDePropiedadVacia(anchoCarta(), altoCarta(), juego);

        //--------------------Caja informacion jugador--------------------
        this.actualizarInformacionJugador();
        //---------------------------------------------------------------

        if( !this.cartasActuales.isEmpty() ){
            this.cartaActual = this.cartasActuales.getFirst();
        }

        this.contenedorDeCartaActual.getChildren().add(cartaActual);

        Button botonIrHaciaIzquierda = new Button("<");
        botonIrHaciaIzquierda.setOnAction( e->{
            if( this.iteradorDeCartas.hasPrevious() ){
                 this.cartaActual = this.iteradorDeCartas.previous();
                this.contenedorDeCartaActual.getChildren().clear();
                this.contenedorDeCartaActual.getChildren().add(this.cartaActual);
            }
        });
        Button botonIrHaciaDerecha = new Button(">");
        botonIrHaciaDerecha.setOnAction( e->{
            if( this.iteradorDeCartas.hasNext() ){
                this.cartaActual = this.iteradorDeCartas.next();
                this.contenedorDeCartaActual.getChildren().clear();
                this.contenedorDeCartaActual.getChildren().add(this.cartaActual);
            }
        });

        sectorSeleccionDePropiedad.getChildren().addAll(botonIrHaciaIzquierda, this.contenedorDeCartaActual, botonIrHaciaDerecha);
        sectorSeleccionDePropiedad.setMaxWidth(anchoCarta());
        Button pagarFianza = this.obtenerBotonDeOpcion("Pagar fianza");
        Button terminarTurno = this.obtenerBotonDeOpcion("Terminar turno");
        Button construirReformar = this.obtenerBotonDeOpcion("Construir o reformar");
        Button venderConstruccion = this.obtenerBotonDeOpcion("Vender Construccion");
        Button hipotecar = this.obtenerBotonDeOpcion("Hipotecar");
        Button comprarPropiedad = this.obtenerBotonDeOpcion("Comprar propiedad");
        pagarFianza.setOnAction(e-> {
            try {
                juego.pagarFianza();
            } catch (CantidadInsuficiente ex) {
                System.out.println("Implementar que pasa si no se puede pagar la fianza en OpcionesView->Constructor");
            }
        });
        terminarTurno.setOnAction(e-> {
            juego.pasarTurno();
            try {
                juego.moverJugador();
            } catch (Exception ex) {
                System.out.println("Implementar que pasa si el jugador no pudo moverse o pagar la fianza <- Ver como cambiar este comportammiento en OpcionesView->Constructor");
            }
            this.actualizarCartas();
            this.actualizarInformacionJugador();
            this.tableroVista.dibujar();
        });

        construirReformar.setOnAction( e ->{
            this.cartaActual.construirVivienda();
        });

        venderConstruccion.setOnAction( e -> {
            this.cartaActual.venderConstruccion();
            this.actualizarInformacionJugador();
        });

        hipotecar.setOnAction( e-> {
            this.cartaActual.hipotecar();
            hipotecar.setText("Deshipotecar");
            hipotecar.setOnAction( ev->{
                this.cartaActual.deshipotecar();
                hipotecar.setText("Hipotecar");
            });
            this.actualizarInformacionJugador();
        });

        comprarPropiedad.setOnAction( e-> {
            try {
                this.juego.comprarPropiedadOfrecida();
                this.actualizarCartas();
            } catch (CantidadInsuficiente ex) {
                System.out.println("Ver como avisar en caso de no poder comprar la vivienda actual OpcionesView-> constructor (tambien ver si conviene extender la excepcion)");
            }
            this.actualizarInformacionJugador();
        });


        this.getChildren().addAll(pagarFianza, sectorSeleccionDePropiedad, terminarTurno, construirReformar, venderConstruccion, hipotecar, comprarPropiedad);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setSpacing(20);
        this.tableroVista.dibujar();
    }

    private void actualizarInformacionJugador() {
        HBox cajaInformacionJugador = new HBox();
        Label nombreJugador = new Label(this.juego.obtenerNombreDelJugadorActual());
        Rectangle marcoConColor = new Rectangle(0,0, 20, 20);
        marcoConColor.setStroke(null);
        marcoConColor.setFill(Color.valueOf(this.juego.obtenerColorJugadorActual()));
        Label plataJugador = new Label("Dinero disponible: $"+this.juego.obtenerPlataDisponibleDelJugadorActual());
        cajaInformacionJugador.getChildren().addAll(marcoConColor, nombreJugador , plataJugador);
        cajaInformacionJugador.setAlignment(Pos.CENTER);
        cajaInformacionJugador.setSpacing(30);
        if( !this.getChildren().isEmpty()) {
            this.getChildren().removeFirst();
        }
        this.getChildren().addFirst(cajaInformacionJugador);
    }

    private double altoCarta() {
        return anchoCarta() * 0.5;
    }

    private double anchoCarta() {
        return this.ancho * 0.5;
    }

    private void actualizarCartas() {
        ArrayList<String> nombresPropiedadesEnPosesion = new ArrayList<>();
        this.juego.cargarConNombresPropiedadesEnPosesion(nombresPropiedadesEnPosesion);
        this.cartasActuales.clear();
        for( String nombrePropiedad: nombresPropiedadesEnPosesion ){
            ArrayList<ArrayList<String>> informacionInmuebles = this.configuracion.obtenerInformacionDeInmueblesSobre(nombrePropiedad);
            CartaDePropiedad cartaDePropiedad = new CartaDePropiedad(anchoCarta(), altoCarta(), this.configuracion.obtenerColorDeProopiedad(nombrePropiedad), nombrePropiedad, this.juego, informacionInmuebles.get(0), informacionInmuebles.get(1),informacionInmuebles.get(2), informacionInmuebles.get(3));
            this.cartasActuales.add(cartaDePropiedad);
        }
        this.iteradorDeCartas = this.cartasActuales.listIterator();
        if ( !this.cartasActuales.isEmpty() ) {
            this.contenedorDeCartaActual.getChildren().clear();
            this.contenedorDeCartaActual.getChildren().add(this.cartasActuales.getLast());
        }
    }

    private Button obtenerBotonDeOpcion(String texto){
        Button botonDeOpcion = new Button(texto);
        //-------Estilos y decoraciones del boton----------------
        //-------------------------------------------------------
        return botonDeOpcion;
    }

}
