package org.fiuba.algo3.model;


import org.fiuba.algo3.view.Consola;

public class Validacion {

    public boolean validarIndice(int eleccion, int cantidadElementos){

        return (eleccion > 0) && (eleccion <= cantidadElementos);
    }

    public void indiceCorrecto(int eleccion, int cantidadElementos){
        Consola consola = Consola.getInstance("yes");
        while(!(validarIndice( eleccion, cantidadElementos))){
            consola.mensajeDeError("Eleccion incorrecta, elije el numero de alguna de las opciones disponibles");
        }
    }
}
