package Modelo;

import java.time.LocalDate;

public class Comprador {
    private int idComprador; // SI O NO?
    private int dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String password;
    private String medioDePago;

    public Comprador() {
    }

    public Comprador(int dni, String nombre, LocalDate fechaNacimiento, String password, String medioDePago) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.medioDePago = medioDePago;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
