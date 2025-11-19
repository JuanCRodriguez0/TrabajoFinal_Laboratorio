package Persistencia;

import Modelo.Conexion;
import Modelo.Proyeccion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProyeccionData {

    private Connection con = null;

    public ProyeccionData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearFuncion(Proyeccion funcion) {
        java.sql.Date fechaSQL = new java.sql.Date(funcion.getFechaFuncion().getTime());
        
        String sql = "INSERT INTO proyeccion(idioma, es3D, subtitulada, horaInicio, horaFin, lugaresDisponibles, precioDelLugar, nroSala, idPelicula,estado, fechaFuncion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, funcion.getIdioma());
            ps.setBoolean(2, funcion.isEs3D());
            ps.setBoolean(3, funcion.isSubtitulada());
            ps.setString(4, funcion.getHoraInicio());
            ps.setString(5, funcion.getHoraFin());
            ps.setInt(6, funcion.getLugaresDisponibles());
            ps.setDouble(7, funcion.getPrecioDelLugar());
            ps.setInt(8, funcion.getSalaId());
            ps.setInt(9, funcion.getPeliId());
            ps.setBoolean(10, true);
            ps.setDate(11, fechaSQL);
            

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    funcion.setCodProyeccion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Función creada con éxito (ID " + funcion.getCodProyeccion() + ").");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al crear funcion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Función.");
        }
    }

    public void deshabilitarFuncion(int id) {
        String sql = "UPDATE proyeccion SET estado = 0 WHERE codProyeccion = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int eU = ps.executeUpdate();

            if (eU > 0) {
                JOptionPane.showMessageDialog(null, "Función deshabilitada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró función para eliminar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al borrar funcion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Función.");
        }
    }

    public void modificarFuncion(String idioma, Boolean es3D, Boolean subtitulada, Double precio, int codProyeccion) {
        String sql = "UPDATE proyeccion SET idioma = ?, es3D = ?, subtitulada = ?, precioDelLugar = ? WHERE codProyeccion = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idioma);
            ps.setBoolean(2, es3D);
            ps.setBoolean(3, subtitulada);
            ps.setDouble(4, precio);
            ps.setInt(5, codProyeccion);

            int eU = ps.executeUpdate();

            if (eU > 0) {
                JOptionPane.showMessageDialog(null, "Función modificada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la función a modificar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar funcion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Función.");
        }
    }

    public List<Proyeccion> listarProyecciones() {
        List<Proyeccion> proys = new ArrayList<>();

        String sql = "SELECT idioma, es3D, subtitulada, horaInicio, horaFin, lugaresDisponibles, precioDelLugar, codProyeccion, estado, fechaFuncion FROM proyeccion";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proyeccion proy = new Proyeccion();
                proy.setIdioma(rs.getString("idioma"));
                proy.setEs3D(rs.getBoolean("es3D"));
                proy.setSubtitulada(rs.getBoolean("subtitulada"));
                proy.setHoraInicio(rs.getString("horaInicio"));
                proy.setHoraFin(rs.getString("horaFin"));
                proy.setLugaresDisponibles(rs.getInt("lugaresDisponibles"));
                proy.setPrecioDelLugar(rs.getDouble("precioDelLugar"));
                proy.setCodProyeccion(rs.getInt("codProyeccion"));
                proy.setEstado(rs.getBoolean("estado"));
                proy.setFechaFuncion(rs.getDate("fechaFuncion"));
                proys.add(proy);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Proyecciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proyecciones: " + e.getMessage());
        }
        return proys;
    }
    

    public List<Proyeccion> listarCartelera() {
        List<Proyeccion> cartelera = new ArrayList<>();

        String sql = "SELECT es3D, horaFin, horaInicio, subtitulada, estado, titulo, codProyeccion, idioma, lugaresDisponibles, precioDelLugar, fechaFuncion FROM proyeccion JOIN pelicula ON proyeccion.idPelicula = pelicula.idPelicula AND estado = 1";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proyeccion proye = new Proyeccion();
                proye.setEs3D(rs.getBoolean("es3D"));
                proye.setSubtitulada(rs.getBoolean("subtitulada"));
                proye.setHoraInicio(rs.getString("horaInicio"));
                proye.setHoraFin(rs.getString("horaFin"));
                proye.setLugaresDisponibles(rs.getInt("lugaresDisponibles"));
                proye.setPrecioDelLugar(rs.getDouble("precioDelLugar"));
                proye.setCodProyeccion(rs.getInt("codProyeccion"));
                proye.setEstado(rs.getBoolean("estado"));
                proye.setTitulo(rs.getString("titulo"));
                proye.setIdioma(rs.getString("idioma"));
                proye.setFechaFuncion(rs.getDate("fechaFuncion"));
                cartelera.add(proye);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Proyecciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proyecciones: " + e.getMessage());
        }
        return cartelera;
    }

    public List<Proyeccion> modificarLugaresDisponibles() {
        List<Proyeccion> lugaresOcupados = new ArrayList();
        String sql = "SELECT COUNT(asiento.codAsiento) lugaresDisp, proyeccion.codProyeccion FROM proyeccion JOIN asiento ON proyeccion.codProyeccion = asiento.codProyeccion WHERE asiento.estado = 0 GROUP BY proyeccion.codProyeccion";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proyeccion p = new Proyeccion();
                p.setCodProyeccion(rs.getInt("proyeccion.codProyeccion"));
                p.setLugaresDisponibles(rs.getInt("lugaresDisp"));
                lugaresOcupados.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar Proyecciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proyecciones: " + e.getMessage());
        }

        return lugaresOcupados;
    }

    public Proyeccion getTitulo(int id) {
        Proyeccion a = new Proyeccion();

        String sql = "SELECT pelicula.titulo, proyeccion.fechaFuncion FROM pelicula JOIN proyeccion ON pelicula.idPelicula = proyeccion.idPelicula WHERE proyeccion.codProyeccion = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    a.setTitulo(rs.getString("pelicula.titulo"));
                    a.setFechaFuncion(rs.getDate("proyeccion.fechaFuncion"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al listar Proyecciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proyecciones: " + e.getMessage());
        }

        return a;
    }
}
