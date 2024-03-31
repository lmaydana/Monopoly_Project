package org.fiuba.algo3;

public class Consola {
    public Consola(){

        ASCIIArt arte = new ASCIIArt();
        arte.run();
        bienvenida();

    }

    private void bienvenida(){
        System.out.println("""
                ¡Bienvenido al Monopoly-morphic, donde los tratos se hacen y se rompen más
                rápido que una promesa electoral! Prepárate para ser un magnate inmobiliario
                 o caer en la bancarrota intentándolo.

                 ¡Que comience el juego y que la estrategia más astuta gane!
                """);
    }

}


