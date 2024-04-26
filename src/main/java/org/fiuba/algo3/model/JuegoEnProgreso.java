package org.fiuba.algo3.model;

public class JuegoEnProgreso implements EstadoJuego{
    @Override
    public EstadoDeContinuidad obtenerEstado() {
        return EstadoDeContinuidad.CONTINUA;
    }
}
