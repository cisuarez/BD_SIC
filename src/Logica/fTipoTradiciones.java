package Logica;

import Datos.dTipoTradiciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fTipoTradiciones {
    
    
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";

    public int total_registros;
    public int bandera = 0; 
    
    public DefaultTableModel mostrar(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Tipo de Tradicion"};
        String [] Registros = new String[2];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT * FROM tipo_tradicion WHERE id_tipo_tradicion LIKE '%" + buscar + "%' ORDER BY id_tipo_tradicion;";
       
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("id_tipo_tradicion");
                Registros[1] = rs.getString("nombre_tipo_tradicion");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
             
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
    //Metodo Insertar 
    public boolean insertar(dTipoTradiciones dts){
        
        sSQL = "INSERT INTO tipo_tradicion (id_tipo_tradicion, nombre_tipo_tradicion) values(?,?)";
        
        
        
        try {
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Tipo_Tradicion());
            pat.setString(2, dts.getNombre_Tipo_Tradicion());
            
            int n = pat.executeUpdate();
            
            if(n != 0){
            
                return true;
            
            }
            else
            {
                
                
                return false;
            }
             
            
        } catch (Exception e) {
            
            
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    
    }
    
    
    //Metodo Modificar Religion
    public boolean modificar(dTipoTradiciones dts){
        
        sSQL = "UPDATE tipo_tradicion set nombre_tipo_tradicion = ? "+
                "WHERE id_tipo_tradicion = ? ;";
        
        
        try {
            
            //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(2, dts.getId_Tipo_Tradicion());
            pat.setString(1, dts.getNombre_Tipo_Tradicion());
            
            int n = pat.executeUpdate();
            
            if(n != 0){
                return true;
            
            }else{
                return false;
            }
            
            //
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    
    }
    
     
    //Metodo Eliminar Religion
    public boolean eliminar(dTipoTradiciones dts){
        
        sSQL ="DELETE FROM tipo_tradicion WHERE id_tipo_tradicion = ?" ;
        
        try {
             //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Tipo_Tradicion());
            
            
            int n = pat.executeUpdate();
            
            if(n != 0){
                return true;
            
            }else{
                return false;
            }
            
            //
            
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    
    }
    
    
   
    
}
