package Casilleros;

public class ContratoDeVenta {

    Comprador comprador;
    CasillaComprable propiedad;
    public ContratoDeVenta(Comprador comprador, CasillaComprable propiedad) {
        this.comprador = comprador;
        this.propiedad = propiedad;
    }

    public void aceptarContrato(){
        try {
            propiedad.seCompradaPor(this.comprador);
        }catch (CantidadInsuficiente e){

        }
    }
}
