package org.fiuba.algo3.model;

public class JuegoTerminado implements EstadoJuego{
    @Override
    public String obtenerEstado() {
        return "Juego Terminado";
    }
}
