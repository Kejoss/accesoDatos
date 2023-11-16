package tema2.ejercicios.actividad7;

import java.util.Arrays;

public class KevinMorenoCV {
    
    private String nombre;
    private String edad;
    private String correoElec;
    private String telefono;
    private String nivelIngles;
    private String[] competencias;
    private String[] listaEstudios;
    private String[] listaTrabajos;

    public KevinMorenoCV(String nombre, String edad, String correoElec,String telefono,String nivelIngles ,String[] listaEstudios, String[] competencias,
            String[] listaTrabajos) {
        this.nombre = nombre;
        this.edad = edad;
        this.correoElec = correoElec;
        this.telefono = telefono;
        this.nivelIngles = nivelIngles;
        this.listaEstudios = listaEstudios;
        this.listaTrabajos = listaTrabajos;
        this.competencias = competencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String[] getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(String[] listaEstudios) {
        this.listaEstudios = listaEstudios;
    }

    public String[] getListaTrabajos() {
        return listaTrabajos;
    }

    public void setListaTrabajos(String[] listaTrabajos) {
        this.listaTrabajos = listaTrabajos;
    }

    public String getNivelIngles() {
        return nivelIngles;
    }

    public void setNivelIngles(String nivelIngles) {
        this.nivelIngles = nivelIngles;
    }

    public String[] getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String[] competencias) {
        this.competencias = competencias;
    }

    @Override
    public String toString() {
        return "KevinMorenoCV [nombre=" + nombre + ", edad=" + edad + ", correoElec=" + correoElec + ", telefono="
                + telefono + ", nivelIngles=" + nivelIngles + ", competencias=" + Arrays.toString(competencias)
                + ", listaEstudios=" + Arrays.toString(listaEstudios) + ", listaTrabajos="
                + Arrays.toString(listaTrabajos) + "]";
    }

   

}
