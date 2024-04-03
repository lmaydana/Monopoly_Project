package Casilleros;

public interface Receptor<T extends Comprable> {
    void recibir(T comprable);
}
