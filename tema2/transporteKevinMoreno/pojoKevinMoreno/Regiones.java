package tema2.transporteKevinMoreno.pojoKevinMoreno;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Regiones")
@XmlAccessorType(XmlAccessType.FIELD)

public class Regiones {

    @XmlElement(name = "Region")
    private ArrayList<Region>listaRegiones;

    public Regiones(){
        
    }

    public Regiones(ArrayList<Region>listaRegiones){
        this.listaRegiones = listaRegiones;
    }

    public ArrayList<Region> getListaRegiones() {
        return listaRegiones;
    }

    public Region existeRegion(String nombre){
        for (Region region : listaRegiones) {
            if (region.getNombreRegion().equalsIgnoreCase(nombre)) {
                return region;
            }
        }
        return null;
    }

    public void eliminarRegion(String nombreRegion){
        Iterator<Region> it = listaRegiones.iterator();

        while (it.hasNext()) {
            if (it.next().getNombreRegion().equalsIgnoreCase(nombreRegion)) {
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Regiones [listaRegiones=" + listaRegiones + "]";
    }

}
