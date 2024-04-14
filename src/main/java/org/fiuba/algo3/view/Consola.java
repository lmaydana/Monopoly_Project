package org.fiuba.algo3.view;

import org.fiuba.algo3.model.Validacion;
import java.util.*;
import java.util.Scanner;
import org.fiuba.algo3.model.Config;

public class Consola {
    public String value;
    private static Consola instance;

    private Consola(String value) {
        this.value = value;
        ASCIIArt arte = new ASCIIArt();
        arte.run();
        bienvenida();
        pedirDatosIniciales();
    }

    public static Consola getInstance(String value) {
        if (instance == null) {
            instance = new Consola(value);
        }
        return instance;
    }

    private void bienvenida(){
        System.out.println("""
                ¡Bienvenido al Monopoly-morphic, donde los tratos se hacen y se rompen más
                rápido que una promesa electoral! Prepárate para ser un magnate inmobiliario
                 o caer en la bancarrota intentándolo.

                 ¡Que comience el juego y que la estrategia más astuta gane!
                """);
    }

    public int mostrarOpciones(List<String> opciones){

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i<= opciones.size(); i++){

            System.out.println(i + "." + opciones.get(i));
        }
        int eleccion = scanner.nextInt();
        Validacion validacion = new Validacion();
        validacion.indiceCorrecto(eleccion, opciones.size());

        return eleccion;
    }

    public void pedirDatosIniciales(){

        System.out.println("""
    Ingrese en el siguiente orden los datos iniciales:
    Cantidad de jugadores.
    Nombres de los jugadores.
    Colores de los jugadores.

    Los colores disponibles son: """);
        this.mostrarColores();

    }

    private void mostrarColores() {
        for (Config.colores color : Config.colores.values()) {

            System.out.print(color.name() + ' ');
        }
    }

    public void mostrarOrdenJugadores(){

    }

    public void mostrarDado(){

    }

    public void mostrarTablero(){


    }

    public void mensajeDeError(String mensaje){
        System.out.println(mensaje);
    }
}


