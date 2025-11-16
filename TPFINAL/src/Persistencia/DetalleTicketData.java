package Persistencia;

import Modelo.Conexion;
import Modelo.DetalleTicket;
import Modelo.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DetalleTicketData {

    private Connection con = null;

    public DetalleTicketData() throws SQLException {
        con = Conexion.getConexion();
    }
    
    public void crearDetalleTicket(DetalleTicket detalleTicket) {
        String sql = "INSERT INTO `detalleticket`(`codProyeccion`, `cant`, `subtotal`, `codTicket`, `codAsiento`, `codAsiento2`) VALUES ( ?, ? , ? ,? , ? , ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

    
            ps.setInt(1, detalleTicket.getIdProyeccion());
            ps.setInt(2, detalleTicket.getCant());
            ps.setDouble(3, detalleTicket.getSubtotal());
            ps.setInt(4, detalleTicket.getIdTicket());
            ps.setInt(5, detalleTicket.getCodAsiento());
            ps.setInt(6, detalleTicket.getCodAsiento2());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    detalleTicket.setCodD(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Detalle del ticket creado con éxito (ID " + detalleTicket.getCodD() + ").");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al crear el Detalle de los ticktes solicitados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de los Detalle de Ticket.");
        }

    }
    /*
    public Ticket mostrarTicket(int id) {

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
    
    */
    
    
}
