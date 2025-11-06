/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Comprador;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.HashSet;

/**
 * @author Grupo 11
 */
public class CompradorData {

    private Connection con = null;

    public CompradorData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearComprador(Comprador comprador) {
        String sql = "INSERT INTO comprador (dni, nombre, fechaNac, password, medioDePago) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, comprador.getNombre());
            ps.setDate(2, java.sql.Date.valueOf(comprador.getFechaNacimiento()));
            ps.setString(3, comprador.getPassword());
            ps.setString(4, comprador.getMedioDePago());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    comprador.setDni(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Comprador creado con éxito (ID " + comprador.getDni() + ").");
                }

            }

        } catch (SQLException e) {
            System.err.println("Error al crear comprador: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comprador.");
        }

    }

    public Comprador buscarComprador(int id) {
        String sql = "SELECT dni, nombre, fechaNac, password, medioDePago FROM comprador WHERE dni = ?";
        Comprador comprador = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comprador = new Comprador();
                    comprador.setDni(id);
                    comprador.setNombre(rs.getNString("nombre"));
                    comprador.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    comprador.setPassword(rs.getNString("password"));
                    comprador.setMedioDePago(rs.getNString("medioDePago"));

                } else {
                    JOptionPane.showMessageDialog(null, "Comprador con dni " + id + " no encontrado.");
                }

            }

        } catch (SQLException e) {
            System.err.println("Error al buscar comprador: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comprador");
        }

        return comprador;
    }

    public void habilitarComprador(int id) {
        String sql = "UPDATE comprador SET estado= 1 WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Comprador habilitado con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar habilitar comprador: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comprador.");
        }
    }

    public void deshabilitarComprador(int id) {
        String sql = "UPDATE comprador SET estado= 0 WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Comprador deshabilitado con éxito.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar deshabilitar comprador: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comprador.");
        }
    }

}
