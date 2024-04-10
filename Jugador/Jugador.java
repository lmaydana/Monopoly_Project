package Jugador;

import Casilleros.*;
import Casilleros.Arrendador.Arrendador;
import Casilleros.Contrato.Contrato;
import Casilleros.Contrato.ContratoSinEfecto;

import java.util.ArrayList;

public class Jugador implements Arrendador, Comprador, Posicionable {

    private ArrayList<Transporte> transportes;

    private ArrayList<Propiedad> propiedades;

    private Casillero casilleroActual;

    private Contrato contratoActual;

    public Jugador(Inicio casilleroDePartida){
        this.transportes = new ArrayList<>();
        this.propiedades = new ArrayList<>();
        this.casilleroActual = casilleroDePartida;
        this.contratoActual = new ContratoSinEfecto();
    }

    @Override
    public void acordar(Jugador jugador, CasillaComprable propiedad) {

    }

    @Override
    public void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador) {

    }

    @Override
    public void recibirTransferencia(Double monto) {

    }

    @Override
    public void transferir(Double monto, Transferible vendedor) {

    }

    public void recibir(Propiedad propiedad) {
        this.propiedades.add(propiedad);
    }

    public void recibir(Transporte transporte){
        this.transportes.add(transporte);
    }

    public void recibir(Contrato contratoDeVenta){
        this.contratoActual = contratoDeVenta;
    }

    public void perderOferta() {
        this.contratoActual = new ContratoSinEfecto();
    }

    public void encarcelar() {
    }

    @Override
    public void posicionarEn(Casillero casillero) {
        this.casilleroActual = casillero;
    }
}
