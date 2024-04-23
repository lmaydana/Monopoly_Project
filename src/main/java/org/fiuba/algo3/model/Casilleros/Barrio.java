package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorDeInmuebles;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;

import java.util.ArrayList;
import java.util.HashMap;

public class Barrio {

    private String nombreBarrio;
    private ArrayList<Propiedad> propiedadesDelBarrio;



    public Barrio(String nombreGrupo){
        this.nombreBarrio = nombreGrupo;
        this.propiedadesDelBarrio = new ArrayList<>();
    }

    public void agregarPropiedad( Propiedad propiedad ){
        this.propiedadesDelBarrio.add(propiedad);
    }

    private boolean tienenElMismoArrendador(Arrendador arrendador){
        for( Propiedad propiedad: this.propiedadesDelBarrio){
            if( !propiedad.tieneArrendador(arrendador) )
                return false;
        }
        return true;
    }

    public Constructor obtenerConstructorAprobado(Arrendador arrendador, Terreno terreno){
        if( this.tienenElMismoArrendador(arrendador) ){
            return new ConstructorDeInmuebles( terreno );
        }
        return new ConstructorNulo();

    }

    public void agegarInfoColor(HashMap<String, String> infoCasillero) {
        infoCasillero.put("color", this.nombreBarrio);
    }
}
