package src.main.java.org.fiuba.algo3.view;

public enum Colores {
    RESET("\u001B[0m"),
    ROJO("\u001B[31m"),
    AZUL("\u001B[34m"),
    AMARILLO("\u001B[33m"),
    VERDE("\u001B[32m");

    private final String codigoANSI;

    Colores(String codigoANSI) {
        this.codigoANSI = codigoANSI;
    }

    public String aplicar(String texto) {
        return codigoANSI + texto + RESET.codigoANSI;
    }
}

