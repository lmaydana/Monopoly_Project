package Casilleros;

public class DeshipotecadorActivo implements Deshipotecador {

    private String nombrePropiedad;
    private Arrendador arrendador;
    public DeshipotecadorActivo(String nombrePropiedad, Arrendador arrendador) {
        this.nombrePropiedad =nombrePropiedad;
        this.arrendador = arrendador;
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        Banco banco = Banco.getBanco();
        banco.deshipotecar(this.nombrePropiedad, cartera);
        return this.arrendador;
    }
}
