package Datos;

public class dTradiciones {
    
    String Id_Tradicion;
    String Nombre_Tradicion;
    String Descripcion_Tradicion;
    String Fecha_Festejo;
    String Imagen_Tradicion;
    String Id_Tipo_Tradicion;

    public dTradiciones() {
    }

    public dTradiciones(String Id_Tradicion, String Nombre_Tradicion, String Descripcion_Tradicion, String Fecha_Festejo, String Imagen_Tradicion, String Id_Tipo_Tradicion) {
        this.Id_Tradicion = Id_Tradicion;
        this.Nombre_Tradicion = Nombre_Tradicion;
        this.Descripcion_Tradicion = Descripcion_Tradicion;
        this.Fecha_Festejo = Fecha_Festejo;
        this.Imagen_Tradicion = Imagen_Tradicion;
        this.Id_Tipo_Tradicion = Id_Tipo_Tradicion;
    }

    public String getId_Tradicion() {
        return Id_Tradicion;
    }

    public void setId_Tradicion(String Id_Tradicion) {
        this.Id_Tradicion = Id_Tradicion;
    }

    public String getNombre_Tradicion() {
        return Nombre_Tradicion;
    }

    public void setNombre_Tradicion(String Nombre_Tradicion) {
        this.Nombre_Tradicion = Nombre_Tradicion;
    }

    public String getDescripcion_Tradicion() {
        return Descripcion_Tradicion;
    }

    public void setDescripcion_Tradicion(String Descripcion_Tradicion) {
        this.Descripcion_Tradicion = Descripcion_Tradicion;
    }

    public String getFecha_Festejo() {
        return Fecha_Festejo;
    }

    public void setFecha_Festejo(String Fecha_Festejo) {
        this.Fecha_Festejo = Fecha_Festejo;
    }

    public String getImagen_Tradicion() {
        return Imagen_Tradicion;
    }

    public void setImagen_Tradicion(String Imagen_Tradicion) {
        this.Imagen_Tradicion = Imagen_Tradicion;
    }

    public String getId_Tipo_Tradicion() {
        return Id_Tipo_Tradicion;
    }

    public void setId_Tipo_Tradicion(String Id_Tipo_Tradicion) {
        this.Id_Tipo_Tradicion = Id_Tipo_Tradicion;
    }
    
    
    
}
