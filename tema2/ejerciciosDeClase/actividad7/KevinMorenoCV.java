package tema2.ejerciciosDeClase.actividad7;

import java.util.Arrays;

public class KevinMorenoCV {
    
    private String nombre;
    private String edad;
    private String correoElec;
    private String[] listaEstudios;
    private String[] listaTrabajos;

    public KevinMorenoCV(String nombre, String edad, String correoElec, String[] listaEstudios,
            String[] listaTrabajos) {
        this.nombre = nombre;
        this.edad = edad;
        this.correoElec = correoElec;
        this.listaEstudios = listaEstudios;
        this.listaTrabajos = listaTrabajos;
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

    @Override
    public String toString() {
        return "KevinMorenoCV [nombre=" + nombre + ", edad=" + edad + ", correoElec=" + correoElec + ", listaEstudios="
                + Arrays.toString(listaEstudios) + ", listaTrabajos=" + Arrays.toString(listaTrabajos) + "]";
    }
    

}
