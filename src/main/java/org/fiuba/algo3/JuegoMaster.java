package org.fiuba.algo3;

import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.view.Consola;


import java.util.ArrayList;
import java.util.List;

public class JuegoMaster {

    private int cantidadJugadores;
    public Juego juego;
 //crear los jugadores con datos que paso la consola

    protected void iniciar() {
        this.inicializarDatos();
        while(!(juego.seAcabo())){
                for (int i=1; i<=cantidadJugadores && !(juego.seAcabo()); i++){

                    juego.jugarTurno(i);
                }
        }
    }


    private void inicializarDatos(){
        Consola consola = Consola.getInstance("e");
        this.cantidadJugadores = consola.pedirCantidadJugadores();
        List<String> nombresJugadores = new ArrayList<>();
        List<String> coloresJugadores = new ArrayList<>();
        for (int i = 1; i<= this.cantidadJugadores; i++){
            coloresJugadores.add(consola.pedirNombre());
            nombresJugadores.add(consola.pedirColor());

        }
        this.crearJugadores(nombresJugadores, coloresJugadores);
    }

    private void crearJugadores(List<String> nombresJugadores, List<String> coloresJugadores) {
        List<Jugador> jugadores= new ArrayList<>();
        for(int i = 1; i <= cantidadJugadores; i++){
            jugadores.add(new Jugador(nombresJugadores.get(i), coloresJugadores.get(i)));
            //el juego recibe una lista de jugadores
        }
    }

}

