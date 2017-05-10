package Logica;

import Datos.dReligiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fReligiones {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";

    public int total_registros;
    
    //Metodo para llenar la tabla con el id_reliigon a buscar
    public DefaultTableModel mostrar(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Religion"};
        String [] Registros = new String[2];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT * FROM religiones WHERE id_religion LIKE '%" + buscar + "%' ORDER BY id_religion;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("id_religion");
                Registros[1] = rs.getString("nombre_religion");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    




    //Metodo para meter los nombres de las religiones en una tabla
    public DefaultTableModel mostrarReligiones(){

        DefaultTableModel modelo;
        String [] Titulos = {"Religiones"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT nombre_religion FROM religiones ORDER BY nombre_religion;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("nombre_religion");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
    
    
    
 
    public DefaultTableModel mostrarReliMuni(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Religion"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT nombre_religion FROM religiones, municipios_religiones WHERE id_municipio = '"+ buscar 
              +"' AND municipios_religiones.id_municipio = municipios_religiones.id_municipio AND"+
               " municipios_religiones.id_religion = religiones.id_religion ORDER BY religiones.id_religion;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("nombre_religion");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
  
    
    
    //Metodo Insertar Religion
    public boolean insertar(dReligiones dts){
        
        sSQL = "INSERT INTO religiones (id_religion, nombre_religion) values(?,?)";
        
        
        
        try {
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Religion());
            pat.setString(2, dts.getNombre_Religion());
            
            int n = pat.executeUpdate();
            
            if(n != 0){
                return true;
            
            }else{
                return false;
            }
             
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    
    }
    
    
    //Metodo Modificar Religion
    public boolean modificar(dReligiones dts){
        
        sSQL = "UPDATE religiones set nombre_religion = ? "+
                "WHERE id_religion = ? ;";
        
        
        try {
            
            //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(2, dts.getId_Religion());
            pat.setString(1, dts.getNombre_Religion());
            
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
    public boolean eliminar(dReligiones dts){
        
        sSQL ="DELETE FROM religiones WHERE id_religion = ?" ;
        
        try {
             //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Religion());
            
            
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
