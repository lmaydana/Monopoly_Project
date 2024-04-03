package Casilleros;

import java.util.ArrayList;

public class ReceptorDePropiedades implements Receptor<Propiedad>{

    private ArrayList<Propiedad> propiedades;

    public ReceptorDePropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    @Override
    public void recibir(Propiedad propiedad) {
        this.propiedades.add(propiedad);
    }
}
