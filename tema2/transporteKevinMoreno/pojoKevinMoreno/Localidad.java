package tema2.transporteKevinMoreno.pojoKevinMoreno;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "localidad")
@XmlAccessorType(XmlAccessType.FIELD)

public class Localidad {
    
    @XmlAttribute(name="nombre")
    private String nombre;
    @XmlAttribute(name="codLocalidad")
    private String codLocalidad;
    @XmlAttribute(name="provincia")
    private String provincia;

    public Localidad(String nombre, String codLocalidad, String provincia){
        this.codLocalidad = codLocalidad;
        this.nombre = nombre;
        this.provincia =provincia;
    }

    public Localidad(String nombre, String codLocalidad, Provincia provincia){
        this.codLocalidad = codLocalidad;
        this.nombre = nombre;
        this.provincia = provincia.getNombreProvincia();
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Localidad [nombre=" + nombre + ", codLocalidad=" + codLocalidad +" provincia a la que pertenece= " +provincia+"]";
    }

}
