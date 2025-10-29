package Persistencia;

import Modelo.Conexion;
import Modelo.Sala;
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

/**
 * @author Grupo 11
 */
public class SalaData {

    private Connection con = null;

    public SalaData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void habilitarSala(int id) {
        String sql = "UPDATE sala SET estado = 1 WHERE nroSala = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Sala habilitada con exito.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sala.");
        }
    }

    public void deshabilitarSala(int id) {
        String sql = "UPDATE sala SET estado = 0 WHERE nroSala = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Sala Deshabilitada con exito.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

    }

    public void modificarSala(Sala sala) {
        String sql = "UPDATE sala SET apta3D = ? ,capacidad = ? , estado = ? WHERE nroSala = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1, sala.isApta3D());
            ps.setInt(2, sala.getCapacidad());
            ps.setBoolean(3, sala.isEstado());
            ps.setInt(4, sala.getNroSala());

            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Sala modificada con exito.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

    }

    public void crearSala(Sala sala) {
        String sql = "INSERT INTO sala(nroSala, apta3D, capacidad, estado) VALUES (? ,? ,?,? )";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, sala.getNroSala());
            ps.setBoolean(2, sala.isApta3D());
            ps.setInt(3, sala.getCapacidad());
            ps.setBoolean(4, sala.isEstado());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    sala.setNroSala(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Sala creada con exito.");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla sala.");
        }

    }

    public Sala buscarSala(int id) {
        String sql = "SELECT apta3D, capacidad FROM sala WHERE nroSala = ? AND estado = 1";
        Sala sala = null;

        try (PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    sala = new Sala();
                    sala.setNroSala(id);
                    sala.setApta3D(rs.getBoolean("apta3D"));
                    sala.setCapacidad(rs.getInt("capacidad"));
                    sala.setEstado(true);

                } else {
                    JOptionPane.showMessageDialog(null, "sala con nroSala " + id + " no encontrado.");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

        return sala;
    }
}
