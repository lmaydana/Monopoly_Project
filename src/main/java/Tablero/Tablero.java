package Tablero;
public class Tablero {
    private ListaCircular<Casillero> tablero;
    private Config config;
    public Tablero(){
        this.tablero = new ListaCircular<Casillero>();
        this.config = new Config();
        this.inicializarTablero();
    }


    private void inicializarTablero() {
        //me dijo el profe que lo hardcodee en la config u otro lado por ahora
    }



    public Casillero mover(int origen, int pasos){
        return this.tablero.mover(origen, pasos);
    }

    public Casillero getCasillero(int indice){
        return this.tablero.get(indice);
    }
}
