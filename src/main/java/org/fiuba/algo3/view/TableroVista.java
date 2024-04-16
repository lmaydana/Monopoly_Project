package src.main.java.org.fiuba.algo3.view;

import src.main.java.org.fiuba.algo3.model.Config;
import src.main.java.org.fiuba.algo3.view.CasilleroVista;

public class TableroVista {

    public void mostrar(){
        CasilleroVista casilleroVista = new CasilleroVista();
        Config config = new Config();
        for (int i = 0; i <= config.cantTotalCasillas; i++) {
            System.out.print(i + ".|");
            casilleroVista.mostrar();
        }
            System.out.print("|\n");
    }
}

