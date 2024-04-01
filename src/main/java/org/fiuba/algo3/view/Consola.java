package org.fiuba.algo3.view;
import org.fiuba.algo3.view.ASCIIArt;

import java.util.*;
import java.util.Scanner;

public class Consola {
    public Consola(){

        ASCIIArt arte = new ASCIIArt();
        arte.run();
        bienvenida();
        pedirDatosIniciales();

    }

    private void bienvenida(){
        System.out.println("""
                ¡Bienvenido al Monopoly-morphic, donde los tratos se hacen y se rompen más
                rápido que una promesa electoral! Prepárate para ser un magnate inmobiliario
                 o caer en la bancarrota intentándolo.

                 ¡Que comience el juego y que la estrategia más astuta gane!
                """);
    }

    public int mostrarOpciones(List<String> elementos){

        Scanner scanner = new Scanner(System.in);
        int eleccion;
        for (int i = 1; i<= elementos.size(); i++){

            System.out.println(i + "." + elementos.get(i));
        }
        eleccion = scanner.nextInt();
        scanner.close();
        return eleccion;
    }

    public void pedirDatosIniciales(){

    }

    public void decirOrdenJugadores(){

    }

    public void lanzarDados(){

    }
}


