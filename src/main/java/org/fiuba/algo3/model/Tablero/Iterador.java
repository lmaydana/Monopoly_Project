package org.fiuba.algo3.model.Tablero;

public class Iterador<T> {
    private Nodo<T> nodoActual;
    private Nodo<T> nodoInicial;
    public Iterador(Nodo<T> nodoActual){
        this.nodoInicial = nodoActual;
        this.nodoActual = nodoActual;
    }

    public boolean tieneSiguiente(){
        return (this.nodoActual.siguiente != null);
    }

    public void avanzar(){
        this.nodoActual = this.nodoActual.siguiente;
    }

    public T obtenerActual(){
        return this.nodoActual.dato;
    }

    public boolean estaAlPrincipio(){
        return nodoActual.dato == nodoInicial.dato;
    }
}
