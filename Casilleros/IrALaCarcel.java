package Casilleros;

public class IrALaCarcel extends Casillero{

    private Carcel carcel;

    public IrALaCarcel(Carcel carcel){
        this.carcel = carcel;
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        super.recibirJugador(jugador);
        this.carcel.recibirJugador(jugador);
        this.carcel.encarcelar(jugador);
    }
}
