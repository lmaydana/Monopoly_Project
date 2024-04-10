package Casilleros;

public class Banco implements Transferible{

    public void transferir(Double monto, Transferible transferible){
        transferible.recibirTransferencia(monto);

    }
    @Override
    public void recibirTransferencia(Double monto) {

    }

    public void deshipotecar(String nombrePropiedad, Cartera cartera) throws CantidadInsuficiente{
    }

    public void hipotecar(String nombrePropiedad, Cartera cartera) {
    }
}
