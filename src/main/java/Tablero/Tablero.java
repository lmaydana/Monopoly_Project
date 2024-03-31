package Tablero;
import java.util.Random;
public class Tablero {
    private ListaCircular<Casillero> tablero;
    private Config config;
    public Tablero(){
        this.tablero = new ListaCircular<Casillero>();
        this.config = new Config();
        this.inicializarTablero();
    }

    //TODO: cambiar por los distintos tipos de casilleros
    private Casillero devolerCasilleroRandom(Random random){
        Casillero casillero = null;
        int numeroRandom = random.nextInt(5);
        switch (numeroRandom){
            case 0:
                //de paso
                casillero = new Casillero();
            case 1:
                //propiedad
                casillero = new Casillero();
            case 2:
                //loteria
                casillero = new Casillero();
            case 3:
                //Multa
                casillero = new Casillero();
            case 4:
                //transporte
                casillero = new Casillero();
        }
        return casillero;
    }
    
    //TODO: Que verifique que se agreguen solamente 4 de loteria, 2 de multa, etc.
    private void inicializarTablero() {
        Random random = new Random();
        int posicionCarcel = random.nextInt(config.cantTotalCasillas);
        int posicionIrCarcel;
        do {
            posicionIrCarcel = random.nextInt(config.cantTotalCasillas);
        } while (posicionCarcel == posicionIrCarcel);

        for (int i = 0; i < config.cantTotalCasillas; i++) {
            if(i == posicionCarcel){
                //casillero de carcel
                this.tablero.append(new Casillero());
            } else if (i == posicionIrCarcel){
                //casillero de ir Carcel
                this.tablero.append(new Casillero());
            }
            Casillero casilleroAgregar = devolerCasilleroRandom(random);
            this.tablero.append(casilleroAgregar);

        }
    }

    public Casillero mover(int origen, int pasos){
        return this.tablero.mover(origen, pasos);
    }

    public Casillero getCasillero(int indice){
        return this.tablero.get(indice);
    }
}
