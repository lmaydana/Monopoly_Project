package org.fiuba.algo3.model.Casilleros.Constructor;

import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Cartera.Cartera;
import org.fiuba.algo3.model.Casilleros.Terreno;

public class ConstructorDeInmuebles implements Constructor{
    private Terreno terreno;
    public ConstructorDeInmuebles(Terreno terreno){
        this.terreno = terreno;
    }

    @Override
    public void construir(Cartera cartera) throws CantidadInsuficiente {
        this.terreno.edificar(cartera);
    }
}
