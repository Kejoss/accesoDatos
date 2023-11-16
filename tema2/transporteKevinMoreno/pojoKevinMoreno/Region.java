package tema2.transporteKevinMoreno.pojoKevinMoreno;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Region")
@XmlType(propOrder ={"codRegion", "nombre"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Region {
    
    @XmlAttribute(name = "codRegion")
    private String codRegion;
    @XmlAttribute(name = "nombre")
    private String nombre;

    public Region(){
        
    }

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

    public String getNombreRegion() {
        return nombre;
    }

    public void setNombreRegion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Region [codRegion=" + codRegion + ", nombre=" + nombre + "]";
    }

}
