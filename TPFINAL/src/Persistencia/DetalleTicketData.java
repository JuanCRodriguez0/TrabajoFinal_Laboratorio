package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class DetalleTicketData {

    private Connection con = null;

    public DetalleTicketData() throws SQLException {
        con = Conexion.getConexion();
    }
    
    
}
