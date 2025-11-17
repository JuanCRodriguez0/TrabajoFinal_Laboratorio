package Persistencia;

import Modelo.Conexion;
import Modelo.Ticket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TicketData {

    private Connection con = null;

    public TicketData() throws SQLException {
        con = Conexion.getConexion();
    }

    public int crearTicket(Ticket ticket) {
        String sql = "INSERT INTO ticketcompra(fechaCompra, codProyeccion, monto, dni, codTicket,estado) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

    
        ps.setDate(1, ticket.getFechaCompra());
            ps.setInt(2, ticket.getCodProyeccion());
            ps.setDouble(3, ticket.getMonto());
            ps.setInt(4, ticket.getDniComprador());
            ps.setInt(5, ticket.getCodTicket());
            ps.setBoolean(6, true);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    ticket.setCodTicket(rs.getInt(1));
                    return ticket.getCodProyeccion();
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al crear ticket: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ticket.");
        }
        return -1;
    }

    public Ticket mostrarTicket(int id) {

        String sql = "SELECT fechaCompra, codProyeccion, monto, dni FROM ticketcompra WHERE codTicket = ?";
        Ticket ticket = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    ticket = new Ticket();
                    ticket.setCodTicket(id);
                    ticket.setFechaCompra(rs.getDate("fechaCompra"));
                    ticket.setCodProyeccion(rs.getInt("codProyeccion"));
                    ticket.setMonto(rs.getDouble("monto"));
                    ticket.setDniComprador(Integer.parseInt("dni"));

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
    
    public List<Ticket> listarCartelera(){
        List<Ticket> listaTickets = new ArrayList();
        
        String sql = "SELECT codTicket, dni, fechaCompra, monto FROM ticketcompra WHERE estado = 1";
        
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ticket tick = new Ticket();
                tick.setCodTicket(rs.getInt("codTicket"));
                tick.setDniComprador(rs.getInt("dni"));
                tick.setFechaCompra(rs.getDate("fechaCompra"));
                tick.setMonto(rs.getDouble("monto"));
                tick.setEstado(true);
                listaTickets.add(tick);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar tickets: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar tickets: " + e.getMessage());
        }
        
        return listaTickets;
    }
    
}
