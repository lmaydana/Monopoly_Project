package Casilleros;

public class IrALaCarcel implements Casillero{

    private Carcel carcel;

    public IrALaCarcel(Carcel carcel){
        this.carcel = carcel;
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        this.carcel.encarcelar(jugador);
    }
}
