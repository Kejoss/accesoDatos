package tema2.transporteKevinMoreno.pojoKevinMoreno;

public class Empleado {
    
    private String id;
    private String dni;
    private String nombre;
    private String fechaNac;
    private String telefono;
    private double salario;

    public Empleado(String id, String dni, String nombre, String fechaNac, String telefono, double salario) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", telefono="
                + telefono + ", salario=" + salario + "]";
    }    
    
}
