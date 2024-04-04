package Casilleros;

import java.util.ArrayList;

public class ConstructorDeInmuebles implements Constructor{
    private Arrendador arrendador;
    private Terreno terreno;
    private ArrayList<Double> precios;
    public ConstructorDeInmuebles(Arrendador arrendador, Terreno terreno, ArrayList<Double> precios){
        this.arrendador = arrendador;
        this.terreno = terreno;
        this.precios = precios;
    }

    @Override
    public void construir(Cartera cartera) throws CantidadInsuficiente{
        Banco banco = Banco.getBanco();
        Double precioInmueble = this.precios.getFirst();
        cartera.transferir(precioInmueble, banco);
        this.precios.removeFirst();
        this.terreno.edificar();
    }
}
