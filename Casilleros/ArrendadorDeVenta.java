package Casilleros;

import java.util.ArrayList;

public class ArrendadorDeVenta implements Arrendador{

    private ArrayList<CasillaComprable> propiedades;

    public ArrendadorDeVenta() {
        this.propiedades = new ArrayList<>();
    }

    public void agregarPropiedad(CasillaComprable propiedad){
        this.propiedades.add(propiedad);
    }

    @Override
    public void acordar(Jugador jugador, CasillaComprable propiedad) {
        ContratoDeVenta contrato = new ContratoDeVenta(jugador, propiedad);
        jugador.recibir(contrato);
    }

    @Override
    public void recibirTransferencia(Double monto) {

    }

    @Override
    public void cesarPropiedad(CasillaComprable propiedad, Comprador comprador) {
        comprador.recibir(propiedad);
        this.propiedades.remove(propiedad);
    }
}
