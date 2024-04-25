package org.fiuba.algo3.model.Casilleros;

public class ListaDeFirmas {

    Integer cantidadDeFirmas;

    Integer firmasNecesarias;

    Runnable accionARealizar;

    public ListaDeFirmas(Integer firmasNecesarias, Runnable accionARealizar){
        this.cantidadDeFirmas = 0;
        this.firmasNecesarias = firmasNecesarias;
        this.accionARealizar = accionARealizar;
    }

    public void firmar() {
        this.cantidadDeFirmas++;
    }

    public void ejecutarAccion(){
        if (this.cantidadDeFirmas >= this.firmasNecesarias){
            this.accionARealizar.run();
        }
    }
}
