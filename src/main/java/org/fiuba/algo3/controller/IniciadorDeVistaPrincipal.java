package org.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.view.DisposicionPrincipal;

import java.util.ArrayList;
import java.util.List;

public class IniciadorDeVistaPrincipal implements EventHandler<ActionEvent> {
    private ArrayList<TextField> camposDeNombre;

    private Stage ventana;

    private Configuracion configuracion;

    private ArrayList<ColorPicker> camposDeColores;

    public IniciadorDeVistaPrincipal(ArrayList<TextField> camposDeNombre, ArrayList<ColorPicker> camposDeColores, Stage ventana, Configuracion configuracion) {
        this.camposDeNombre = camposDeNombre;
        this.camposDeColores = camposDeColores;
        this.ventana = ventana;
        this.configuracion = configuracion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boolean estanTodosLosCamposCompletos = true;
        for( TextField campoDeNombre : this.camposDeNombre ){
            campoDeNombre.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            if( campoDeNombre.getText().equals("") ){
                campoDeNombre.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
                estanTodosLosCamposCompletos = false;
            }
        }
        if( estanTodosLosCamposCompletos ){
            iniciarEscena();
        }
    }

    private void iniciarEscena() {
        Double anchoVentana = this.ventana.getWidth();
        Double altoVentama = this.ventana.getHeight();
        List<String> nombresJugadores = new ArrayList<>();
        List<Color> coloresJugadores = new ArrayList<>();
        for ( int i = 0; i < this.camposDeNombre.size(); i++){
            coloresJugadores.add(this.camposDeColores.get(i).getValue());
            nombresJugadores.add(this.camposDeNombre.get(i).getText());
        }
        List<Jugador> jugadores = this.crearJugadores(nombresJugadores, coloresJugadores);
        this.ventana.setScene(new Scene(new DisposicionPrincipal(this.configuracion, jugadores), anchoVentana, altoVentama));
    }

    private List<Jugador> crearJugadores(List<String> nombresJugadores, List<Color> coloresJugadores) {
        List<Jugador> jugadores= new ArrayList<>();
        for(int i = 0; i < nombresJugadores.size(); i++){
            jugadores.add(new Jugador(nombresJugadores.get(i), coloresJugadores.get(i), configuracion));
        }
        return jugadores;
    }
}
