package tema2.transporteKevinMoreno.pojoKevinMoreno;

public class Region {
    
    private String codRegion;
    private String nombre;
    
    public Region(String codRegion, String nombre) {
        this.codRegion = codRegion;
        this.nombre = nombre;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Region [codRegion=" + codRegion + ", nombre=" + nombre + "]";
    }

}
