package Casilleros;

import java.util.ArrayList;

public abstract class Grupo {

    private String nombreGrupo;
    private ArrayList<Propiedad> propiedadesDelGrupo;


    public Grupo(String nombreGrupo){
        this.nombreGrupo = nombreGrupo;
        this.propiedadesDelGrupo = new ArrayList<>();
    }

    public void agregarPropiedad( Propiedad propiedad ){
        this.propiedadesDelGrupo.add(propiedad);
    }

    private boolean tienenElMismoArrendador(Arrendador arrendador){
        for( Propiedad propiedad: this.propiedadesDelGrupo ){
            if( !propiedad.esElMismoPropietario(arrendador) )
                return false;
        }
        return true;
    }

    public Constructor obtenerConstructor(Arrendador arrendador, Terreno terreno, ArrayList<Double> precios){
        if( this.tienenElMismoArrendador(arrendador) ){
            return new ConstructorDeInmuebles(arrendador, terreno, precios);
        }
        return new ConstructorNulo();

    }
}
