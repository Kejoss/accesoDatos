package tema2.transporteKevinMoreno.pojoKevinMoreno;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "localidades")
@XmlAccessorType(XmlAccessType.FIELD)

public class Localidades {
    
    @XmlElement(name = "localidad")
    private ArrayList<Localidad>listaLocalidades;

    public Localidades(){
        
    }

    public Localidades(ArrayList<Localidad>listaLocalidades){
        this.listaLocalidades = listaLocalidades;
    }

    public ArrayList<Localidad> getListaLocalidades() {
        return listaLocalidades;
    }

    public Localidad existeLocalidades(String nombre){
        for (Localidad localidad : listaLocalidades) {
            if (localidad.getNombre().equalsIgnoreCase(nombre)) {
                return localidad;
            }
        }
        return null;
    }

    public void borrarLocalidad(String localidad){

        Iterator<Localidad> it = listaLocalidades.iterator();
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(localidad)) {
                it.remove();
            }
        }
    }

    public int cantidadLocalidadesEnUnaProvincia(String nombreProvincia){
        int cantidad = 0;
        for (Localidad localidad : listaLocalidades) {
            if (localidad.getProvincia().equalsIgnoreCase(nombreProvincia)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    @Override
    public String toString() {
        return "Localidades [listaLocalidades=" + listaLocalidades + "]";
    }

}
