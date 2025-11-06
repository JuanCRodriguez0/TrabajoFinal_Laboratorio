package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Grupo 11
 */
public class DetalleTicketData {

    private Connection con = null;

    public DetalleTicketData() throws SQLException {
        con = Conexion.getConexion();
    }
}
