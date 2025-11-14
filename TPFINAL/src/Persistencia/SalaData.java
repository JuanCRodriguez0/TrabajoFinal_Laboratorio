package Persistencia;

import Modelo.Conexion;
import Modelo.Sala;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
                JOptionPane.showMessageDialog(null, "Sala habilitada con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar habilitar sala: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }
    }

    public void deshabilitarSala(int id) {
        String sql = "UPDATE sala SET estado = 0 WHERE nroSala = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Sala deshabilitada con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar deshabilitar sala: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

    }

    public void modificarSala(Sala sala) {
        String sql = "UPDATE sala SET apta3D = ? , estado = ? WHERE nroSala = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1, sala.isApta3D());
            ps.setBoolean(2, sala.isEstado());
            ps.setInt(3, sala.getNroSala());

            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Sala modificada con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al modificar sala: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

    }

    public void crearSala(Sala sala) {
        String sql = "INSERT INTO sala(apta3D, capacidad, estado) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setBoolean(1, sala.isApta3D());
            ps.setInt(2, sala.getCapacidad());
            ps.setBoolean(3, sala.isEstado());
            
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    sala.setNroSala(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Sala creada con éxito (ID " + sala.getNroSala() + ").");
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error al crear sala: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

    }

    public Sala buscarSala(int id) {
        String sql = "SELECT apta3D, capacidad FROM sala WHERE nroSala = ? AND estado = 1";
        Sala sala = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    sala = new Sala();
                    sala.setNroSala(id);
                    sala.setApta3D(rs.getBoolean("apta3D"));
                    sala.setCapacidad(rs.getInt("capacidad"));
                    sala.setEstado(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Sala con ID " + id + " no encontrada.");
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error al acceder a la sala: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Sala.");
        }

        return sala;
    }

    public List<Sala> listarSalas() {
        List<Sala> salas = new ArrayList<>();

        String sql = "SELECT nroSala, apta3D, capacidad, estado FROM sala";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sala sala = new Sala();
                sala.setNroSala(rs.getInt("nroSala"));
                sala.setApta3D(rs.getBoolean("apta3D"));
                sala.setCapacidad(rs.getInt("capacidad"));
                sala.setEstado(rs.getBoolean("estado"));
                salas.add(sala);
            }

        } catch (SQLException ex) {
            System.err.println("Error al listar las salas: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar las salas.");
        }

        return salas;
    }
}
