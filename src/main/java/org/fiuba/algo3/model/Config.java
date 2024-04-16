package src.main.java.org.fiuba.algo3.model;
import src.main.java.org.fiuba.algo3.model.Casilleros.CasillaTransferidora;
import src.main.java.org.fiuba.algo3.model.Casilleros.Casillero;
import src.main.java.org.fiuba.algo3.model.Casilleros.Inicio;
import src.main.java.org.fiuba.algo3.model.Casilleros.Propiedad;
import src.main.java.org.fiuba.algo3.model.Tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public Integer cantTotalCasillas = 50;
    protected Integer cantCasillasPaso = 16;
    protected Integer cantCasillasPropiedades = 21;
    protected Integer cantCasillasLoterias = 4;
    protected Integer cantCasillasMulta= 2;
    protected Integer cantCasillasIrCarcel = 1;
    protected Integer cantCasillasCarcel = 1;
    protected Integer cantCasillasTransporte = 4;

    protected Double cantDineroJugadorInicial = 1500.0;
    protected Double cantDineroCasilleroInicial = 500.0;

    public List<Casillero> distribucion(){
        ArrayList<Casillero> casilleros = new ArrayList<>();
//        casilleros.add(new Inicio(cantDineroCasilleroInicial,));
        return casilleros;
    }

    public Double obtenerMontoDePlataIncial() {
        return this.cantDineroJugadorInicial;
    }
}
