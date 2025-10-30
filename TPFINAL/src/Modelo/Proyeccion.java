package Modelo;

import java.time.LocalDate;

public class Proyeccion {
    private int codProyeccion;
    private Pelicula pelicula;
    private Sala sala;
    private String idioma;
    private boolean es3D;
    private boolean subtitulada;
    private LocalDate horaInicio;
    private LocalDate horaFin;
    private int lugaresDisponibles;
    private double precioDelLugar;

    public Proyeccion() {
    }

    public Proyeccion(String idioma, boolean es3D, boolean subtitulada, LocalDate horaInicio, LocalDate horaFin, int lugaresDisponibles, double precioDelLugar) {
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.lugaresDisponibles = lugaresDisponibles;
        this.precioDelLugar = precioDelLugar;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getCodProyeccion() {
        return codProyeccion;
    }

    public void setCodProyeccion(int codProyeccion) {
        this.codProyeccion = codProyeccion;
    }

   

    

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEs3D() {
        return es3D;
    }

    public void setEs3D(boolean es3D) {
        this.es3D = es3D;
    }

    public boolean isSubtitulada() {
        return subtitulada;
    }

    public void setSubtitulada(boolean subtitulada) {
        this.subtitulada = subtitulada;
    }

    public LocalDate getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDate horaFin) {
        this.horaFin = horaFin;
    }

    public int getLugaresDisponibles() {
        return lugaresDisponibles;
    }

    public void setLugaresDisponibles(int lugaresDisponibles) {
        this.lugaresDisponibles = lugaresDisponibles;
    }

    public double getPrecioDelLugar() {
        return precioDelLugar;
    }

    public void setPrecioDelLugar(double precioDelLugar) {
        this.precioDelLugar = precioDelLugar;
    }

    @Override
    public String toString() {
        return "Proyeccion{" + "codProyeccion=" + codProyeccion + ", pelicula=" + pelicula + ", sala=" + sala + ", idioma=" + idioma + ", es3D=" + es3D + ", subtitulada=" + subtitulada + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", lugaresDisponibles=" + lugaresDisponibles + ", precioDelLugar=" + precioDelLugar + '}';
    }

   

    
    
    
}
