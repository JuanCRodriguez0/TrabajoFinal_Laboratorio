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
import java.util.HashSet;
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
        String sql = "INSERT INTO pelicula(titulo, director, actores, origen, genero, estreno, enCartelera) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, Date.valueOf(pelicula.getEstreno()));
            ps.setBoolean(7, pelicula.isEnCartelera());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    pelicula.setIdPelicula(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Película creada con éxito (ID " + pelicula.getIdPelicula() + ").");
                }
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
        String sql = "SELECT titulo, director, actores, origen, genero, estreno FROM pelicula WHERE idPelicula = ? AND enCartelera = 1";
        Pelicula pelicula = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pelicula = new Pelicula();
                    pelicula.setIdPelicula(id); // corregí de acá para abajo que lo habíamos dejado así nomás con el Agu' xd
                    pelicula.setTitulo(rs.getNString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setActores(rs.getString("actores"));
                    pelicula.setOrigen(rs.getString("origen"));
                    pelicula.setGenero(rs.getString("genero"));
                    pelicula.setEstreno(rs.getDate("estreno").toLocalDate());
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
        String sql = "UPDATE pelicula SET titulo = ?, director = ?, actores = ?, origen = ?, genero = ?, estreno = ?, enCartelera = ? WHERE idPelicula = ? ";

        /* esto del try con paréntesis se llama "try-with-resources", es algo que se agregó en Java 7 y sirve para que objetos que "saben 
            autocerrarse" (objetos que implementan la interfaz "AutoClosable", tales como Connection, PreparedStatement y ResultSet, entre otros) 
            al estar metidos dentro de los paréntesis del try hace que cuando se salgan de este, ya sea porque se ejecutan correctamente o
            porque salta el catch, se cierren automáticamente. Esto antes había que hacerlo "a mano" en un bloque finally que había que agregar 
            siempre y que era una paja y acá Java lo agrega por vos si utilizas este método. El problema de dejar objetos sin cerrarse es que si
            nuestro sistema fuese usado por muchos usuarios quedarían muchas o todas las consultas abiertas y eso haría que se desperdicien 
            recursos (de memoria de la base de datos supongo xd) y que eventualmente la base de datos o la app/programa se quede sin conexiones 
            disponibles, dejando de funcionar. Perdón por la explicación larguísima pero el que la quiera leer que lo haga y el que no, no. xd 
         */
        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, java.sql.Date.valueOf(pelicula.getEstreno())); // corregido esto
            ps.setBoolean(7, pelicula.isEnCartelera()); // y esto
            ps.setInt(8, pelicula.getIdPelicula()); // y agregado esto que faltaba y no nos dimos cuenta xd

            int n = ps.executeUpdate();
            if (n > 0) { // supuestamente es mejor checkear si n > 0 por si actualiza más de una fila por error (no me pregunten cómo lo sé (?)
                JOptionPane.showMessageDialog(null, "Película modificada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró película a modificar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar pelicula: " + e.getMessage()); // mostrar el error en consola nos ayuda a la hora de debuggear
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Película.");
        }
    }
}
