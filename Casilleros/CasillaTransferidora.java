package Casilleros;

public abstract class CasillaTransferidora implements Casillero{

    protected Double montoACobrar;

    public CasillaTransferidora(Double montoACobrar){
        this.montoACobrar = montoACobrar;
    }
}
