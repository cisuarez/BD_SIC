package Datos;

public class dTipoTradiciones {

    String Id_Tipo_Tradicion;
    String Nombre_Tipo_Tradicion;

    public dTipoTradiciones() {
    }

    public dTipoTradiciones(String Id_Tipo_Tradicion, String Nombre_Tipo_Tradicion) {
        this.Id_Tipo_Tradicion = Id_Tipo_Tradicion;
        this.Nombre_Tipo_Tradicion = Nombre_Tipo_Tradicion;
    }

    public String getId_Tipo_Tradicion() {
        return Id_Tipo_Tradicion;
    }

    public void setId_Tipo_Tradicion(String Id_Tipo_Tradicion) {
        this.Id_Tipo_Tradicion = Id_Tipo_Tradicion;
    }

    public String getNombre_Tipo_Tradicion() {
        return Nombre_Tipo_Tradicion;
    }

    public void setNombre_Tipo_Tradicion(String Nombre_Tipo_Tradicion) {
        this.Nombre_Tipo_Tradicion = Nombre_Tipo_Tradicion;
    }
    
    
    
}
