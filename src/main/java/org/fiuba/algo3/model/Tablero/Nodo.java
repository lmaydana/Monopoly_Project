package org.fiuba.algo3.model.Tablero;

public class Nodo<T> {
    protected T dato;
    protected Nodo<T> siguiente;

    public Nodo(T dato, Nodo<T> prox) {
        this.dato = dato;
        this.siguiente = prox;
    }
}
