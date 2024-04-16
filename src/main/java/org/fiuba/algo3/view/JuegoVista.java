package src.main.java.org.fiuba.algo3.view;


import java.util.ArrayList;
import java.util.List;

public class JuegoVista {

    protected static List<String> opcionesPorTurno = new ArrayList<>();

    static {
        opcionesPorTurno.add("Terminar su turno");
        opcionesPorTurno.add("Construir o reformar en una de sus propiedades");
        opcionesPorTurno.add("Vender alguna de sus construcciones");
        opcionesPorTurno.add("Hipotecar una propiedad al banco");
        opcionesPorTurno.add("Des-hipotecar una de sus propiedades");
        opcionesPorTurno.add("En caso de estar en prisión:\n  - Pagar la fianza");
        opcionesPorTurno.add("En caso de estar sobre una casilla de propiedad vacía:\n  - Comprar la propiedad");
    }

    public void mostrarTurno(){
        //mostrar resultado de dados (lo hace el juego)
        //mostrar tablero
        //mostrar opciones
    }
}
