package Datos;

import java.io.FileInputStream;

public class dIntereses_Culturales {
    
    String Id_Interes_Cultural;
    String Nombre_Interes_Cultural;
    String Descripcion_Interes_Cultural;
    String Horario_Interes_Cultural;
    String Direccion_Interes_Cultural;
    FileInputStream Imagen_Interes_Cultural;
    String Id_Municipio;
    String Id_Tipo_Interes;

    public dIntereses_Culturales() {
    }

    public dIntereses_Culturales(String Id_Interes_Cultural, String Nombre_Interes_Cultural, String Descripcion_Interes_Cultural, String Horario_Interes_Cultural, String Direccion_Interes_Cultural, FileInputStream Imagen_Interes_Cultural, String Id_Municipio, String Id_Tipo_Interes) {
        this.Id_Interes_Cultural = Id_Interes_Cultural;
        this.Nombre_Interes_Cultural = Nombre_Interes_Cultural;
        this.Descripcion_Interes_Cultural = Descripcion_Interes_Cultural;
        this.Horario_Interes_Cultural = Horario_Interes_Cultural;
        this.Direccion_Interes_Cultural = Direccion_Interes_Cultural;
        this.Imagen_Interes_Cultural = Imagen_Interes_Cultural;
        this.Id_Municipio = Id_Municipio;
        this.Id_Tipo_Interes = Id_Tipo_Interes;
    }

    public String getId_Interes_Cultural() {
        return Id_Interes_Cultural;
    }

    public void setId_Interes_Cultural(String Id_Interes_Cultural) {
        this.Id_Interes_Cultural = Id_Interes_Cultural;
    }

    public String getNombre_Interes_Cultural() {
        return Nombre_Interes_Cultural;
    }

    public void setNombre_Interes_Cultural(String Nombre_Interes_Cultural) {
        this.Nombre_Interes_Cultural = Nombre_Interes_Cultural;
    }

    public String getDescripcion_Interes_Cultural() {
        return Descripcion_Interes_Cultural;
    }

    public void setDescripcion_Interes_Cultural(String Descripcion_Interes_Cultural) {
        this.Descripcion_Interes_Cultural = Descripcion_Interes_Cultural;
    }

    public String getHorario_Interes_Cultural() {
        return Horario_Interes_Cultural;
    }

    public void setHorario_Interes_Cultural(String Horario_Interes_Cultural) {
        this.Horario_Interes_Cultural = Horario_Interes_Cultural;
    }

    public String getDireccion_Interes_Cultural() {
        return Direccion_Interes_Cultural;
    }

    public void setDireccion_Interes_Cultural(String Direccion_Interes_Cultural) {
        this.Direccion_Interes_Cultural = Direccion_Interes_Cultural;
    }

    public FileInputStream getImagen_Interes_Cultural() {
        return Imagen_Interes_Cultural;
    }

    public void setImagen_Interes_Cultural(FileInputStream Imagen_Interes_Cultural) {
        this.Imagen_Interes_Cultural = Imagen_Interes_Cultural;
    }

    public String getId_Municipio() {
        return Id_Municipio;
    }

    public void setId_Municipio(String Id_Municipio) {
        this.Id_Municipio = Id_Municipio;
    }

    public String getId_Tipo_Interes() {
        return Id_Tipo_Interes;
    }

    public void setId_Tipo_Interes(String Id_Tipo_Interes) {
        this.Id_Tipo_Interes = Id_Tipo_Interes;
    }
    
    
    
}
