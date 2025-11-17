package Modelo;

import java.util.ArrayList;

public class DetalleTicket {
    private int codD;
    private int idProyeccion;
    private double total;
    private int idTicket;
    private int codAsiento;
    private int codAsiento2;
    private Boolean estado;

    public DetalleTicket() {
    }

    public DetalleTicket(int idProyeccion,  double total, int idTicket, int codAsiento, int codAsiento2, Boolean estado) {
        this.idProyeccion = idProyeccion;
        this.total = total;
        this.idTicket = idTicket;
        this.codAsiento = codAsiento;
        this.codAsiento2 = codAsiento2;
        this.estado = estado;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
    
    public Boolean getEstado(){
        return estado;
    }
    
    public void setEstado(Boolean estado){
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" + "codD=" + codD + ", idProyeccion=" + idProyeccion + ", total=" + total + ", idTicket=" + idTicket + ", codAsiento=" + codAsiento + ", codAsiento2=" + codAsiento2 + '}';
    }

}
