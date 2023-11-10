package tema2.transporteKevinMoreno.pojoKevinMoreno;

public class Localidad {
    
    private String nombre;
    private String codLocalidad;
    
    public Localidad(String nombre, String codLocalidad) {
        this.nombre = nombre;
        this.codLocalidad = codLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(String codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    @Override
    public String toString() {
        return "Localidad [nombre=" + nombre + ", codLocalidad=" + codLocalidad + "]";
    }

}
