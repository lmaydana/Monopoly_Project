package Casilleros;

public class HipotecadorNulo implements Hipotecador {

    private Arrendador arrendadorHipotecado;
    public HipotecadorNulo(Arrendador arrendadorHipotecado) {
        this.arrendadorHipotecado = arrendadorHipotecado;
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        return this.arrendadorHipotecado;
    }
}
