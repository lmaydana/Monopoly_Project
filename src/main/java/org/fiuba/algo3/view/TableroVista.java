package org.fiuba.algo3.view;

import org.fiuba.algo3.model.Config;

public class TableroVista {

    public void mostrarTablero(){
        CasilleroVista casilleroVista = new CasilleroVista();
        Config config = new Config();
        for (int i = 0; i <= config.cantTotalCasillas; i++) {
            System.out.print(i + ".|");
            casilleroVista.mostrarCasillero();
        }
            System.out.print("|\n");
    }
}

