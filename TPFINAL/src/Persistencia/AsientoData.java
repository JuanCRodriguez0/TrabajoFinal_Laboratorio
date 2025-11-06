package Persistencia;

import Modelo.Asiento;
import Modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Grupo 11
 */
public class AsientoData {

    private Connection con = null;

    public AsientoData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearAsiento(Asiento asiento) {

        String sql = "INSERT INTO asiento  (fila, numero, estado, codProyeccion) VALUES (?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, String.valueOf(asiento.getFila()));
            ps.setInt(2, asiento.getNumero());
            ps.setBoolean(3, asiento.isEstado());
            ps.setInt(4, asiento.getFuncion().getCodProyeccion());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    asiento.setCodAsiento(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Comprador creado con éxito (ID " + asiento.getCodAsiento() + ").");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al crear asiento: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Asiento.");
        }
    }

    public void habilitarAsiento(int id) {
        String sql = "UPDATE asiento SET estado= 1 WHERE codAsiento = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Asiento habilitado con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar habilitar asiento: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla asiento.");
        }
    }

    public void deshabilitarAsiento(int id) {
        String sql = "UPDATE asiento SET estado= 0 WHERE codAsiento = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Asiento deshabilitado con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar deshabilitar asiento: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla asiento.");
        }

    }

    public void modificarAsiento(Asiento asiento) {
        String sql = "UPDATE asiento SET fila = ? ,numero=? ,estado= ? ,codProyeccion = ? WHERE codAsiento = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(asiento.getFila()));
            ps.setInt(2, asiento.getNumero());
            ps.setBoolean(3, asiento.isEstado());
            ps.setInt(4, asiento.getFuncion().getCodProyeccion());
            ps.setInt(5, asiento.getCodAsiento());

            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Asiento modificado con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al modificar asiento: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Asiento.");
        }

    }

}
