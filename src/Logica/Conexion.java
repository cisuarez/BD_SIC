package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public Conexion() {
        
    }

    public Connection Conectar(){
        Connection link = null;
        
        try{
            
            //sistema_informacion_cultural
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection("jdbc:mysql://localhost/sistema_informacion_cultural?user=root&password=1234&useSSL=false");                      
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;
    }
    
}
