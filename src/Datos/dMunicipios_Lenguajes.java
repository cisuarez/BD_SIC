package Datos;


public class dMunicipios_Lenguajes {
    
    String Id_Lengua;
    String Id_Municipio;

    public dMunicipios_Lenguajes() {
    }

    public dMunicipios_Lenguajes(String Id_Lengua, String Id_Municipio) {
        this.Id_Lengua = Id_Lengua;
        this.Id_Municipio = Id_Municipio;
    }

    public String getId_Lengua() {
        return Id_Lengua;
    }

    public void setId_Lengua(String Id_Lengua) {
        this.Id_Lengua = Id_Lengua;
    }

    public String getId_Municipio() {
        return Id_Municipio;
    }

    public void setId_Municipio(String Id_Municipio) {
        this.Id_Municipio = Id_Municipio;
    }
    
    
    
}
