package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fInteresesCulturales {
    
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    
    
    public int total_registros;
    
   
      public DefaultTableModel mostrarNombreIC(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Intereses Culturales"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL =  "SELECT nombre_interes_cultural "+
                "FROM intereses_culturales WHERE id_municipio = '" + buscar + "';";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("nombre_interes_cultural");
            
           
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
      
      
      
       
    public ArrayList<String> llenar_cob(){
        ArrayList<String> lista = new ArrayList<String>();
        
        sSQL = "SELECT nombre_interes_cultural FROM intereses_culturales";

        try {

             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL);
           
             
            
        } catch (Exception e) {
            
            JOptionPane.showInputDialog("Se produjo un error: "+ e);
        }
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                lista.add(rs.getString("nombre_interes_cultural"));

            }
        } catch (Exception e) {
        }
            return lista;
    }
    
    
 
    
    public DefaultTableModel mostrarReliMuni(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Interes Cultural"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        


        sSQL =  "SELECT nombre_interes_cultural\n" +
                "FROM intereses_culturales,  tipo_intereses_culturales\n" +
                "WHERE ID_tipo_interes ='"+buscar+"' AND tipo_intereses_culturales."+
                "id_tipo_interes = intereses_culturales.id_tipo_interes \n" +
                "ORDER BY nombre_interes_cultural; ";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("nombre_interes_cultural");
//                Registros[1] = rs.getString("nombre_municipio");                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
    
   
      
    
    
}
