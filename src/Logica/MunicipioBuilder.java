public class MunicipioBuilder {
    private dMunicipios municipio = new dMunicipios();

    public MunicipioBuilder setId(String id) {
        municipio.setId_municipio(id);
        return this;
    }

    public MunicipioBuilder setNombre(String nombre) {
        municipio.setNombre_municipio(nombre);
        return this;
    }

    public MunicipioBuilder setUbicacion(String ubicacion) {
        municipio.setUbicacion_municipio(ubicacion);
        return this;
    }

    public MunicipioBuilder setClima(String clima) {
        municipio.setClima_municipio(clima);
        return this;
    }

    public MunicipioBuilder setEscudo(FileInputStream escudo) {
        municipio.setEscudo_municipio(escudo);
        return this;
    }

    public MunicipioBuilder setIdRegion(String idRegion) {
        municipio.setId_region_municipio(idRegion);
        return this;
    }

    public MunicipioBuilder setNumHabitantes(int numHabitantes) {
        municipio.setNumero_habitantes(numHabitantes);
        return this;
    }

    public MunicipioBuilder setNumMujeres(int numMujeres) {
        municipio.setNumero_mujeres(numMujeres);
        return this;
    }

    public MunicipioBuilder setNumHombres(int numHombres) {
        municipio.setNumero_hombre(numHombres);
        return this;
    }

    public dMunicipios build() {
        return municipio;
    }
}
