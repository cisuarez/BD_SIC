package Datos;

public class dRegiones {
    String Id_Region;
    String Nombre_Region;
    String Capital_Regional;
    String Extencion_Territorial;
    String Ubicacion_Geografica;
    int Numero_Habitantes;
    int Numero_Municipios;

    public dRegiones() {
    }

    public dRegiones(String Id_Region, String Nombre_Region, String Capital_Regional, 
           String Extencion_Territorial, String Ubicacion_Geografica, 
           int Numero_Habitantes, int Numero_Municipios) {
        
        this.Id_Region = Id_Region;
        this.Nombre_Region = Nombre_Region;
        this.Capital_Regional = Capital_Regional;
        this.Extencion_Territorial = Extencion_Territorial;
        this.Ubicacion_Geografica = Ubicacion_Geografica;
        this.Numero_Habitantes = Numero_Habitantes;
        this.Numero_Municipios = Numero_Municipios;
    }

    public String getId_Region() {
        return Id_Region;
    }

    public void setId_Region(String Id_Region) {
        this.Id_Region = Id_Region;
    }

    public String getNombre_Region() {
        return Nombre_Region;
    }

    public void setNombre_Region(String Nombre_Region) {
        this.Nombre_Region = Nombre_Region;
    }

    public String getCapital_Regional() {
        return Capital_Regional;
    }

    public void setCapital_Regional(String Capital_Regional) {
        this.Capital_Regional = Capital_Regional;
    }

    public String getExtencion_Territorial() {
        return Extencion_Territorial;
    }

    public void setExtencion_Territorial(String Extencion_Territorial) {
        this.Extencion_Territorial = Extencion_Territorial;
    }

    public String getUbicacion_Geografica() {
        return Ubicacion_Geografica;
    }

    public void setUbicacion_Geografica(String Ubicacion_Geografica) {
        this.Ubicacion_Geografica = Ubicacion_Geografica;
    }

    public int getNumero_Habitantes() {
        return Numero_Habitantes;
    }

    public void setNumero_Habitantes(int Numero_Habitantes) {
        this.Numero_Habitantes = Numero_Habitantes;
    }

    public int getNumero_Municipios() {
        return Numero_Municipios;
    }

    public void setNumero_Municipios(int Numero_Municipios) {
        this.Numero_Municipios = Numero_Municipios;
    }
    
    
    
    
    
}
