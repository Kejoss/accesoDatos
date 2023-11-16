package tema2.transporteKevinMoreno.pojoKevinMoreno;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Provincia")
@XmlType(propOrder ={"codProvincia", "nombre", "region"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Provincia {
    
    @XmlAttribute(name = "codProvincia")
    private String codProvincia;
    @XmlAttribute(name = "nombre")
    private String nombre;
    @XmlAttribute(name="region")
    private String region;

    public Provincia(){
        
    }

    public Provincia(String codProvincia, String nombreProvincia, String region){
        this.nombre =nombreProvincia;
        this.codProvincia = codProvincia;
        this.region = region;
    }
    
    public String getNombreProvincia() {
        return nombre;
    }

    public void setNombreProvincia(String nombre) {
        this.nombre = nombre;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Provincia [codProvincia=" + codProvincia + ", nombre=" + nombre +" Region a la que pertenece= "+region+ "]";
    }    

}
