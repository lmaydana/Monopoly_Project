package Casilleros;

public class ContratoDeVenta implements Contrato{

    Jugador comprador;
    CasillaComprable propiedad;
    public ContratoDeVenta(Jugador comprador, CasillaComprable propiedad) {
        this.comprador = comprador;
        this.propiedad = propiedad;
    }

    public void aceptar(){
        try {
            propiedad.seCompradaPor(this.comprador);
        }catch (CantidadInsuficiente e){

        }
    }

    @Override
    public void rechazar() {
        this.comprador.perderOferta();
    }
}
