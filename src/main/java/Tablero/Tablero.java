package Tablero;

public class Tablero {
    private ListaCircular<Casillero> tablero;

    public Casillero    mover(int origen, int pasos){
        return this.tablero.mover(origen, pasos);
    }

    public Casillero getCasillero(int indice){
        return this.tablero.get(indice);
    }
}
