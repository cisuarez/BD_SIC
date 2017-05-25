package Logica;


import Datos.dMunicipios;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fMunicipios {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    
    public int total_registros;

    
    public DefaultTableModel mostrar(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Identificador", "Municipio","Ubicacion","Clima","Escudo",
                             "Region", "#Habitantes", "#Mujeres", "#Hombre"};
        
        String [] Registros = new String[9];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
       /* sSQL = "SELECT municipios.id_municipio , municipios.nombre_municipio, "
             + "municipios.ubicacion_municipio, municipios.clima_municipio, "
             + "regiones.nombre_region, municipios.numero_habitantes_municipio, "
             + "municipios.numero_hombres, municipios.numero_mujeres, "
             + "municipios.act_economica_municipio\n" 
             + "FROM municipios, regiones\n" 
             + "WHERE municipios.id_municipio = '"+ buscar +"' "
             + "AND municipios.id_region = regiones.id_region;";
         */       
            sSQL = "SELECT * FROM municipios WHERE id_municipio LIKE '%" + buscar + "%' ORDER BY id_region;";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                Registros[0] = rs.getString("id_municipio");
                Registros[1] = rs.getString("nombre_municipio");
                Registros[2] = rs.getString("ubicacion_municipio");
                Registros[3] = rs.getString("clima_municipio");
                Registros[4] = rs.getString("escudo_municipio");
                Registros[5] = rs.getString("id_region");
                Registros[6] = rs.getString("numero_habitantes_municipio");
                Registros[7] = rs.getString("numero_hombres");
                Registros[8] = rs.getString("numero_mujeres");
                
                total_registros = total_registros + 1;
                
                modelo.addRow(Registros);
            }
            
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return null;
            
        }
    
    }

    
    
     public DefaultTableModel mostrarNomMuni(String buscar){

        DefaultTableModel modelo;
        String [] Titulos = {"Municipio"};
        String [] Registros = new String[1];
         
        total_registros = 0;
        
        modelo = new DefaultTableModel(null,Titulos);
        
        sSQL = "SELECT * FROM municipios WHERE id_region = '" + buscar + "' ORDER BY id_region;";
        
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
    
    
    
    //Metodo Insertar Municipio
    public boolean insertar(dMunicipios dts){
        
        sSQL = " INSERT INTO municipios (id_municipios, nombre_municipio, ubicacion_municipio,"+
               " clima_municipio, escudo_municipio, id_region, numero_habitantes_municipio,"+
               " numero_mujeres, numero_hombre) values(?,?,?,?,?,?,?,?,?)";
        
        
        try {
            
            FileInputStream archivoEscudo;
            
            PreparedStatement pat = cn.prepareStatement(sSQL);
            pat.setString(1, dts.getId_municipio());
            pat.setString(2, dts.getNombre_municipio());
            pat.setString(3, dts.getUbicacion_municipio());
            pat.setString(4, dts.getClima_municipio());
            pat.setBinaryStream(5, dts.getEscudo_municipio());
            pat.setString(6, dts.getId_region_municipio());
            pat.setInt(7, dts.getNumero_habitantes());
            pat.setInt(8, dts.getNumero_mujeres());
            pat.setInt(9, dts.getNumero_hombre());
            
           // archivoEscudo = new FileInputStream(dts.getEscudo_municipio());
           // pat.setBinaryStream(5, archivoEscudo);

            
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
    
    
    
    
        public ArrayList<String> llenar_combo_Municipios(String id){
        ArrayList<String> lista = new ArrayList<String>();
        
        sSQL = "SELECT * FROM municipios WHERE id_region = '"+ id +"';";

        
        try {
            
            
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL);
            //rs = st.executeQuery(Consulta);
            
        } catch (Exception e) {
            
            JOptionPane.showInputDialog("Se produjo un error: "+ e);
        }
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                
                lista.add(rs.getString("nombre_municipio"));
            
            }
        } catch (Exception e) {
        }
    
        return lista;
    }
    
    
    
    
    
    
}
