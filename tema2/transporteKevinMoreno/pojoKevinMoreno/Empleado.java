package tema2.transporteKevinMoreno.pojoKevinMoreno;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Empleado")
@XmlType(propOrder ={"id","dni", "nombre","fechaNac","telefono","salario","lugarNacimiento"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Empleado {
    
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "dni") 
    private String dni;
    @XmlElement(name = "nombre")
    private String nombre;
    @XmlElement(name = "fechaNac")
    private String fechaNac;
    @XmlElement(name = "telefono")
    private String telefono;
    @XmlElement(name = "salario")
    private double salario;
    @XmlElement(name="lugarNacimiento")
    private String lugarNacimiento;

    public Empleado(){
        
    }

    public Empleado( String id,String dni, String nombre, String fechaNac, String telefono, double salario, String lugarNacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.salario = salario;
        this.lugarNacimiento = lugarNacimiento;
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

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", telefono="
                + telefono + ", salario=" + salario + " Lugar de nacimineto= "+lugarNacimiento +"]";
    }    
    
}
