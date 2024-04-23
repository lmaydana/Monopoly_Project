package org.fiuba.algo3;

import javafx.scene.paint.Color;
import org.fiuba.algo3.model.Config;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.view.Consola;


import java.util.ArrayList;
import java.util.List;

public class JuegoMaster {
    private Turnador turnador;
    private Consola consola;
    private int cantidadJugadores;
    public Juego juego;

    protected void iniciar() {
        this.inicializarDatos();
        while(!(juego.seAcabo())){
            for (int i=0; i < cantidadJugadores && !(juego.seAcabo()); i++){
                //turnador.jugarTurno();
            }
        }
    }


    private void inicializarDatos(){
        this.consola = Consola.getInstance("e");
        this.cantidadJugadores = consola.pedirCantidadJugadores();
        List<String> nombresJugadores = new ArrayList<>();
        List<String> coloresJugadores = new ArrayList<>();
        for (int i = 1; i<= this.cantidadJugadores; i++){
            coloresJugadores.add(consola.pedirNombre());
            nombresJugadores.add(consola.pedirColor());
        }
        List<Jugador> jugadores = this.crearJugadores(nombresJugadores, coloresJugadores);
        //this.juego = new Juego(jugadores);
        this.turnador = new Turnador(juego, jugadores);
    }

    private List<Jugador> crearJugadores(List<String> nombresJugadores, List<String> coloresJugadores) {
        List<Jugador> jugadores= new ArrayList<>();
        for(int i = 1; i <= cantidadJugadores; i++){
            jugadores.add(new Jugador(nombresJugadores.get(i), Color.valueOf(coloresJugadores.get(i)), new Config()));
        }
        return jugadores;
    }

}


