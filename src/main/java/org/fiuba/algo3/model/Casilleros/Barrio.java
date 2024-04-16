package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorDeInmuebles;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;

import java.util.ArrayList;

public abstract class Barrio {

    private String nombreBarrio;
    private ArrayList<Propiedad> propiedadesDelBarrio;

    private Banco banco;


    public Barrio(String nombreGrupo, Banco banco){
        this.nombreBarrio = nombreGrupo;
        this.propiedadesDelBarrio = new ArrayList<>();
        this.banco = banco;
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

    public Constructor obtenerConstructorAprobado(Arrendador arrendador, Terreno terreno, ArrayList<Double> precios){
        if( this.tienenElMismoArrendador(arrendador) ){
            return new ConstructorDeInmuebles(this.banco, terreno, precios);
        }
        return new ConstructorNulo();

    }
}
