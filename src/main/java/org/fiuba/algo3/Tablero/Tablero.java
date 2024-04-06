package org.fiuba.algo3.Tablero;
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


    public Casillero mover(int origen, int pasos, Jugador jugador){
        if (origen + pasos > this.tablero.getLen() + 1){
            //paso por el origen
            Casillero inicio = this.tablero.get(0);
            inicio.recibirJugador(jugador);
        }
        return this.tablero.mover(origen, pasos);
    }


    public Casillero getCasillero(int indice){
        return this.tablero.get(indice);
    }
}
