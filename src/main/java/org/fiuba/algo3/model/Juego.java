package org.fiuba.algo3.model;

import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.Tablero;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Juego {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Random dado;

    public Juego(List<Jugador> jugadores){
        this.jugadores = jugadores;
        this.tablero = new Tablero(this.jugadores);
        this.dado = new Random();
    }

    public void moverJugador(Jugador jugador) throws Exception{
        this.tablero.mover(jugarDado(), jugador);
    }

    public Integer jugarDado(){
        this.dado.setSeed(new Date().getTime());
        return this.dado.nextInt(1,7);
    }

    public boolean seAcabo(){
        //todo
        return false;
    }
}
