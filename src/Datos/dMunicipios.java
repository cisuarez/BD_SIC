package Datos;


public class dMunicipios {
    
    String id_municipio;
    String nombre_municipio;
    String ubicacion_municipio;
    String clima_municipio;
    String id_region_municipio;
    String escudo_municipio;
    int numero_habitantes;
    int numero_hombre;
    int numero_mujeres;

    public dMunicipios() {
    }

    
    //Manejo de Datos de los municipios
    public dMunicipios(String id_municipio, String nombre_municipio, String ubicacion_municipio, String clima_municipio, String id_region_municipio, String escudo_municipio, int numero_habitantes, int numero_hombre, int numero_mujeres) {
        this.id_municipio = id_municipio;
        this.nombre_municipio = nombre_municipio;
        this.ubicacion_municipio = ubicacion_municipio;
        this.clima_municipio = clima_municipio;
        this.id_region_municipio = id_region_municipio;
        this.escudo_municipio = escudo_municipio;
        this.numero_habitantes = numero_habitantes;
        this.numero_hombre = numero_hombre;
        this.numero_mujeres = numero_mujeres;
    }

    public String getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(String id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public String getUbicacion_municipio() {
        return ubicacion_municipio;
    }

    public void setUbicacion_municipio(String ubicacion_municipio) {
        this.ubicacion_municipio = ubicacion_municipio;
    }

    public String getClima_municipio() {
        return clima_municipio;
    }

    public void setClima_municipio(String clima_municipio) {
        this.clima_municipio = clima_municipio;
    }

    public String getId_region_municipio() {
        return id_region_municipio;
    }

    public void setId_region_municipio(String id_region_municipio) {
        this.id_region_municipio = id_region_municipio;
    }

    public String getEscudo_municipio() {
        return escudo_municipio;
    }

    public void setEscudo_municipio(String escudo_municipio) {
        this.escudo_municipio = escudo_municipio;
    }

    public int getNumero_habitantes() {
        return numero_habitantes;
    }

    public void setNumero_habitantes(int numero_habitantes) {
        this.numero_habitantes = numero_habitantes;
    }

    public int getNumero_hombre() {
        return numero_hombre;
    }

    public void setNumero_hombre(int numero_hombre) {
        this.numero_hombre = numero_hombre;
    }

    public int getNumero_mujeres() {
        return numero_mujeres;
    }

    public void setNumero_mujeres(int numero_mujeres) {
        this.numero_mujeres = numero_mujeres;
    }
    
    
    
    
    
}
