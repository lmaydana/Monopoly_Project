package org.fiuba.algo3.view.Apertura;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

    private Label etiquetaSeleccionarCantidadDeJugadores;

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
        this.etiquetaSeleccionarCantidadDeJugadores = new Label("Seleccionar la cantidad de jugadores");
        this.setearEstiloSeleccionadores(this.seleccionadorDeCantidadDeJugadores);
        this.setearFormatoEtiqueta(this.etiquetaSeleccionarCantidadDeJugadores);
        this.getChildren().addAll(etiquetaSeleccionarCantidadDeJugadores, seleccionadorDeCantidadDeJugadores);
        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #5cd781, #577fe5 100%);");
        this.setAlignment(Pos.CENTER);
    }

    public void setearEstiloSeleccionadores(Node seleccionador){
        seleccionador.setStyle("-fx-background-color: linear-gradient(to bottom right, #577fe5, #9d6efa 100%);");
    }

    private void setearFormatoEtiqueta(Label etiqueta) {
        etiqueta.setStyle("-fx-text-fill: white;" +
                "-fx-font-size: 15px;");
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
        this.getChildren().add(this.etiquetaSeleccionarCantidadDeJugadores);
        this.getChildren().add(this.seleccionadorDeCantidadDeJugadores);
        ObservableList<Color> listaDeColoresPosibles = FXCollections.observableArrayList(configuracion.obtenerColoresJugadores());
        this.camposDeNombre.clear();
        this.camposDeColores.clear();

        for ( int i = 1; i <= cantidadDeJugadores; i ++){
            this.agregarCampoDeJugador(i, listaDeColoresPosibles);
        }

        botonComenzar = new Button("Comenzar");
        botonComenzar.setOnAction( new IniciadorDeVistaPrincipal(this.camposDeNombre, this.camposDeColores, this.ventana, this.configuracion));
        botonComenzar.setStyle(
                "-fx-pref-width: 150px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px;" +
                        "-fx-background-color: linear-gradient(to bottom right, #577fe5, #9d6efa 100%);" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        this.getChildren().add(botonComenzar);
        this.setSpacing(espaciadoEntreVistas());
    }

    private int espaciadoEntreVistas() {
        return 20;
    }

    private void agregarCampoDeJugador(int numeroJugador, ObservableList<Color> listaDeColoresPosibles) {
        HBox campo = new HBox();
        Label etiquetaCampo = new Label( "Jugador " + numeroJugador + ": ");
        this.setearFormatoEtiqueta(etiquetaCampo);
        TextField cuadroDeNombre = new TextField();
        ComboBox<Color> campoColores = new SeleccionadorDeColores(this.configuracion.obtenerColoresJugadores());
        campoColores.getItems().addAll(listaDeColoresPosibles);
        this.setearEstiloSeleccionadores(campoColores);
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
