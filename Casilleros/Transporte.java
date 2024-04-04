package Casilleros;

public class Transporte extends CasillaComprable{

    private Double costoRenta;

    private CentroDeTransportes centroDeTransportes;


    public Transporte(Double costoDeVenta, Double costoRenta, CentroDeTransportes centroDeTransportes) {
        super(costoDeVenta);
        this.costoRenta = costoRenta;
        this.centroDeTransportes = centroDeTransportes;
    }

    @Override
    public Double tasar() {
        return this.centroDeTransportes.devolverPrecioTotal(this.arrendador, this.costoRenta);
    }

}
