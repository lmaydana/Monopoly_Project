package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorDeInmuebles;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;
import org.fiuba.algo3.model.Terminable;

import java.util.ArrayList;
import java.util.HashMap;

public class BarrioDePropiedades implements Barrio {

    private String colorBarrio;
    private ArrayList<Propiedad> propiedadesDelBarrio;

    public BarrioDePropiedades(String colorBarrio){
        this.colorBarrio = colorBarrio;
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

    private boolean tieneElterrenoLaDiferenciaJustaDeConstruccionesNecesaria(Terreno terreno, Integer cantidadDeConstruccionesAAgregar ){
        for ( Propiedad propiedad: this.propiedadesDelBarrio){
            if(!propiedad.tieneCantidadDeConstruccionesAceptablesEnComparacionCon(terreno, cantidadDeConstruccionesAAgregar)){
                return false;
            }
        }
        return true;
    }

    public Constructor obtenerConstructorAprobado(Arrendador arrendador, Terreno terreno, Integer cantidadDeConstruccionesAAgregar){
        if( this.tienenElMismoArrendador(arrendador) && this.tieneElterrenoLaDiferenciaJustaDeConstruccionesNecesaria(terreno, cantidadDeConstruccionesAAgregar)){
            return new ConstructorDeInmuebles( terreno );
        }
        return new ConstructorNulo();

    }

    public void agegarInformacionColor(HashMap<String, String> infoCasillero) {
        infoCasillero.put("color", this.colorBarrio);
    }

    public void terminarReformas( Terminable terminable ) {
        ListaDeFirmas listaDeFirmas = new ListaDeFirmas(this.propiedadesDelBarrio.size(), terminable::terminar);

        for( Propiedad propiedad: this.propiedadesDelBarrio ){
            propiedad.firmarFinalizacionDeObras(listaDeFirmas);
        }

        listaDeFirmas.ejecutarAccion();
    }
}
