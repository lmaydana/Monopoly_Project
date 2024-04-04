package Casilleros;

public class Multa extends CasillaTransferidora{

    public Multa(Double montoACobrar) {
        super(montoACobrar);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        Banco banco = Banco.getBanco();
        jugador.transferir(this.montoACobrar, banco);
    }
}
