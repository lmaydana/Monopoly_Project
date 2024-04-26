package org.fiuba.algo3.view.Principal;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.Tablero;
import org.fiuba.algo3.view.Principal.InterfazDeUsuario.OpcionesView;
import org.fiuba.algo3.view.Principal.Tablero.TableroView;

import java.util.List;

public class DisposicionPrincipal extends BorderPane {

    public DisposicionPrincipal(Configuracion configuracion, List<Jugador> jugadores, Stage ventana) {
        TableroView tableroVista = new TableroView(configuracion);
        Tablero tablero = new Tablero(jugadores, configuracion);
        Juego juego = new Juego(jugadores, tablero, configuracion);
        OpcionesView opcionesView = new OpcionesView(juego, configuracion, tableroVista, jugadores, ventana);
        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #20AAFA, #6E6EFA 100%)");
        this.setCenter(tableroVista);
        this.setRight(opcionesView);
    }
}
