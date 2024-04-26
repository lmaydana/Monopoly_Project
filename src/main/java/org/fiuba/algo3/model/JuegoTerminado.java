package org.fiuba.algo3.model;

public class JuegoTerminado implements EstadoJuego{
    @Override
    public EstadoDeContinuidad obtenerEstado() {
        return EstadoDeContinuidad.TERMINO;
    }
}
