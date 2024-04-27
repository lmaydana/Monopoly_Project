package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.model.Casilleros.Constructor.Constructor;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorDeInmuebles;
import org.fiuba.algo3.model.Casilleros.Constructor.ConstructorNulo;
import org.fiuba.algo3.model.Terminable;

import java.util.HashMap;

public interface Barrio {
    void agregarPropiedad( Propiedad propiedad );

    Constructor obtenerConstructorAprobado(Arrendador arrendador, Terreno terreno, Integer cantidadDeConstruccionesAAgregar);

    void agegarInformacionColor(HashMap<String, String> infoCasillero);

    void terminarReformas( Terminable terminable );
}
