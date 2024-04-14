package org.fiuba.algo3.view;

import org.fiuba.algo3.model.Validacion;
import org.fiuba.algo3.model.Juego;
import java.util.*;
import java.util.Scanner;

public class Consola {
    public String value;
    private static Consola instance;

    private Consola(String value) {
        this.value = value;
        ASCIIArt arte = new ASCIIArt();
        arte.run();
        bienvenida();
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

    private void mostrarColores() {
        Colores[] colores = Colores.values();
        for (int i = 1; i < colores.length; i++) {
            System.out.print(colores[i].name() + ' ');
        }
    }

    public void mostrarOrdenJugadores(){

    }

    public void mostrarDado(){System.out.println(juego.jugarDado);}

    public void mensajeDeError(String mensaje){System.out.println(mensaje);}

    public int pedirCantidadJugadores() {
        String dato = this.pedirDato("Ingrese la cantidad de jugadores:");
        return Integer.parseInt(dato);
    }

    public String pedirDato(String opcion) {
        System.out.print(opcion);
        Scanner scanner = new Scanner(System.in);
        String eleccion = scanner.next();
        scanner.close();
        return eleccion;
    }

    public Integer pedirDatoInt(String opcion){
        Integer respuesta = Integer.parseInt(this.pedirDato(opcion));
        return respuesta;
    }

    public String pedirDato(ArrayList<String> strings, String encabezado){
        System.out.print(encabezado);
        this.pedirDato(this.string(strings));
    }

    public String pedirNombre() {
        return this.pedirDato("Ingrese el nombre de su jugador:");
    }

    public String pedirColor() {
        return this.pedirDato("Ingrese el color de su jugador:");
    }

    public Integer mostrarOpciones(){
        //todo
        return Integer.parseInt(pedirDato("Opciones del turno"));
    }

    private String string(ArrayList<String> arrayStrings){
        String res = "";
        for (int i = 0; i < arrayStrings.size(); i++) {
            res += i + ". "+  arrayStrings.get(i) + "\n";
        }
        return res;
    }
}


