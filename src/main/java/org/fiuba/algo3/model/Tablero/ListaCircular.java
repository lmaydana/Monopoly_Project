package src.main.java.org.fiuba.algo3.model.Tablero;

import src.main.java.org.fiuba.algo3.model.Tablero.Nodo;
import src.main.java.org.fiuba.algo3.model.Tablero.Iterador;

public class ListaCircular<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int len;

    public ListaCircular(){
        this.primero = null;
        this.ultimo = null;
        this.len = 0;
    }

    public T get(int indice){
        if(indice == 0 ){
            return this.primero.dato;
        } else if (indice == this.len) {
            return this.ultimo.dato;
        }
        Nodo<T> nodoActual = this.primero.siguiente;
        int contador = 1;
        while (contador < indice){
            nodoActual = nodoActual.siguiente;
            contador++;
        }
        return nodoActual.dato;
    }

    private Nodo<T> obtenerOrigen(int origen){
        //casos en donde es el primero o el ultimo el origen
        if(origen == 0){
            return this.primero;
        } else if(origen == this.len){
            return this.ultimo;
        }
        Nodo<T> actual = this.primero.siguiente;
        int contador = 1;
        while(contador < origen){
            actual = actual.siguiente;
            contador++;
        }
        return actual;
    }

    public T mover(int origen, int pasos){
        if(origen < 0 || pasos < 0){
            throw new IndexOutOfBoundsException("El origen o la cantidad de los pasos no puede ser negativas");
        }
        Nodo<T> nodoActual = obtenerOrigen(origen);
        int contador = 0;

        while(contador < pasos){
            nodoActual = nodoActual.siguiente;
            contador++;
        }

        return nodoActual.dato;
    }

    public void append(T dato) {
        if (this.primero == null) {
            Nodo<T> nuevoNodo = new Nodo<T>(dato, null);
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
            nuevoNodo.siguiente = this.primero;
        } else {
            Nodo<T> nuevoNodo = new Nodo<T>(dato, this.primero);
            this.ultimo.siguiente = nuevoNodo;
            this.ultimo = nuevoNodo;
        }
        this.len++;
    }

    public Iterador<T> iterador(){
        return new Iterador<>(primero);
    }

    public int getLen(){
        return this.len;
    }

}
