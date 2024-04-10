package Casilleros;

public class Multa extends CasillaTransferidora{

    public Multa(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        jugador.transferir(this.montoACobrar, this.banco);
    }
}
