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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Grupo 11
 */
public class CompradorData {

    private Connection con = null;

    public CompradorData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearComprador(Comprador comprador) {
        java.sql.Date fechaSQL = new java.sql.Date(comprador.getFechaNacimiento().getTime());
        String sql = "INSERT INTO comprador (dni, nombre, fechaNac, password, medioDePago, estado) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, comprador.getDni());
            ps.setString(2, comprador.getNombre());
            ps.setDate(3, fechaSQL);
            ps.setString(4, comprador.getPassword());
            ps.setString(5, comprador.getMedioDePago());
            ps.setBoolean(6, comprador.getEstado());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comprador creado con éxito.");

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
                    comprador.setFechaNacimiento(rs.getDate("fechaNac"));
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

    public Boolean buscarCompradorInicioSesion(int id, String contra){
        String sql = "SELECT dni, password FROM comprador WHERE dni = ? AND password = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, contra);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            System.err.println("Error al buscar comprador: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comprador");
        }
        return false;
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

    public void modificarComprador(Boolean estado, String nombre, int dni) {
        String sql = "UPDATE comprador SET estado = ? , nombre = ? WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1, estado);
            ps.setString(2, nombre);
            ps.setInt(3, dni);
            
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Comprador modificado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró comprador a modificar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar comprador: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comprador.");
        }

    }

    public List<Comprador> listarCompradores() {
        List<Comprador> compradores = new ArrayList<>();
        String sql = "SELECT dni, nombre, fechaNac, password, medioDePago, estado FROM comprador";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comprador usuario = new Comprador();
                usuario.setDni(rs.getInt("dni"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setFechaNacimiento(rs.getDate("fechaNac"));
                usuario.setPassword(rs.getString("password"));
                usuario.setMedioDePago(rs.getString("medioDePago"));
                usuario.setEstado(rs.getBoolean("estado"));
                compradores.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar compradores: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar compradores: " + e.getMessage());
        }

        return compradores;
    }
}
