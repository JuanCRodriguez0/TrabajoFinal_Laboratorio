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
import java.time.LocalDate;
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

    public void crearPelicula(Pelicula pelicula) { // esto sería "dar de alta la película"
        String sql = "INSERT INTO sala(titulo, director, actores, origen, genero, estreno, enCartelera) "
                + "VALUES (? ,? ,? ,? ,? ,? ,? ,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, Date.valueOf(pelicula.getEstreno()));
            ps.setBoolean(7, pelicula.isEnCartelera());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                pelicula.setTitulo(rs.getString(1));
                JOptionPane.showMessageDialog(null, "Pelicula creada con exito.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pelicula.");
        }

    }

    public void habilitarPelicula (int id) {
        String sql = "UPDATE pelicula SET enCartelera = 1 WHERE idPelicula = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Pelicula habilitada con exito.");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pelicula.");
        }
    }
    
    public void deshabilitarPelicula (int id) {
        String sql = "UPDATE pelicula SET enCartelera = 0 WHERE idPelicula = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(0, id);
            int n = ps.executeUpdate();
            if (n == 0) {
                JOptionPane.showMessageDialog(null, "Pelicula deshabilitada con exito.");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pelicula.");
        }
    }
    
    public Pelicula buscarPelicula (int id) {
        String sql = "SELECT titulo, director, actores, origen, genero, estreno FROM pelicula WHERE idPelicula = ? AND enCartelera = 1";
        Pelicula pelicula = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pelicula = new Pelicula();
                pelicula.setIdPelicula(id);
                pelicula.setTitulo(sql);
                pelicula.setDirector(sql);
                pelicula.setActores(sql);
                pelicula.setOrigen(sql);
                pelicula.setGenero(sql);
                pelicula.setEstreno(LocalDate.MIN);
            } else {
                JOptionPane.showMessageDialog(null, "Pelicula con idPelicula " + id + " no encontrada.");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pelicula");
        }
        
        return pelicula;
    }
    
    public void modificarPelicula (Pelicula pelicula) {
        String sql = "UPDATE pelicula SET titulo = ?, director = ?, actores = ?, origen = ?, genero = ?, estreno = ?, enCartelera = ? WHERE idPelicula = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, pelicula.getEstreno());
            ps.setBoolean(7, pelicula.setEnCartelera());
            // nos quedamos acá con el Agu', esto claramente está mal pero son las 23:15 y no nos da más el bocho xd
            
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Pelicula modificada con exito.");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pelicula.");
        }
    }
}
