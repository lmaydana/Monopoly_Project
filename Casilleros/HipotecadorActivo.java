package Casilleros;

public class HipotecadorActivo implements Hipotecador{


    private String nombrePropiedad;
    private Arrendador arrendador;

    public HipotecadorActivo(String nombrePropiedad, Arrendador arrendador) {
        this.nombrePropiedad = nombrePropiedad;
        this.arrendador = arrendador;
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        Banco banco = Banco.getBanco();
        banco.hipotecar( this.nombrePropiedad, cartera );
        return new ArrendadorHipotecado(this.arrendador);
    }
}
