package org.fiuba.algo3.view;

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
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.JuegoTerminado;
import org.fiuba.algo3.model.Jugador.Jugador;

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

    private List<Jugador> jugadores;

    public OpcionesView(Juego juego, Configuracion configuracion, TableroView tableroVista, List<Jugador> jugadores){
        this.juego = juego;
        this.jugadores = jugadores;
        this.tableroVista = tableroVista;
        this.configuracion = configuracion;
        this.cartasActuales = new ArrayList<>();
        this.contenedorDeCartaActual = new VBox();
        this.contenedorInformacionJugadores = new HBox();
        HBox sectorSeleccionDePropiedad = new HBox();
        Rectangle2D tamanioPantalla = Screen.getPrimary().getBounds();
        this.ancho = tamanioPantalla.getWidth() - tamanioPantalla.getHeight()*0.865740741;
        this.alto = tamanioPantalla.getHeight()*0.8;
        this.setPrefSize(this.ancho, this.alto );
        this.actualizarCartas();
        this.actualizarInformacionJugadorActual();

        Button botonIrHaciaIzquierda = new Button("<");
        Button botonIrHaciaDerecha = new Button(">");
        sectorSeleccionDePropiedad.getChildren().addAll(botonIrHaciaIzquierda, this.contenedorDeCartaActual, botonIrHaciaDerecha);
        sectorSeleccionDePropiedad.setMaxWidth(anchoCarta());
        Button pagarFianza = this.obtenerBotonDeOpcion("Pagar fianza");
        Button terminarTurno = this.obtenerBotonDeOpcion("Terminar turno");
        Button construirReformar = this.obtenerBotonDeOpcion("Construir o reformar");
        Button venderConstruccion = this.obtenerBotonDeOpcion("Vender Construccion");
        Button hipotecar = this.obtenerBotonDeOpcion("Hipotecar");
        Button deshipotecar = this.obtenerBotonDeOpcion("Deshipotecar");
        Button comprarPropiedad = this.obtenerBotonDeOpcion("Comprar propiedad");
        setearEventoBotonesDeSeleccionDePropiedad(botonIrHaciaIzquierda, botonIrHaciaDerecha);
        setearEventosDeBotonesDeOpciones(juego, pagarFianza, terminarTurno, construirReformar, venderConstruccion, hipotecar, deshipotecar, comprarPropiedad);


        this.actualizarInformacionJugadores();
        this.getChildren().addAll(pagarFianza, sectorSeleccionDePropiedad, terminarTurno, construirReformar, venderConstruccion, hipotecar, deshipotecar, comprarPropiedad, this.contenedorInformacionJugadores);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setSpacing(20);

        try {
            juego.moverJugador();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.tableroVista.dibujar();
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

    private void setearEventosDeBotonesDeOpciones(Juego juego, Button pagarFianza, Button terminarTurno, Button construirReformar, Button venderConstruccion, Button hipotecar, Button deshipotecar, Button comprarPropiedad) {
        pagarFianza.setOnAction(e-> {
            juego.pagarFianza();
            this.actualizarInformacionJugadores();
        });
        terminarTurno.setOnAction(e-> {
            juego.pasarTurno();
            juego.moverJugador();
            this. actualizarCartas();
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
            this.actualizarCartas();
            this.tableroVista.dibujar();
            this.actualizarInformacionJugadores();
        });
    }

    private void actualizarInformacionJugadorActual() {
        HBox cajaInformacionJugador = new HBox();
        Label nombreJugador = new Label(this.juego.obtenerNombreDelJugadorActual());
        Rectangle marcoConColor = new Rectangle(0,0, 20, 20);
        String estadoJuego = this.juego.estado();
        marcoConColor.setStroke(null);
        marcoConColor.setFill(Color.valueOf(this.juego.obtenerColorJugadorActual()));
        Label plataJugador = new Label("Dinero disponible: $" + this.juego.obtenerPlataDisponibleDelJugadorActual());
        cajaInformacionJugador.getChildren().addAll(marcoConColor, nombreJugador , plataJugador);
        cajaInformacionJugador.setAlignment(Pos.CENTER);
        cajaInformacionJugador.setSpacing(30);
        if( !this.getChildren().isEmpty()) {
            this.getChildren().removeFirst();
        }
        if(estadoJuego.equals(new JuegoTerminado().obtenerEstado())){
            Label etiquetaGanadora = this.obtenerEtiquetaGanadora();
            cajaInformacionJugador.getChildren().add(etiquetaGanadora);
        }
        this.getChildren().addFirst(cajaInformacionJugador);

    }

    private Label obtenerEtiquetaGanadora() {
        String textoGanador = "Felicidades "+this.juego.obtenerNombreDelJugadorActual() + "!!! Usted gano el juego!!";
        Label etiquetaGanadora = new Label(textoGanador);
        return etiquetaGanadora;
    }

    private double altoCarta() {
        return anchoCarta() * 0.7;
    }

    private double anchoCarta() {
        return this.ancho * 0.3;
    }

    private void actualizarCartas() {
        ArrayList<String> nombresPropiedadesEnPosesion = new ArrayList<>();
        this.juego.cargarConNombresPropiedadesEnPosesion(nombresPropiedadesEnPosesion);
        this.cartasActuales.clear();
        for( String nombrePropiedad: nombresPropiedadesEnPosesion ){
            ArrayList<ArrayList<String>> informacionInmuebles = this.configuracion.obtenerInformacionDeInmueblesSobre(nombrePropiedad);
            CartaDePropiedad cartaDePropiedad = new CartaDePropiedad(anchoCarta(), altoCarta(), this.configuracion.obtenerColorDePropiedad(nombrePropiedad), nombrePropiedad, this.juego, informacionInmuebles.get(0), informacionInmuebles.get(1),informacionInmuebles.get(2), informacionInmuebles.get(3));
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
        //-------------------------------------------------------
        return botonDeOpcion;
    }

}
