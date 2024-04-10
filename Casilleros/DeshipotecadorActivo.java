package Casilleros;

public class DeshipotecadorActivo implements Deshipotecador {

    private String nombrePropiedad;
    private Arrendador arrendador;
    private Banco banco;

    public DeshipotecadorActivo(String nombrePropiedad, Arrendador arrendador, Banco banco) {
        this.nombrePropiedad = nombrePropiedad;
        this.arrendador = arrendador;
        this.banco = banco;
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        this.banco.deshipotecar(this.nombrePropiedad, cartera);
        return this.arrendador;
    }
}
