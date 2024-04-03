package Tablero;
import java.util.ArrayList;
import java.util.Collections;
public class Tablero {
    private ListaCircular<Casillero> tablero;
    private Config config;
    public Tablero(){
        this.tablero = new ListaCircular<Casillero>();
        this.config = new Config();
        this.inicializarTablero();
    }

    /**
     * Nose si se puede hacer mejor por el momento lo dejo asi, lo que hace es generar de manera aleatoria un tablero
     * cumpliendo que no haya mas de los tipos de casilleros que dice la config.
     *
     */
    private void inicializarTablero() {
        ArrayList<Casillero> lista = generarListaRandom();
        for (Casillero casillero : lista) {
            tablero.append(casillero);
        }
    }

    //TODO: cambiar a los distintos tipos de casilleros
    private ArrayList<Casillero> generarListaRandom(){
        ArrayList<Casillero> lista = new ArrayList<Casillero>();
        for (int i = 0; i < config.cantCasillasPaso; i++) {
            lista.add(new Casillero());
        }
        for (int i = 0; i < config.cantCasillasPropiedades; i++) {
            lista.add(new Casillero());
        }
        for (int i = 0; i < config.cantCasillasLoterias; i++) {
            lista.add(new Casillero());
        }
        for (int i = 0; i < config.cantCasillasMulta; i++) {
            lista.add(new Casillero());
        }
        for (int i = 0; i < config.cantCasillasIrCarcel; i++) {
            lista.add(new Casillero());
        }
        for (int i = 0; i < config.cantCasillasCarcel; i++) {
            lista.add(new Casillero());
        }
        for (int i = 0; i < config.cantCasillasTransporte; i++) {
            lista.add(new Casillero());
        }
        Collections.shuffle(lista);
        //cambiar al inicio
        lista.addFirst(new Casillero());
        return lista;
    }

    public Casillero mover(int origen, int pasos){
        return this.tablero.mover(origen, pasos);
    }

    public Casillero getCasillero(int indice){
        return this.tablero.get(indice);
    }
}
