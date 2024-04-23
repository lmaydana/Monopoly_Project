package org.fiuba.algo3.model.Tablero;

public class Iterador<T> {
    private Nodo<T> nodoActual;
    private Nodo<T> nodoInicial;
    private Nodo<T> nodoReferencia;
    public Iterador(Nodo<T> nodoActual){
        this.nodoInicial = nodoActual;
        this.nodoActual = nodoActual;
        this.nodoReferencia = nodoActual;
    }

    public boolean tieneSiguiente(){
        return ( this.nodoActual != null && this.nodoActual.siguiente != null);
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

    public void avanzarHasta(T valor) {
        this.nodoReferencia = nodoActual;
        do{
            nodoActual = nodoActual.siguiente;

        }while(nodoActual != nodoReferencia && nodoActual.dato != valor);
    }
}
