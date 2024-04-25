package org.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
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

    private ArrayList<ComboBox<Color>> camposDeColores;

    public IniciadorDeVistaPrincipal(ArrayList<TextField> camposDeNombre, ArrayList<ComboBox<Color>> camposDeColores, Stage ventana, Configuracion configuracion) {
        this.camposDeNombre = camposDeNombre;
        this.camposDeColores = camposDeColores;
        this.ventana = ventana;
        this.configuracion = configuracion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boolean todosLosCamposSonValidos = true;
        for( TextField campoDeNombre : this.camposDeNombre ){
            campoDeNombre.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            if( campoDeNombre.getText().equals("") ){
                campoDeNombre.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
                todosLosCamposSonValidos = false;
            }
        }
        ArrayList<ComboBox<Color>> camposDeColoresCopia = new ArrayList<>(this.camposDeColores);
        for( ComboBox<Color> campoDeColor : this.camposDeColores ){
            campoDeColor.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            if( campoDeColor.getValue().equals("") || this.seRepiteElColor(camposDeColoresCopia, campoDeColor) ){
                campoDeColor.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
                todosLosCamposSonValidos = false;
            }
        }
        if( todosLosCamposSonValidos ){
            iniciarEscena();
        }
    }

    private boolean seRepiteElColor(ArrayList<ComboBox<Color>> camposDeColoresCopia, ComboBox<Color> campoDeColor) {
        camposDeColoresCopia.remove(campoDeColor);
        for ( ComboBox<Color> otroCampoDeColor: camposDeColoresCopia){
            campoDeColor.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            System.out.println(otroCampoDeColor.getValue()+" vs."+campoDeColor.getValue());
            if( campoDeColor.getValue().equals(otroCampoDeColor.getValue()) ){
                campoDeColor.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
                return true;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        camposDeColoresCopia.add(campoDeColor);
        return false;
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
