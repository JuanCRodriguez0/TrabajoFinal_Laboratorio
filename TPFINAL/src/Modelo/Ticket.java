package Modelo;

import java.time.LocalDate;

public class Ticket {

    private LocalDate fechaCompra;
    private LocalDate fechaFuncion;
    private double monto;
    private int dniComprador;
    private int codTicket;
    private boolean estado;

    public Ticket() {
    }

    public Ticket(LocalDate fechaCompra, LocalDate fechaFuncion, double monto, int dniComprador, boolean estado) {
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
        this.dniComprador = dniComprador;
        this.estado = estado;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDate getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(LocalDate fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getDniComprador() {
        return dniComprador;
    }

    public void setDniComprador(int dniComprador) {
        this.dniComprador = dniComprador;
    }

    public int getCodTicket() {
        return codTicket;
    }

    public void setCodTicket(int codTicket) {
        this.codTicket = codTicket;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ticket{" + "fechaCompra=" + fechaCompra + ", fechaFuncion=" + fechaFuncion + ", monto=" + monto + ", dniComprador=" + dniComprador + ", codTicket=" + codTicket + ", estado=" + estado + '}';
    }
    
    


}
