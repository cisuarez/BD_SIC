package Logica;

import Datos.dLenguajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fLenguajes {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";

    public int total_registros;
    
    //Metodo para llenar la tabla con el id_reliigon a buscar
    public DefaultTableModel mostrar(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Lenguaje"};
        String [] Registros = new String[2];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT * FROM lenguajes WHERE id_lengua LIKE '%" + buscar + "%' ORDER BY id_lengua;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("id_lengua");
                Registros[1] = rs.getString("nombre_lengua");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
   
    
    //Metodo Insertar Lenguaje
    public boolean insertar(dLenguajes dts){
        
        sSQL = "INSERT INTO lenguajes (id_lengua, nombre_lengua) values(?,?)";
        
        
        
        try {
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Lenguaje());
            pat.setString(2, dts.getNombre_Lenguaje());
            
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


    
       
    //Metodo para meter los nombres de los lenguajes en una tabla
    public DefaultTableModel mostrarLenguajes(){

        DefaultTableModel modelo;
        String [] Titulos = {"Lenguaje"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT nombre_lengua FROM lenguajes ORDER BY nombre_lengua;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("nombre_lengua");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
   
    
        public DefaultTableModel mostrarLenguajesMunicipios(String Nombre){

        DefaultTableModel modelo;
        String [] Titulos = {"Municipio", "Region"};
        String [] Registros = new String[2];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL =  "SELECT municipios.nombre_municipio, regiones.nombre_region\n" +
                "FROM municipios, lenguajes, municipios_lenguajes, regiones\n" +
                "WHERE lenguajes.nombre_lengua = '"+ Nombre +"' AND lenguajes.id_lengua"+
                " = municipios_lenguajes.id_lengua AND municipios_lenguajes.id_municipio "+
                "= municipios.id_municipio AND municipios.id_region = regiones.id_region "+
                "ORDER BY regiones.nombre_region;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("municipios.nombre_municipio");
                Registros[1] = rs.getString("regiones.nombre_region");
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
    
    
   
    
    
    
    //Metodo Modificar Religion
    public boolean modificar(dLenguajes dts){
        
        sSQL = "UPDATE lenguajes set nombre_lengua = ? "+
                "WHERE id_lengua = ? ;";
        
        
        try {
            
            //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(2, dts.getId_Lenguaje());
            pat.setString(1, dts.getNombre_Lenguaje());
            
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
    public boolean eliminar(dLenguajes dts){
        
        sSQL ="DELETE FROM lenguajes WHERE id_lengua = ?" ;
        
        try {
             //
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Lenguaje());
            
            
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
    
     public DefaultTableModel mostrarLengMuni(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Lenguajes"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT nombre_lengua FROM lenguajes, municipios_lenguajes " +
                "WHERE municipios_lenguajes.id_municipio = '"+ buscar
                +"' AND municipios_lenguajes.id_lengua = lenguajes.id_lengua;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                Registros[0] = rs.getString("nombre_lengua");
                
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
