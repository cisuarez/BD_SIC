package Datos;


public class dLenguajes {
    
    String Id_Lenguaje;
    String Nombre_Lenguaje;

    
    //Constructures
    public dLenguajes() {
    }

    public dLenguajes(String Id_Lenguaje, String Nombre_Lenguaje) {
        this.Id_Lenguaje = Id_Lenguaje;
        this.Nombre_Lenguaje = Nombre_Lenguaje;
    }

    
    //Setters and Getters
    public String getId_Lenguaje() {
        return Id_Lenguaje;
    }

    public void setId_Lenguaje(String Id_Lenguaje) {
        this.Id_Lenguaje = Id_Lenguaje;
    }

    public String getNombre_Lenguaje() {
        return Nombre_Lenguaje;
    }

    public void setNombre_Lenguaje(String Nombre_Lenguaje) {
        this.Nombre_Lenguaje = Nombre_Lenguaje;
    }
    
    
    
}
