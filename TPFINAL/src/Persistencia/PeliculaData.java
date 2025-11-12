package Persistencia;

import Modelo.Conexion;
import Modelo.Pelicula;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Grupo 11
 */
public class PeliculaData {

    private Connection con = null;

    public PeliculaData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearPelicula(Pelicula pelicula) {
        java.sql.Date fechaSQL = new java.sql.Date(pelicula.getEstreno().getTime());
        String sql = "INSERT INTO pelicula(titulo, director, actores, origen, genero, estreno, enCartelera) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, fechaSQL);
            ps.setBoolean(7, pelicula.isEnCartelera());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pelicula.setIdPelicula(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Película creada con éxito (ID " + pelicula.getIdPelicula() + ").");
            }

        } catch (SQLException ex) {
            System.err.println("Error al crear pelicula: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Película.");
        }

    }

    public void habilitarPelicula(int id) {
        String sql = "UPDATE pelicula SET enCartelera = 1 WHERE idPelicula = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Película habilitada con éxito.");
            }

        } catch (SQLException e) {
            System.err.println("Error al habilitar pelicula: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Película.");
        }
    }

    public void deshabilitarPelicula(int id) {
        String sql = "UPDATE pelicula SET enCartelera = 0 WHERE idPelicula = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(0, id);
            int n = ps.executeUpdate();
            if (n == 0) {
                JOptionPane.showMessageDialog(null, "Película deshabilitada con éxito.");
            }

        } catch (SQLException e) {
            System.err.println("Error al deshabilitar pelicula: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Película.");
        }
    }

    public Pelicula buscarPelicula(int id) {
        String sql = "SELECT titulo, director, actores, origen, genero, estreno FROM pelicula WHERE idPelicula = ?";
        Pelicula pelicula = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pelicula = new Pelicula();
                    pelicula.setIdPelicula(id);
                    pelicula.setTitulo(rs.getNString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setActores(rs.getString("actores"));
                    pelicula.setOrigen(rs.getString("origen"));
                    pelicula.setGenero(rs.getString("genero"));
                    pelicula.setEstreno(rs.getDate("estreno"));
                } else {
                    JOptionPane.showMessageDialog(null, "Película con ID " + id + " no encontrada.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar pelicula: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Película");
        }

        return pelicula;
    }

    public void modificarPelicula(Pelicula pelicula) {
        java.sql.Date fechaSQL = new java.sql.Date(pelicula.getEstreno().getTime());
        String sql = "UPDATE pelicula SET titulo = ?, director = ?, actores = ?, origen = ?, genero = ?, estreno = ?, enCartelera = ? WHERE idPelicula = ? ";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, fechaSQL);
            ps.setBoolean(7, pelicula.isEnCartelera());
            ps.setInt(8, pelicula.getIdPelicula());

            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Película modificada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró película a modificar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar pelicula: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Película.");
        }
    }

    public List<Pelicula> listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();

        String sql = "SELECT titulo, director, actores, genero, estreno, enCartelera "
                + "FROM pelicula";
        // + "WHERE idPelicula = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pelicula p1 = new Pelicula();
                rs.getString("titulo");
                rs.getString("director");
                rs.getString("actores");
                rs.getString("genero");
                rs.getDate("estreno");
                rs.getBoolean("enCartelera");
                peliculas.add(p1);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar peliculas: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar películas: " + e.getMessage());
        }

        return peliculas;
    }
}
