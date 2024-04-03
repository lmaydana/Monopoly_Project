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
    public void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador) {
        this.propiedades.remove(propiedad);
    }
}
