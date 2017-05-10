package Datos;

public class dTipoInteresCultural {
    
    String Id_Tipo_Interes_Cult;
    String Nombre_Tipo_Interes_Cult;

    public dTipoInteresCultural() {
    }

    public dTipoInteresCultural(String Id_Tipo_Interes_Cult, String Nombre_Tipo_Interes_Cult) {
        this.Id_Tipo_Interes_Cult = Id_Tipo_Interes_Cult;
        this.Nombre_Tipo_Interes_Cult = Nombre_Tipo_Interes_Cult;
    }

    public String getId_Tipo_Interes_Cult() {
        return Id_Tipo_Interes_Cult;
    }

    public void setId_Tipo_Interes_Cult(String Id_Tipo_Interes_Cult) {
        this.Id_Tipo_Interes_Cult = Id_Tipo_Interes_Cult;
    }

    public String getNombre_Tipo_Interes_Cult() {
        return Nombre_Tipo_Interes_Cult;
    }

    public void setNombre_Tipo_Interes_Cult(String Nombre_Tipo_Interes_Cult) {
        this.Nombre_Tipo_Interes_Cult = Nombre_Tipo_Interes_Cult;
    }
    
    

    
}
