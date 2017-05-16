package Logica;

import Datos.dIntereses_Culturales;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
// CHECAR ESTA PARTE 
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
    
    

    
    /****************************************************************
     *                                                              *    
     *                                                              *
     *          OPERACIONES BASICAS DE INTERESES CULTURLES          *
     *                                                              *
     *                                                              *
     ************************************************************** *
     */
    
    
        //Metodo Insertar 
    public boolean insertar(dIntereses_Culturales dts){
        
        sSQL = "INSERT INTO `intereses_culturales` (`id_interes_cultural`,"
                + " nombre_interes_cultural`, `descripcion_interes_cultural`, "
                + "`horario_interes_cultural`, `direccion_interes_cultural`, "
                + "`imagen_interes_cultural`, `id_municipio`, `id_tipo_interes`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        
        
        
        try {
        
            FileInputStream imagen;
            
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_Interes_Cultural());
            pat.setString(2, dts.getNombre_Interes_Cultural());
            pat.setString(3, dts.getDescripcion_Interes_Cultural());
            pat.setString(4, dts.getHorario_Interes_Cultural());
            pat.setString(5, dts.getDireccion_Interes_Cultural());
            pat.setBinaryStream(6, dts.getImagen_Interes_Cultural());
            pat.setString(7, dts.getId_Municipio());
            pat.setString(8, dts.getId_Tipo_Interes());
            
            
            
            
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
    
    public boolean eliminar(dIntereses_Culturales dts){
    
        sSQL ="DELETE FROM intereses_culturales WHERE id_interes_cultural = ?" ;
    
        try{
        
            PreparedStatement pat = cn.prepareStatement(sSQL);
            
            pat.setString(1, dts.getId_Interes_Cultural());
            
            
            int n = pat.executeUpdate();
            
            if(n != 0){
                return true;
            
            }else{
                return false;
            }
            
        }
        catch(Exception e){
            
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
            
        }
            
    
    }
    
    

    public boolean modificar(dIntereses_Culturales dts){
        
        sSQL = "UPDATE `intereses_culturales` SET `nombre_interes_cultural`=?, "
                + "`descripcion_interes_cultural`=?, `horario_interes_cultural`=?,"
                + " `direccion_interes_cultural`=?, `id_municipio`=?, "
                + "`id_tipo_interes`=? WHERE `id_interes_cultural`=?;";
     
        
        
        
        try {
            
            PreparedStatement pat = cn.prepareStatement(sSQL);
            
            pat.setString(1, dts.getNombre_Interes_Cultural());
            pat.setString(2, dts.getDescripcion_Interes_Cultural());
            pat.setString(3, dts.getHorario_Interes_Cultural());
            pat.setString(4, dts.getDireccion_Interes_Cultural());
            pat.setString(5, dts.getId_Municipio());
            pat.setString(6, dts.getId_Tipo_Interes());
            pat.setString(7, dts.getId_Interes_Cultural());
            
            
            int n = pat.executeUpdate();
            
            if(n != 0){
                return true;
            
            }else{
                return false;
            }
            
            //
            
        } catch (Exception e) {
            
           // JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    
    }
    
    public boolean actualizarImagen(dIntereses_Culturales dts){
        
        sSQL = "UPDATE intereses_culturales SET imagen_interes_cultural =? "
             + "WHERE id_interes_cultural = ?;";
        
        
        try {
            
            PreparedStatement pat = cn.prepareStatement(sSQL);
          
            pat.setBinaryStream(1, dts.getImagen_Interes_Cultural());            
            pat.setString(2, dts.getId_Interes_Cultural());            
            
            
            int n = pat.executeUpdate();
            
            if(n != 0){
                return true;
            
            }else{
                return false;
            }
            
            //
            
        } catch (Exception e) {
            
        //    JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    
    }
    
       
      
    
         public DefaultTableModel mostrarTodo(String buscar, int Condicion){

        DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Interes Cultural", "Tipo" ,"Municipio","Region"};
        String [] Registros = new String[5];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
       
        
        if(Condicion == 1 ){
        
            
            //mostrarTodo
        sSQL =  "SELECT intereses_culturales.id_interes_cultural, "
                + "intereses_culturales.nombre_interes_cultural, "
                + "tipo_intereses_culturales.nombre_tipo_interes, "
                + "municipios.nombre_municipio, regiones.nombre_region "
                + "FROM intereses_culturales, tipo_intereses_culturales, municipios,"
                + " regiones WHERE intereses_culturales.id_interes_cultural like '%"+buscar+"%' "
                + "AND intereses_culturales.id_tipo_interes = tipo_intereses_culturales.id_tipo_interes "
                + "AND intereses_culturales.id_municipio = municipios.id_municipio AND "
                + "municipios.id_region = regiones.id_region;";
        
                
            
        }
        
        if(Condicion == 2 ){
        
                 sSQL =  "SELECT intereses_culturales.id_interes_cultural, "
                + "intereses_culturales.nombre_interes_cultural, "
                + "tipo_intereses_culturales.nombre_tipo_interes, "
                + "municipios.nombre_municipio, regiones.nombre_region "
                + "FROM intereses_culturales, tipo_intereses_culturales, municipios,"
                + " regiones WHERE intereses_culturales.nombre_interes_cultural like '%"+buscar+"%' "
                + "AND intereses_culturales.id_tipo_interes = tipo_intereses_culturales.id_tipo_interes "
                + "AND intereses_culturales.id_municipio = municipios.id_municipio AND "
                + "municipios.id_region = regiones.id_region;";
            
        }
        
        
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("intereses_culturales.id_interes_cultural");
                Registros[1] = rs.getString("intereses_culturales.nombre_interes_cultural");
                Registros[2] = rs.getString("tipo_intereses_culturales.nombre_tipo_interes");
                Registros[3] = rs.getString("municipios.nombre_municipio");
                Registros[4] = rs.getString("regiones.nombre_region");
            
           
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }
    
         
         
         
    public DefaultTableModel mostrarDatosCompletos(String buscar, int Condicion){

      DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Interes Cultural","Descripcion","Horario","Direccion" ,"Tipo" ,"Municipio","Region"};
        String [] Registros = new String[8];
         
        
        dIntereses_Culturales dts = new dIntereses_Culturales();
        
        total_registros = 0;
        
       modelo = new DefaultTableModel(null,Titulos);
        
       
        
        if(Condicion == 1 ){
        
            
            //mostrarTodo
        sSQL =  "SELECT intereses_culturales.id_interes_cultural, \n" +
                "intereses_culturales.nombre_interes_cultural, \n" +
                "intereses_culturales.descripcion_interes_cultural,\n" +
                "intereses_culturales.horario_interes_cultural,\n" +
                "intereses_culturales.direccion_interes_cultural,\n" +
                "tipo_intereses_culturales.nombre_tipo_interes, \n" +
                "municipios.nombre_municipio, \n" +
                "regiones.nombre_region \n" +
                "FROM intereses_culturales, tipo_intereses_culturales, municipios, regiones "+ 
                "WHERE intereses_culturales.id_interes_cultural like '%"+buscar+"%' \n" +
                "AND intereses_culturales.id_tipo_interes = tipo_intereses_culturales.id_tipo_interes "
                + "AND intereses_culturales.id_municipio = municipios.id_municipio AND "
                + "municipios.id_region = regiones.id_region;";
        
                
            
        }
        
        if(Condicion == 2 ){
        
        sSQL =  "SELECT intereses_culturales.id_interes_cultural, \n" +
                "intereses_culturales.nombre_interes_cultural, \n" +
                "intereses_culturales.descripcion_interes_cultural,\n" +
                "intereses_culturales.horario_interes_cultural,\n" +
                "intereses_culturales.direccion_interes_cultural,\n" +
                "tipo_intereses_culturales.nombre_tipo_interes, \n" +
                "municipios.nombre_municipio, \n" +
                "regiones.nombre_region \n" +
                "FROM intereses_culturales, tipo_intereses_culturales, municipios, regiones "+ 
                "WHERE intereses_culturales.nombre_interes_cultural like '%"+buscar+"%' \n" +
                "AND intereses_culturales.id_tipo_interes = tipo_intereses_culturales.id_tipo_interes "
                + "AND intereses_culturales.id_municipio = municipios.id_municipio AND "
                + "municipios.id_region = regiones.id_region;";
                
        }
        
        
        
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
        
            
            
            while(rs.next()){
                Registros[0] = rs.getString("intereses_culturales.id_interes_cultural");
                Registros[1] = rs.getString("intereses_culturales.nombre_interes_cultural");
                Registros[2] = rs.getString("intereses_culturales.descripcion_interes_cultural");
                Registros[3] = rs.getString("intereses_culturales.horario_interes_cultural");
                Registros[4] = rs.getString("intereses_culturales.direccion_interes_cultural");
                Registros[5] = rs.getString("tipo_intereses_culturales.nombre_tipo_interes");
                Registros[6] = rs.getString("municipios.nombre_municipio");
                Registros[7] = rs.getString("regiones.nombre_region");            
            
            
            
                
                
                
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
