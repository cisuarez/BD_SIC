package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fRegiones {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";

    public int total_registros;
    
    
    
    public DefaultTableModel mostrarMunicipios(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Municipios"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT nombre_municipio FROM regiones, municipios WHERE regiones.id_region = '" + buscar 
                + "' AND regiones.id_region = municipios.id_region"
                + " ORDER BY nombre_municipio;";
       
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("nombre_municipio");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
             
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
    
    /*
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
    
    */   
    
    
    public ArrayList<String> llenar_combo_Regiones(){
        ArrayList<String> lista = new ArrayList<String>();
        
        sSQL = "SELECT * FROM regiones";
        
       
        
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
                
                lista.add(rs.getString("nombre_region"));
                
            
            }
        } catch (Exception e) {
        }
    
        return lista;
    }
    
    
    
}
