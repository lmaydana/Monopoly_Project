package org.fiuba.algo3;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.view.Consola;

import java.util.ArrayList;

public class Turnador {
    private Consola consola;
    private Juego juego;


    public Turnador(Consola consola, Juego juego){
        this.consola = consola;
        this.juego = juego;
    }

    public void jugarTurno(int indiceJugador) throws CantidadInsuficiente {
        //● Terminar su turno x
        //● Construir o reformar en una de sus propiedades  x
        //● Vender alguna de sus construcciones x
        //● Hipotecar una propiedad al banco x
        //● Des-hipotecar una de sus propiedades x

        //● En caso de estar en preso:
        //  ○ Pagar la fianza
        // ● En caso de estar sobre una casilla de propiedad vacía:
        //  ○ Comprar la propiedad
        try {
            juego.moverJugador(indiceJugador);
        }catch (Exception e){
            //Implementar que si se queda sin plata, pueda hipotecar y vender construcciones.
        }
        Integer opcion = 0;
        Jugador jugador = juego.getJugador(indiceJugador);
        String nombrePropiedad;
        ArrayList<String> propiedades = jugador.getNombrePropiedades();
        while(opcion != 1 ) {
            opcion = consola.mostrarOpciones();
            switch (opcion) {
                case 2:
                    nombrePropiedad = consola.pedirDato(propiedades, "Elija la propiedad a reformar o construir");
                    jugador.construirEn(nombrePropiedad);
                case 3:
                    nombrePropiedad = consola.pedirDato(propiedades, "Elija la propiedad desde la cual se venderan las construcciones:");
                    Integer cantidadAVender = consola.pedirDatoInt("Elija la cantidad de construccione a vender: ");
                    jugador.venderPropiedades(nombrePropiedad, cantidadAVender);
                case 4:
                    nombrePropiedad = consola.pedirDato(propiedades, "Elija la propiedad a hipotecar");
                    jugador.hipotecar(nombrePropiedad);
                case 5:
                    nombrePropiedad = consola.pedirDato(propiedades, "Elija la propiedad a des-hipotecar");
                    jugador.deshipotecar(nombrePropiedad);
                case 6:


                case 7:
                    jugador.comprarPropiedadOfrecida();
                default:
                    consola.mensajeDeError("No es una opcion correcta...");

            }
        }
    }

}
