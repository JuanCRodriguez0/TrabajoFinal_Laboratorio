
package Persistencia;

import Modelo.Conexion;
import Modelo.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author jerem
 */
public class TicketData {
    
    
     private Connection con = null;

    public TicketData() throws SQLException {
        con = Conexion.getConexion();
}
    
    public void crearTicket (Ticket ticket){
        String sql = "INSERT INTO ticketcompra(fechaCompra, fechaFuncion, monto, dni, codTicket) VALUES ?,?,?,?,?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, java.sql.Date.valueOf(ticket.getFechaCompra()));
            ps.setDate(2, java.sql.Date.valueOf(ticket.getFechaFuncion()));
            ps.setDouble(3, ticket.getMonto());
            ps.setInt(4, ticket.getComprador().getDni());
            ps.setInt(5, ticket.getCodTicket());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    ticket.setCodTicket(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Ticket creado con éxito (ID " + ticket.getCodTicket()+ ").");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al crear ticket: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ticket.");
        }
        
    }
    
    public Ticket buscarTicket (int id){
         
    
            String sql = "SELECT fechaCompra, fechaFuncion, monto, dni FROM ticketcompra WHERE codTicket = ?";
            Ticket ticket = null;
            
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    ticket = new Ticket();
                    ticket.setCodTicket(id);
                    ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                    ticket.setFechaFuncion(rs.getDate("fechaFuncion").toLocalDate());
                    ticket.setMonto(rs.getDouble("monto"));
                    ticket.getComprador().setDni(Integer.parseInt("dni"));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Ticket con ID " + id + " no encontrada.");
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error al acceder al ticket: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ticket.");
        }
            
            
            
            return ticket;
            
            
            
            
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
