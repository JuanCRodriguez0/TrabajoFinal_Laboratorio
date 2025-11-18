package Persistencia;

import Modelo.Conexion;
import Modelo.DetalleTicket;
import Modelo.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleTicketData {

    private Connection con = null;

    public DetalleTicketData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void crearDetalleTicket(DetalleTicket detalleTicket) {
        String sql = "INSERT INTO detalleticket(codProyeccion, codTicket, codAsiento, codAsiento2, estado, total) VALUES (?,?,?,?,?,?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, detalleTicket.getIdProyeccion());
            ps.setInt(2, detalleTicket.getIdTicket());
            ps.setInt(3, detalleTicket.getCodAsiento());
            ps.setInt(4, detalleTicket.getCodAsiento2());
            ps.setBoolean(5, detalleTicket.getEstado());
            ps.setDouble(6, detalleTicket.getTotal());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear el Detalle de los ticktes solicitados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de los Detalle de Ticket.");
        }
    }

    public void crearDetalleTicketP1(DetalleTicket detalleTicket) {
        String sql = "INSERT INTO detalleticket(codProyeccion, codTicket, codAsiento, estado, total) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, detalleTicket.getIdProyeccion());
            ps.setInt(2, detalleTicket.getIdTicket());
            ps.setInt(3, detalleTicket.getCodAsiento());
            ps.setBoolean(4, detalleTicket.getEstado());
            ps.setDouble(5, detalleTicket.getTotal());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear el Detalle de los ticktes solicitados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de los Detalle de Ticket.");
        }

    }


    public List<DetalleTicket> listarTickets() {
        List<DetalleTicket> listaTickets = new ArrayList();

        String sql = "SELECT codD, codProyeccion, total, codTicket, codAsiento, codAsiento2  FROM detalleticket WHERE estado = 1";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetalleTicket dt = new DetalleTicket();
                dt.setCodD(rs.getInt("codD"));
                dt.setIdProyeccion(rs.getInt("codProyeccion"));
                dt.setTotal(rs.getDouble("total"));
                dt.setIdTicket(rs.getInt("codTicket"));
                dt.setEstado(true);
                listaTickets.add(dt);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar tickets: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar tickets: " + e.getMessage());
        }

        return listaTickets;
    }

    public Ticket conseguirTicket(int idTicket) {
        String sql = "SELECT ticketcompra.dni, ticketcompra.fechaCompra FROM ticketcompra JOIN detalleticket ON ticketcompra.codTicket = detalleticket.codTicket WHERE detalleticket.codTicket = ?";
        Ticket tic = new Ticket();

        try (PreparedStatement ps = con.prepareStatement(sql) ) {
            ps.setInt(1, idTicket);
            try (ResultSet rs = ps.executeQuery() ){
                while (rs.next()) {
                    tic.setDniComprador(rs.getInt("ticketcompra.dni"));
                    tic.setFechaCompra(rs.getDate("ticketcompra.fechaCompra"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al listar Proyecciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proyecciones: " + e.getMessage());
        }
        return tic;
    }
    
    public void deshabilitarDetalleTicket(int id){
        String sql = "UPDATE detalleticket SET estado = 0 WHERE codD = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Detalle Ticket deshabilitado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el DetalleTicket con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error al deshabilitar DetalleTicket: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DetalleTicket.");
        }
    }
}
