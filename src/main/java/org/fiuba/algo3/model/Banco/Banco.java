package org.fiuba.algo3.model.Banco;
import org.fiuba.algo3.model.Jugador.Transferible;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;

import java.util.HashMap;

public class Banco implements Transferible {

    private HashMap<String, Double> preciosHipotecas;
    private HashMap<String, Double> preciosDeshipotecas;

    public Banco(){
        this.preciosHipotecas = new HashMap<>();
        this.preciosDeshipotecas = new HashMap<>();
    }

    public void transferir(Double monto, Transferible transferible){
        transferible.recibir(monto);
    }
    @Override
    public void recibir(Double monto) {

    }

    public void deshipotecar(String nombrePropiedad, Cartera cartera) throws CantidadInsuficiente {
        cartera.transferir(this.preciosDeshipotecas.get(nombrePropiedad), this);
    }

    public void agregarHipoteca( String nombrePropiedad, Double precioHipoteca ){
        this.preciosHipotecas.putIfAbsent(nombrePropiedad, precioHipoteca);
    }

    public void agregarDeshipoteca( String nombrePropiedad, Double precioDeshipoteca ){
        this.preciosDeshipotecas.putIfAbsent(nombrePropiedad, precioDeshipoteca);
    }

    public void hipotecar(String nombrePropiedad, Cartera cartera) {
        cartera.recibir(this.preciosHipotecas.get(nombrePropiedad));
    }
}
