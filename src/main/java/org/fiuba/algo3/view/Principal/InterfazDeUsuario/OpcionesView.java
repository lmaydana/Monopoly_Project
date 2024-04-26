package org.fiuba.algo3.view.Principal.InterfazDeUsuario;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.EstadoDeContinuidad;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.view.Principal.Tablero.TableroView;

public class OpcionesView extends VBox {
    private Juego juego;
    private final Configuracion configuracion;

    private ArrayList<CartaDePropiedad> cartasActuales;

    private ListIterator<CartaDePropiedad> iteradorDeCartas;

    private CartaDePropiedad cartaActual;

    private Pane contenedorDeCartaActual;
    
    private Double alto;
    
    private Double ancho;

    private TableroView tableroVista;

    private HBox contenedorInformacionJugadores;

    private HBox cajaDeInformacionJugadorActual;

    private List<Jugador> jugadores;

    private Stage ventana;

    public OpcionesView(Juego juego, Configuracion configuracion, TableroView tableroVista, List<Jugador> jugadores, Stage ventana){
        this.juego = juego;
        this.ventana = ventana;
        this.jugadores = jugadores;
        this.tableroVista = tableroVista;
        this.configuracion = configuracion;
        this.cartasActuales = new ArrayList<>();
        this.cajaDeInformacionJugadorActual = new HBox();
        this.contenedorDeCartaActual = new VBox();
        this.contenedorInformacionJugadores = new HBox();
        HBox sectorSeleccionDePropiedad = new HBox();
        Rectangle2D tamanioPantalla = Screen.getPrimary().getBounds();
        this.ancho = tamanioPantalla.getWidth() - tamanioPantalla.getHeight()*0.865740741;
        this.alto = tamanioPantalla.getHeight()*0.8;
        this.setPrefSize(this.ancho, this.alto );
        this.actualizarCartasDePropiedadDelJugadorActual();

        Button botonIrHaciaIzquierda = this.obtenerBotonDeOpcion("<");
        Button botonIrHaciaDerecha = this.obtenerBotonDeOpcion(">");
        sectorSeleccionDePropiedad.getChildren().addAll(botonIrHaciaIzquierda, this.contenedorDeCartaActual, botonIrHaciaDerecha);
        botonIrHaciaDerecha.setPrefHeight(sectorSeleccionDePropiedad.getHeight());
        sectorSeleccionDePropiedad.setMaxWidth(anchoCarta());
        Button pagarFianza = this.obtenerBotonDeOpcion("Pagar fianza");
        Button terminarTurno = this.obtenerBotonDeOpcion("Terminar turno");
        Button construirReformar = this.obtenerBotonDeOpcion("Construir o reformar");
        Button venderConstruccion = this.obtenerBotonDeOpcion("Vender Construccion");
        Button hipotecar = this.obtenerBotonDeOpcion("Hipotecar");
        Button deshipotecar = this.obtenerBotonDeOpcion("Deshipotecar");
        Button comprarPropiedad = this.obtenerBotonDeOpcion("Comprar propiedad");
        Button cerrarJuego = this.obtenerBotonDeOpcion("Cerrar juego");
        setearEventoBotonesDeSeleccionDePropiedad(botonIrHaciaIzquierda, botonIrHaciaDerecha);
        setearEventosDeBotonesDeOpciones(juego, pagarFianza, terminarTurno, construirReformar, venderConstruccion, hipotecar, deshipotecar, comprarPropiedad, cerrarJuego);


        this.contenedorInformacionJugadores.setAlignment(Pos.CENTER);
        sectorSeleccionDePropiedad.setAlignment(Pos.CENTER);
        this.getChildren().addAll(this.cajaDeInformacionJugadorActual, pagarFianza, sectorSeleccionDePropiedad, terminarTurno, comprarPropiedad, construirReformar, venderConstruccion, hipotecar, deshipotecar, cerrarJuego, this.contenedorInformacionJugadores);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setSpacing(20);

        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #20AAFA, #6E6EFA 100%)");
        juego.moverJugador();
        this.tableroVista.dibujar();
        this.actualizarInformacionJugadores();
    }

    private void actualizarInformacionJugadores(){
        this.contenedorInformacionJugadores.getChildren().clear();
        Double anchoCarta = this.ancho*0.25;
        Double altoCarta = this.alto*0.25;
        for( Jugador jugador: this.jugadores){
            CartaInformacionJugador cartaInformacionJugador = new CartaInformacionJugador(anchoCarta,altoCarta,jugador);
            this.contenedorInformacionJugadores.getChildren().add(cartaInformacionJugador);
        }

        this.actualizarInformacionJugadorActual();

    }

    private void setearEventoBotonesDeSeleccionDePropiedad(Button botonIrHaciaIzquierda, Button botonIrHaciaDerecha) {
        botonIrHaciaIzquierda.setOnAction(e->{
            if( this.iteradorDeCartas.hasPrevious() ){
                this.cartaActual = this.iteradorDeCartas.previous();
                this.contenedorDeCartaActual.getChildren().clear();
                this.contenedorDeCartaActual.getChildren().add(this.cartaActual);
            }
        });
        botonIrHaciaDerecha.setOnAction(e->{
            if( this.iteradorDeCartas.hasNext() ){
                this.cartaActual = this.iteradorDeCartas.next();
                this.contenedorDeCartaActual.getChildren().clear();
                this.contenedorDeCartaActual.getChildren().add(this.cartaActual);
            }
        });
    }

    private void setearEventosDeBotonesDeOpciones(Juego juego, Button pagarFianza, Button terminarTurno, Button construirReformar, Button venderConstruccion, Button hipotecar, Button deshipotecar, Button comprarPropiedad, Button cerrarJuego) {
        pagarFianza.setOnAction(e-> {
            juego.pagarFianza();
            this.actualizarInformacionJugadores();
        });
        terminarTurno.setOnAction(e-> {
            juego.pasarTurno();
            juego.moverJugador();
            this.actualizarCartasDePropiedadDelJugadorActual();
            this.actualizarInformacionJugadores();
            this.tableroVista.dibujar();
        });

        construirReformar.setOnAction(e ->{
            this.cartaActual.construirVivienda();
            this.tableroVista.dibujar();
            this.actualizarInformacionJugadores();
        });

        venderConstruccion.setOnAction(e -> {
            this.cartaActual.venderConstruccion();
            this.actualizarInformacionJugadorActual();
            this.tableroVista.dibujar();
        });

        hipotecar.setOnAction(e-> {
            this.cartaActual.hipotecar();
            this.actualizarInformacionJugadores();
        });

        deshipotecar.setOnAction(e->{
            this.cartaActual.deshipotecar();
            this.actualizarInformacionJugadores();
        });

        comprarPropiedad.setOnAction(e-> {
            this.juego.comprarPropiedadOfrecida();
            this.actualizarCartasDePropiedadDelJugadorActual();
            this.tableroVista.dibujar();
            this.actualizarInformacionJugadores();
        });

        cerrarJuego.setOnAction( e->{
            this.ventana.close();
        });
    }

    private void actualizarInformacionJugadorActual() {
        this.cajaDeInformacionJugadorActual.getChildren().clear();
        Rectangle marcoConColor = new Rectangle(0,0, 20, 20);
        marcoConColor.setStroke(null);
        marcoConColor.setFill(Color.valueOf(this.juego.obtenerColorJugadorActual()));
        Label nombreJugador = this.crearEtiquetaInformacionJugador(this.juego.obtenerNombreDelJugadorActual());
        Label plataJugador = this.crearEtiquetaInformacionJugador("Dinero disponible: $" + this.juego.obtenerPlataDisponibleDelJugadorActual());
        this.cajaDeInformacionJugadorActual.getChildren().addAll(marcoConColor, nombreJugador , plataJugador);
        this.cajaDeInformacionJugadorActual.setAlignment(Pos.CENTER);
        this.cajaDeInformacionJugadorActual.setSpacing(30);
        EstadoDeContinuidad estadoJuego = this.juego.estado();

        if(estadoJuego == EstadoDeContinuidad.TERMINO){
            Label etiquetaGanadora = this.crearEtiquetaInformacionJugador("Felicidades " + this.juego.obtenerNombreDelJugadorActual() + "!!! Usted gano el juego!!");
            this.cajaDeInformacionJugadorActual.getChildren().add(etiquetaGanadora);
        }

    }

    private Label crearEtiquetaInformacionJugador(String textoEtiqueta){
        Label etiquetaDeInformacionJugador = new Label(textoEtiqueta);
        etiquetaDeInformacionJugador.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: Chandas; -fx-wrap-text: wrap");
        return etiquetaDeInformacionJugador;
    }


    private double altoCarta() {
        return anchoCarta() * 0.7;
    }

    private double anchoCarta() {
        return this.ancho * 0.45;
    }

    private void actualizarCartasDePropiedadDelJugadorActual() {
        ArrayList<String> nombresPropiedadesEnPosesion = new ArrayList<>();
        this.juego.cargarConNombresPropiedadesEnPosesion(nombresPropiedadesEnPosesion);
        this.cartasActuales.clear();
        for( String nombrePropiedad: nombresPropiedadesEnPosesion ){
            ArrayList<String>[] informacionInmuebles = this.configuracion.obtenerInformacionDeInmueblesSobre(nombrePropiedad);
            CartaDePropiedad cartaDePropiedad = new CartaDePropiedad(anchoCarta(), altoCarta(), this.configuracion.obtenerColorDePropiedad(nombrePropiedad), nombrePropiedad, this.juego, informacionInmuebles);
            this.cartasActuales.addFirst(cartaDePropiedad);
        }
        this.iteradorDeCartas = this.cartasActuales.listIterator();
        this.cartaActual = new CartaDePropiedadVacia(anchoCarta(), altoCarta(), this.juego);
        if ( this.iteradorDeCartas.hasNext() ) {
            this.cartaActual = this.iteradorDeCartas.next();
        }
        this.contenedorDeCartaActual.getChildren().clear();
        this.contenedorDeCartaActual.getChildren().add(this.cartaActual);
    }

    private Button obtenerBotonDeOpcion(String texto){
        Button botonDeOpcion = new Button(texto);
        //-------Estilos y decoraciones del boton----------------
        botonDeOpcion.setPrefWidth(this.ancho*0.2);
        botonDeOpcion.setStyle("-fx-background-color: #0CFA83; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); " +
                "-fx-font-size: 16px;");
        //-------------------------------------------------------
        return botonDeOpcion;
    }

}
