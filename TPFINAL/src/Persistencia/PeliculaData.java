/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author 
 */
public class PeliculaData {
    
    private Connection con = null;

    public PeliculaData() throws SQLException {
        con = Conexion.getConexion();
    }
    
    public void crearPelicula(Pelicula pelicula) {
        String sql = "INSERT INTO sala(titulo, director, actores, origen, genero, estreno, enCartelera) "
                + "VALUES (? ,? ,? ,? ,? ,? ,? ,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, pelicula.getEstreno()); //No me acuerdo como iba en caso de Date
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
    
    
}
