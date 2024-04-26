package org.fiuba.algo3.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.fiuba.algo3.controller.IniciadorDeVistaPrincipal;
import org.fiuba.algo3.model.Configuracion;

import java.util.ArrayList;

public class DisposicionDeApertura extends VBox {

    private ComboBox<Integer> seleccionadorDeCantidadDeJugadores;

    private ArrayList<TextField> camposDeNombre;

    private ArrayList<ComboBox<Color>> camposDeColores;

    private Button botonComenzar;

    private Stage ventana;

    private Configuracion configuracion;
    public DisposicionDeApertura(Configuracion configuracion, Stage ventana) {
        this.configuracion = configuracion;
        this.ventana = ventana;
        ObservableList<Integer> cantidadesDeJugadoresSeleccionable = this.devolverListaConCantidadesDeJugadores();
        this.camposDeNombre = new ArrayList<>();
        this.camposDeColores = new ArrayList<>();
        this.seleccionadorDeCantidadDeJugadores = new ComboBox<>(cantidadesDeJugadoresSeleccionable);
        this.seleccionadorDeCantidadDeJugadores.setPrefWidth(200);
        this.seleccionadorDeCantidadDeJugadores.setOnAction(e -> {
            this.agregarCampos(this.seleccionadorDeCantidadDeJugadores.getValue());
        });
        Label seleccionarCantidadDeJugadores = new Label("Seleccionar la cantidad de jugadores");
        this.getChildren().addAll(seleccionarCantidadDeJugadores, seleccionadorDeCantidadDeJugadores);
        this.setAlignment(Pos.CENTER);
    }

    private ObservableList<Integer> devolverListaConCantidadesDeJugadores( ){
        ObservableList<Integer> cantidadesDeJugadoresSeleccionable = FXCollections.observableArrayList();
        for (int i = 2; i <= configuracion.obtenerCantidadMaximaDeJugadores(); i++){
            cantidadesDeJugadoresSeleccionable.add(i);
        }
        return cantidadesDeJugadoresSeleccionable;
    }

    private void agregarCampos(Integer cantidadDeJugadores ){
        this.getChildren().clear();
        this.getChildren().add(this.seleccionadorDeCantidadDeJugadores);
        ObservableList<Color> listaDeColoresPosibles = FXCollections.observableArrayList(configuracion.obtenerColoresJugadores());
        this.camposDeNombre.clear();
        this.camposDeColores.clear();

        for ( int i = 1; i <= cantidadDeJugadores; i ++){
            this.agregarCampoDeJugador(i, listaDeColoresPosibles);
        }
        botonComenzar = new Button("Comenzar");
        botonComenzar.setOnAction( new IniciadorDeVistaPrincipal(this.camposDeNombre, this.camposDeColores, this.ventana, this.configuracion));
        this.getChildren().add(botonComenzar);
        this.setSpacing(20);
    }

    private void agregarCampoDeJugador(int numeroJugador, ObservableList<Color> listaDeColoresPosibles) {
        HBox campo = new HBox();
        Label etiquetaCampo = new Label( "Jugador " + numeroJugador + ": ");
        TextField cuadroDeNombre = new TextField();
        ComboBox<Color> campoColores = new SeleccionadorDeColores(this.configuracion.obtenerColoresJugadores());
        campoColores.getItems().addAll(listaDeColoresPosibles);
        cuadroDeNombre.setPromptText("Nombre jugador");
        this.camposDeNombre.add(cuadroDeNombre);
        this.camposDeColores.add(campoColores);
        campo.getChildren().add(etiquetaCampo);
        campo.getChildren().add(cuadroDeNombre);
        campo.getChildren().add(campoColores);
        campo.setAlignment(Pos.CENTER);
        this.getChildren().add(campo);
    }

}
