package Logica;

import Datos.dTipoInteresCultural;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fTipoInteresCultural {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";

    public int total_registros;
   
    
    public DefaultTableModel mostrar(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Tipo de Interes Cult"};
        String [] Registros = new String[2];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT * FROM tipo_intereses_culturales WHERE id_tipo_interes LIKE '%" + buscar + "%' ORDER BY id_tipo_interes;";
       
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("id_tipo_interes");
                Registros[1] = rs.getString("nombre_tipo_interes");
                
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
    public boolean insertar(dTipoInteresCultural dts){
        
        sSQL = "INSERT INTO tipo_intereses_culturales (id_tipo_interes, nombre_tipo_interes) values(?,?)";
        
        
        
        try {
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Tipo_Interes_Cult());
            pat.setString(2, dts.getNombre_Tipo_Interes_Cult());
            
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
    public boolean modificar(dTipoInteresCultural dts){
        
        sSQL = "UPDATE tipo_intereses_culturales set nombre_tipo_interes = ? "+
                "WHERE id_tipo_interes = ? ;";
        
        
        try {
            
            //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(2, dts.getId_Tipo_Interes_Cult());
            pat.setString(1, dts.getNombre_Tipo_Interes_Cult());
            
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
    public boolean eliminar(dTipoInteresCultural dts){
        
        sSQL ="DELETE FROM tipo_intereses_culturales WHERE id_tipo_interes = ?" ;
        
        try {
             //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Tipo_Interes_Cult());
            
            
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
    
    
/*
    
    
    
        public ArrayList<String> LlenarComboBoxTipoTradicion(){
        ArrayList<String> lista = new ArrayList<String>();
        
        sSQL = "SELECT * FROM tipo_tradicion";
        
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
                
                lista.add(rs.getString("nombre_tipo_tradicion"));
                
            
            }
        } catch (Exception e) {
        }
    
        return lista;
    }
    
    
    */    
     public ArrayList<String> llenar_cob(){
        ArrayList<String> lista = new ArrayList<String>();
        
        sSQL = "SELECT nombre_tipo_interes FROM tipo_intereses_culturales";

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
                
                lista.add(rs.getString("nombre_tipo_interes"));

            }
        } catch (Exception e) {
        }
            return lista;
    }
   
    
    
    

     
     
     
     
}
