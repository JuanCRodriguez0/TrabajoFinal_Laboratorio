package Persistencia;

import Modelo.Conexion;
import Modelo.Pelicula;
import Modelo.Proyeccion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Grupo 11
 */
public class ProyeccionData {

    private Connection con = null;

    public ProyeccionData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearFuncion(Proyeccion funcion) {
        java.sql.Date fechaSQL = new java.sql.Date(funcion.getHoraInicio().getTime());
        java.sql.Date fechaSQL2 = new java.sql.Date(funcion.getHoraFin().getTime());

        String sql = "INSERT INTO proyeccion(idioma, es3D, subtitulada, horaInicio, horaFin, lugaresDisponibles, precioDelLugar, nroSala, idPelicula) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, funcion.getIdioma());
            ps.setBoolean(2, funcion.isEs3D());
            ps.setBoolean(3, funcion.isSubtitulada());
            ps.setDate(4, fechaSQL);
            ps.setDate(5, fechaSQL2);
            ps.setInt(6, funcion.getLugaresDisponibles());
            ps.setDouble(7, funcion.getPrecioDelLugar());
            ps.setInt(8, funcion.getPelicula().getIdPelicula());
            ps.setInt(9, funcion.getSala().getNroSala());

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

    public void eliminarFuncion(int id) {
        String sql = "DELETE FROM proyeccion WHERE codProyeccion = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int eU = ps.executeUpdate();

            if (eU > 0) {
                JOptionPane.showMessageDialog(null, "Función eliminada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró función para eliminar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al borrar funcion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Función.");
        }
    }

    public void modificarFuncion(Proyeccion funcion) {
        String sql = "UPDATE proyeccion SET idioma = ?, es3D = ?, subtitulada = ?, precioDelLugar = ? WHERE codProyeccion = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, funcion.getIdioma());
            ps.setBoolean(2, funcion.isEs3D());
            ps.setBoolean(3, funcion.isSubtitulada());
            /*ps.setDate(4, java.sql.Date.valueOf(funcion.getHoraInicio()));
            ps.setDate(4, java.sql.Date.valueOf(funcion.getHoraFin()));
            ps.setInt(4, funcion.getLugaresDisponibles());*/
            ps.setDouble(4, funcion.getPrecioDelLugar());
            ps.setInt(5, funcion.getCodProyeccion());

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

        String sql = "SELECT idioma, es3D, subtitulada, horaInicio, horaFin, lugaresDisponibles, precioDelLugar FROM proyeccion";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proyeccion proy = new Proyeccion();
                proy.setIdioma(rs.getString("idioma"));
                proy.setEs3D(rs.getBoolean("es3D"));
                proy.setSubtitulada(rs.getBoolean("subtitulada"));
                proy.setHoraInicio(rs.getDate("horaInicio"));
                proy.setHoraFin(rs.getDate("horaFin"));
                proy.setLugaresDisponibles(rs.getInt("lugaresDisponibles"));
                proy.setPrecioDelLugar(rs.getDouble("precioDelLugar"));
                proys.add(proy);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Proyecciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proyecciones: " + e.getMessage());
        }
        return proys;
    }
}
