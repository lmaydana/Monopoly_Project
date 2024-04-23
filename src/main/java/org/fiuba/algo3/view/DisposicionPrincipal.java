package org.fiuba.algo3.view;

import javafx.scene.layout.BorderPane;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.ListaCircular;
import org.fiuba.algo3.model.Tablero.Tablero;

import java.util.List;

public class DisposicionPrincipal extends BorderPane {

    private Config configuracion;

    private Juego juego;

    public DisposicionPrincipal(Config configuracion, List<Jugador> jugadores) {
        this.configuracion = configuracion;
        TableroView tableroVista = new TableroView(configuracion);
        Tablero tablero = new Tablero(jugadores, configuracion);
        this.juego = new Juego(jugadores, tablero, configuracion);
        this.setCenter(tableroVista);
        OpcionesView opcionesView = new OpcionesView(juego, configuracion, tableroVista);
        this.setRight(opcionesView);
    }
}
