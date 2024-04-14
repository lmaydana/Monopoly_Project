package org.fiuba.algo3.Jugador;

import org.fiuba.algo3.Casilleros.*;
import org.fiuba.algo3.Casilleros.Arrendador.Arrendador;
import org.fiuba.algo3.Casilleros.Contrato.Contrato;
import org.fiuba.algo3.Casilleros.Contrato.ContratoSinEfecto;

import java.util.ArrayList;

public class Jugador implements Arrendador, Comprador, Posicionable {

    private ArrayList<Transporte> transportes;

    private ArrayList<Propiedad> propiedades;

    private Casillero casilleroActual;

    private Contrato contratoActual;


    //0 = en juego, 1 = preso,2 = bancarota
    private char estado;
    private double dinero;
    private int diasRestantesCondena;

    private int diasCondena;
    private double fianza;
    private int maxDado;

    public Jugador(Inicio casilleroDePartida){
        this.transportes = new ArrayList<>();
        this.propiedades = new ArrayList<>();
        this.casilleroActual = casilleroDePartida;
        this.contratoActual = new ContratoSinEfecto();
        this.diasRestantesCondena = 0;
        this.estado = 0;

        this.diasCondena = 6;
        this.fianza = 200;
        this.maxDado = 12;
    }

    @Override
    public void acordar(Jugador jugador, CasillaComprable propiedad) {

    }

    @Override
    public void despojarseDeCasilla(CasillaComprable propiedad, Comprador comprador) {

    }

    @Override
    public void recibirTransferencia(Double monto) {
        dinero += monto;
    }

    @Override
    public void transferir(Double monto, Transferible vendedor) {
        if (dinero >= monto){
            vendedor.recibirTransferencia(monto);
            dinero -= monto;
        }else{
            this.estado = 2;
            vendedor.recibirTransferencia(dinero);
            dinero = 0;
        }

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
        this.diasRestantesCondena = diasCondena;
        this.estado = 1;
    }
    public boolean pagarFiansa(){
        if (dinero < fianza){
            return false;
        }
        this.dinero -= fianza;
        this.diasCondena = 0;
        this.estado = 0;
        return true;
    }
    public boolean estaPreso(){
        return (estado == 1);
    }
    public boolean estaQuebrado(){
        return (estado == 2);
    }
    @Override
    public void posicionarEn(Casillero casillero) {
        this.casilleroActual = casillero;
    }
    public int mover(){
        int mover = (int)Math.floor(Math.random()*maxDado + 1);
        if (this.estado ==0){
            return mover;
        }else if(this.estado == 1){
            if (this.diasRestantesCondena < mover){
                this.diasRestantesCondena = 0;
                this.estado = 0;
                return mover;
            }else{
                this.diasRestantesCondena -= 1;
            }

        }
        return 0;
    }

}
