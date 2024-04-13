package org.fiuba.algo3.Casilleros.Constructor;

import org.fiuba.algo3.Banco.Banco;
import org.fiuba.algo3.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.Cartera.Cartera;
import org.fiuba.algo3.Casilleros.Terreno;

import java.util.ArrayList;

public class ConstructorDeInmuebles implements Constructor{
    private Banco banco;
    private Terreno terreno;
    private ArrayList<Double> precios;
    public ConstructorDeInmuebles(Banco banco, Terreno terreno, ArrayList<Double> precios){
        this.banco = banco;
        this.terreno = terreno;
        this.precios = precios;
    }

    @Override
    public void construir(Cartera cartera) throws CantidadInsuficiente {
        Double precioInmueble = this.precios.getFirst();
        cartera.transferir(precioInmueble, this.banco);
        this.precios.removeFirst();
        this.terreno.edificar();
    }
}
