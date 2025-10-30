
package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jerem
 */
public class DetalleTicketData {
    
     private Connection con = null;

    public DetalleTicketData() throws SQLException {
        con = Conexion.getConexion();
}
}
