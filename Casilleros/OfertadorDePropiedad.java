package Casilleros;

public class OfertadorDePropiedad implements Ofertador {

    private CasillaComprable propiedad;

    public OfertadorDePropiedad(CasillaComprable propiedad){
        this.propiedad = propiedad;
    }


    @Override
    public void ofertar(Jugador comprador) {
        ContratoDeVenta contrato = new ContratoDeVenta(comprador, this.propiedad);
        comprador.recibir(contrato);
    }
}
