package Datos;

public class dReligiones {
    
    String id_Religion;
    String Nombre_Religion;

    public dReligiones(String id_Religion, String Nombre_Religion) {
        this.id_Religion = id_Religion;
        this.Nombre_Religion = Nombre_Religion;
    }

    public dReligiones() {
    }

    public String getId_Religion() {
        return id_Religion;
    }

    public void setId_Religion(String id_Religion) {
        this.id_Religion = id_Religion;
    }

    public String getNombre_Religion() {
        return Nombre_Religion;
    }

    public void setNombre_Religion(String Nombre_Religion) {
        this.Nombre_Religion = Nombre_Religion;
    }
    
    
    
}
