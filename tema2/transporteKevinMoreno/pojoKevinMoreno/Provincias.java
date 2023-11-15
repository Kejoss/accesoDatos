package tema2.transporteKevinMoreno.pojoKevinMoreno;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Provincias")
@XmlType(propOrder ={"Provincia"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Provincias {

    @XmlElement(name = "Provincia")
    private ArrayList<Provincia>listaProvincias;

    public Provincias(ArrayList<Provincia>listaProvincias){
        this.listaProvincias = listaProvincias;
    }

    public ArrayList<Provincia> getListaProvincias() {
        return listaProvincias;
    }

    public Provincia existeProvincia(String nombre){
        for (Provincia provincia : listaProvincias) {
            if (provincia.getNombreProvincia().equalsIgnoreCase(nombre)) {
                return provincia;
            }
        }

        return null;
    }
    
    public void borrarProvincia(String nombreProvincia){
        Iterator<Provincia>it = listaProvincias.iterator();

        while (it.hasNext()) {
            if (it.next().getNombreProvincia().equalsIgnoreCase(nombreProvincia)) {
                it.remove();
            }
        }
    }

    public int cantidadProvinciasEnUnaRegion(String region){
        int cantidad = 0;
        for (Provincia provincia : listaProvincias) {
            if (provincia.getRegion().equalsIgnoreCase(region)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    @Override
    public String toString() {
        return "Provincias [listaProvincias=" + listaProvincias + "]";
    }
    
}
