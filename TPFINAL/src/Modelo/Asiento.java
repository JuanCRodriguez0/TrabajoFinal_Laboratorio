package Modelo;

public class Asiento {
    private int codAsiento;
    private char fila;
    private int numero; 
    private boolean estado;
    private int codProyeccion;

    public Asiento() {
    }

    public Asiento(int codAsiento, char fila, int numero, boolean estado) {
        this.codAsiento = codAsiento;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }

    public int getCodAsiento() {
        return codAsiento;
    }

    public void setCodAsiento(int codAsiento) {
        this.codAsiento = codAsiento;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCodProyeccion() {
        return codProyeccion;
    }

    public void setCodProyeccion(int codProyeccion) {
        this.codProyeccion = codProyeccion;
    }

    public Asiento(int codAsiento, char fila, int numero, boolean estado, int codProyeccion) {
        this.codAsiento = codAsiento;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
        this.codProyeccion = codProyeccion;
    }
    
}
