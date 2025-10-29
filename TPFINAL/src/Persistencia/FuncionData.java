package Persistencia;

import Modelo.Conexion;
import Modelo.Funcion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

/* @author Grupo 11 */
public class FuncionData {

    private Connection con = null;

    public FuncionData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearFuncion(Funcion funcion) {
        String sql = "INSERT INTO proyeccion(idioma, es3D, subtitulada, horaInicio, horaFin, lugaresDisponibles, precioDelLugar) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            /* dato: el Statement.RETURN_GENERATED_KEYS lo que hace es devolver el ID auto-incremental que se
                le haya asignado en la base de datos al objeto que se esté creando, por eso se usa en los métodos de crear. */

            ps.setString(1, funcion.getIdioma());
            ps.setBoolean(2, funcion.isEs3D());
            ps.setBoolean(3, funcion.isSubtitulada());
            ps.setDate(4, java.sql.Date.valueOf(funcion.getHoraInicio()));
            ps.setDate(5, java.sql.Date.valueOf(funcion.getHoraFin()));
            ps.setInt(6, funcion.getLugaresDisponibles());
            ps.setDouble(7, funcion.getPrecioDelLugar());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                // dato: por ende, el ps.getGeneratedKeys() obtiene ("gettea", deau) ese ID auto-incremental.
                if (rs.next()) {
                    funcion.setIdFuncion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Función creada con éxito (ID " + funcion.getIdFuncion() + ").");
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

    public void modificarFuncion(Funcion funcion) {
        String sql = "UPDATE proyeccion SET idioma = ?, es3D = ?, subtitulada = ?, horaInicio = ?, horaFin = ?, lugaresDisponibles = ?, precioDelLugar = ? WHERE codProyeccion = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, funcion.getIdioma());
            ps.setBoolean(2, funcion.isEs3D());
            ps.setBoolean(3, funcion.isSubtitulada());
            ps.setDate(4, java.sql.Date.valueOf(funcion.getHoraInicio()));
            ps.setDate(4, java.sql.Date.valueOf(funcion.getHoraFin()));
            ps.setInt(6, funcion.getLugaresDisponibles());
            ps.setDouble(7, funcion.getPrecioDelLugar());
            ps.setInt(8, funcion.getIdFuncion());

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
}
