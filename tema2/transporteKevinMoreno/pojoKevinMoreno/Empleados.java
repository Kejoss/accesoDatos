package tema2.transporteKevinMoreno.pojoKevinMoreno;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Empleados")
@XmlAccessorType(XmlAccessType.FIELD)

public class Empleados {

    @XmlElement(name = "Empleado")
    private ArrayList<Empleado> listaEmpleado;

    public Empleados(){
        
    }

    public Empleados(ArrayList<Empleado> listaEmpleado){
        this.listaEmpleado = listaEmpleado;
    }

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public Empleado existeEmpleaado(String dni){
        for (Empleado empleado : listaEmpleado) {
            if (empleado.getDni().equalsIgnoreCase(dni)) {
                return empleado;
            }
        }
        return null;
    }

    public void borrarEmpleado(Empleado empleado){
        Iterator<Empleado> it = listaEmpleado.iterator();

        while (it.hasNext()) {
            if (it.next().equals(empleado)) {
                it.remove();
            }
        }
    }

    public int sacarCantidadDeEmpleadosLocalidad(String localidad){
        int vuelta =0;
        for (Empleado empleado : listaEmpleado) {
            if (empleado.getLugarNacimiento().equalsIgnoreCase(localidad)) {
                vuelta++;
            }
        }
        return vuelta;
    }

    @Override
    public String toString() {
        return "Empleados [listaEmpleado=" + listaEmpleado + "]";
    }

}
