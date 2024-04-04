package Casilleros;

//Probablemente no se necesite esta clase, ya que el casillero de loteria hace lo mismo.

public class Inicio extends CasillaTransferidora {

    public Inicio(Double montoACobrar) {
        super(montoACobrar);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        Banco banco = Banco.getBanco();
        banco.transferir(this.montoACobrar, jugador);
    }
}
