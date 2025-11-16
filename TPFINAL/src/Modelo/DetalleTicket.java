package Modelo;

import java.util.ArrayList;

public class DetalleTicket {
    private int codD;
    //private Proyeccion proyeccion;//deberia ser id de proyeccion
    private int idProyeccion;
    //private ArrayList<Asiento> asiento;
    private int cant;
    private double subtotal;
    private int idTicket;
    private int codAsiento;
    private int codAsiento2;
    //private Ticket ticket;

    public DetalleTicket(int idProyeccion, int cant, double subtotal, int idTicket, int codAsiento, int codAsiento2) {
        this.idProyeccion = idProyeccion;
        this.cant = cant;
        this.subtotal = subtotal;
        this.idTicket = idTicket;
        this.codAsiento = codAsiento;
        this.codAsiento2 = codAsiento2;
    }

    public int getCodD() {
        return codD;
    }

    public void setCodD(int codD) {
        this.codD = codD;
    }

    public int getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
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

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getCodAsiento() {
        return codAsiento;
    }

    public void setCodAsiento(int codAsiento) {
        this.codAsiento = codAsiento;
    }

    public int getCodAsiento2() {
        return codAsiento2;
    }

    public void setCodAsiento2(int codAsiento2) {
        this.codAsiento2 = codAsiento2;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" + "codD=" + codD + ", idProyeccion=" + idProyeccion + ", cant=" + cant + ", subtotal=" + subtotal + ", idTicket=" + idTicket + ", codAsiento=" + codAsiento + ", codAsiento2=" + codAsiento2 + '}';
    }
    
    

}
