package Vista;

import Modelo.Sala;
import Persistencia.SalaData;
import java.sql.SQLException;

/**
 *
 * Grupo 11:
 * 
 * Mauricio Reta
 * Agustin Mazza
 * Juan Cruz ROdriguez
 * Jeremias Hoyo
 * Facundo Cozzela
 * Jeremias Sirur Flores
 */
public class TPFINAL {

    public static void main(String[] args) throws SQLException {
        // int nroSala, boolean apta3D, int capacidad, boolean estado
        Sala s1 = new Sala (1, true , 170, true );
        Sala s2 = new Sala (2, false, 230, true);
        Sala s3 = new Sala (3, true, 30, false);
        
        SalaData SD = new SalaData(); 
        
        /*
        SD.crearSala(s1);
        SD.crearSala(s2);
        SD.crearSala(s3); */
        
        /* FUNCIONA */
        SD.deshabilitarSala(3);
        System.out.println("Se deshabilito la sala"); 
       
        SD.habilitarSala(3);
        System.out.println("Se habilito"); 
        
        
      Sala salita = SD.buscarSala(3);
   
        System.out.println(salita.toString()); 
        
        
       Sala modificarSala1 = new Sala(1, true, 120, true); 
       SD.modificarSala(modificarSala1); 
      
    }
    
}
