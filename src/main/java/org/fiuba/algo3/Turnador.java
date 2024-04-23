package org.fiuba.algo3;

import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.view.Consola;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Turnador {
    private Consola consola;
    private Juego juego;
    private final List<Jugador> jugadores;

    private Iterator<Jugador> iteradorJugadores;


    public Turnador(Juego juego, List<Jugador> jugadores){
        this.juego = juego;
        this.jugadores = jugadores;
        this.iteradorJugadores = this.jugadores.iterator();
    }

    public void jugarTurno() {
        //Opciones :
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
            if(!iteradorJugadores.hasNext())
                iteradorJugadores = this.jugadores.iterator();
            Jugador jugador = iteradorJugadores.next();
            juego.moverJugador();
            Integer opcion = 0;
            String nombrePropiedad;
            ArrayList<String> propiedades = jugador.getNombrePropiedades();
            while(opcion != 1 ) {
                switch (opcion) {
                    case 2:
                        nombrePropiedad = consola.pedirDato(propiedades, "Elija la propiedad a reformar o construir");
                        jugador.construirEn(nombrePropiedad);

                    case 3:
                        nombrePropiedad = consola.pedirDato(propiedades, "Elija la propiedad desde la cual se venderan las construcciones:");
                        Integer cantidadAVender = consola.pedirDatoInt("Elija la cantidad de construccione a vender: ");
                        jugador.venderConstruccion(nombrePropiedad);

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
        }catch (Exception e){
        //Implementar que si se queda sin plata, pueda hipotecar y vender construcciones.
    }
    }

}
