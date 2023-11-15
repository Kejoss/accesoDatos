package tema2.transporteKevinMoreno.pojoKevinMoreno;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Region")
@XmlAccessorType(XmlAccessType.FIELD)

public class Region {
    
    @XmlAttribute(name = "codRegion")
    private String codRegion;
    @XmlAttribute(name = "nombre")
    private String nombreRegion;

    public Region(String codRegion, String nombre) {
        this.codRegion = codRegion;
        this.nombreRegion = nombre;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombre) {
        this.nombreRegion = nombre;
    }

    @Override
    public String toString() {
        return "Region [codRegion=" + codRegion + ", nombre=" + nombreRegion + "]";
    }

}
