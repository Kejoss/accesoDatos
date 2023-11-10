package tema2.transporteKevinMoreno.pojoKevinMoreno;

public class Provincia {
    
    private String codProvincia;
    private String nombre;

    public Provincia(String codProvincia, String nombre) {
        this.codProvincia = codProvincia;
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    @Override
    public String toString() {
        return "Provincia [codProvincia=" + codProvincia + ", nombre=" + nombre + "]";
    }    

}
