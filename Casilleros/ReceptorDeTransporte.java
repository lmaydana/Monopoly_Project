package Casilleros;

import java.util.ArrayList;

public class ReceptorDeTransporte implements Receptor<Transporte>{

    private ArrayList<Transporte> transportes;

    public ReceptorDeTransporte(ArrayList<Transporte> transportes){
        this.transportes = transportes;
    }

    @Override
    public void recibir(Transporte transporte) {
        this.transportes.add(transporte);
    }
}
