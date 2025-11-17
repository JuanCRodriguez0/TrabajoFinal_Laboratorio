package Modelo;

import java.sql.Date;

public class Ticket {

    private Date fechaCompra;
    private int codProyeccion;
    private double monto;
    private int dniComprador;
    private int codTicket;
    private boolean estado;

    public Ticket() {
    }

    public Ticket(Date fechaCompra, int codProyeccion, double monto, int dniComprador, boolean estado) {
        this.fechaCompra = fechaCompra;
        this.codProyeccion = codProyeccion;
        this.monto = monto;
        this.dniComprador = dniComprador;
        this.estado = estado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCodProyeccion() {
        return codProyeccion;
    }

    public void setCodProyeccion(int codProyeccion) {
        this.codProyeccion = codProyeccion;
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

   
    
    


}
