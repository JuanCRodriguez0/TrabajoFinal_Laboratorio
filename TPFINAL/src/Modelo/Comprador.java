package Modelo;

import java.util.Date;



public class Comprador {
    private int dni;
    private String nombre;
    private Date fechaNacimiento;
    private String password;
    private String medioDePago;
    private Boolean estado;

    public Comprador() {
    }

    public Comprador(int dni, String nombre, Date fechaNacimiento, String password, String medioDePago, Boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.medioDePago = medioDePago;
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    @Override
    public String toString() {
        return "Comprador{" + "dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", password=" + password + ", medioDePago=" + medioDePago + '}';
    }
    
    
}
