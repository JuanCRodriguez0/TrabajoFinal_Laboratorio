package Modelo;

public class Asiento {
    private int codAsiento;
    private char fila;
    private int numero; 
    private boolean estado;
    private Funcion funcion;

    public Asiento() {
    }

    public Asiento(int codAsiento, char fila, int numero, boolean estado, Funcion funcion) {
        this.codAsiento = codAsiento;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
        this.funcion = funcion;
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

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "Asiento{" + "codAsiento=" + codAsiento + ", fila=" + fila + ", numero=" + numero + ", estado=" + estado + ", funcion=" + funcion + '}';
    }
    
    
}
