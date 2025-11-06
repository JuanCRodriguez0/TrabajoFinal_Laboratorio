package Modelo;

import java.util.ArrayList;

public class DetalleTicket {
    private int codD;
    private Proyeccion proyeccion;
    private ArrayList<Asiento> asiento;
    private int cant;
    private double subtotal;
    private Ticket ticket;

    public DetalleTicket(int codD, Proyeccion proyeccion, ArrayList<Asiento> asiento, int cant, double subtotal, Ticket ticket) {
        this.codD = codD;
        this.proyeccion = proyeccion;
        this.asiento = asiento;
        this.cant = cant;
        this.subtotal = subtotal;
        this.ticket = ticket;
    }

    public int getCodD() {
        return codD;
    }

    public void setCodD(int codD) {
        this.codD = codD;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public ArrayList<Asiento> getAsiento() {
        return asiento;
    }

    public void setAsiento(ArrayList<Asiento> asiento) {
        this.asiento = asiento;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" + "codD=" + codD + ", proyeccion=" + proyeccion + ", asiento=" + asiento + ", cant=" + cant + ", subtotal=" + subtotal + ", ticket=" + ticket + '}';
    }
    
    
       
    
}
