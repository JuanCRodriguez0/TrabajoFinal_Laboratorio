package Modelo;

import java.util.Date;

public class Proyeccion {
    private int codProyeccion;
    private int peliId;
    private int salaId;
    private String idioma;
    private boolean es3D;
    private boolean subtitulada;
    private String horaInicio;
    private String horaFin;
    private int lugaresDisponibles;
    private double precioDelLugar;
    private Boolean estado;
    private String titulo;
    private Date fechaFuncion;

    public Proyeccion() {
    }

    public Proyeccion(String idioma, boolean es3D, boolean subtitulada, String horaInicio, String horaFin, double precioDelLugar, int peliId, int salaId, Boolean estado, Date fechaFuncion) {
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.lugaresDisponibles = 15;
        this.precioDelLugar = precioDelLugar;
        this.peliId = peliId;
        this.salaId = salaId;
        this.estado = estado;
        this.fechaFuncion = fechaFuncion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public int getPeliId() {
        return peliId;
    }

    public void setPeliId(int peliId) {
        this.peliId = peliId;
    }

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(Date fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    @Override
    public String toString() {
        return "Proyeccion{" + "codProyeccion=" + codProyeccion + ", peliId=" + peliId + ", salaId=" + salaId + ", idioma=" + idioma + ", es3D=" + es3D + ", subtitulada=" + subtitulada + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", lugaresDisponibles=" + lugaresDisponibles + ", precioDelLugar=" + precioDelLugar + ", estado=" + estado + ", titulo=" + titulo + ", fechaFuncion=" + fechaFuncion + '}';
    }
}
