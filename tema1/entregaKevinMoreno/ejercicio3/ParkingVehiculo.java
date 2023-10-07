package tema1.entregaKevinMoreno.ejercicio3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;


public class ParkingVehiculo implements Parking{

    private String direccion;
    private ArrayList<Vehiculo> listaVehiculos;
    private int plazasActuales;

    private LocalDateTime tiempoEstacionadoInicio;
    private LocalDateTime tiempoEstacionadoFin;
    private static final double PRECIOMINUTO = 0.0425;
    private static final int MAXPLAZAS = 100; 

    public ParkingVehiculo(String direccion) {
        this.direccion = direccion;
        listaVehiculos = new ArrayList<Vehiculo>();
        plazasActuales = 0;
    }

    @Override
    public boolean hayPlaza() {
        if(plazasActuales<MAXPLAZAS){
            return true;
        }
        return false;
    }

    @Override
    public void aparcaCoche(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
        plazasActuales++;
        vehiculo.setFechaInicio(LocalDateTime.now());
    }

    @Override
    public void sacaCoche(Vehiculo vehiculo) {
       Iterator<Vehiculo> it = listaVehiculos.iterator();
       while (it.hasNext()) {
            if (it.next().equals(vehiculo)) {
                vehiculo.setFechaFin(LocalDateTime.now());
                it.remove();
                
            }
       }
    }

    //le sume 3 minutos a la  variable que del tiempoEstacionadoFin para que en la resta no de 0 min p 1 min
    // ya que pilla la hora de la pc al momento que se aparca y al momento de salida
    //para que al menos calcule algo pos le aumente 3 min  
    private int calcularMinutos(LocalDateTime timeStart, LocalDateTime timEnd){
        int minStart = (timeStart.getHour()*60)+timeStart.getMinute();
        int minEnd = ((timEnd.getHour()*60)+3)+timEnd.getMinute();
        return minEnd -minStart;
    }

    @Override
    public double getFactura(Vehiculo vehiculo) {
        int minutos=calcularMinutos(vehiculo.getFechaInicio(), vehiculo.getFechaFin());
        return minutos*PRECIOMINUTO;
    }

    @Override
    public String toString() {
        return "ParkingVehiculo [direccion=" + direccion + ", listaVehiculos=" + listaVehiculos + ", plazasActuales="
                + plazasActuales + ", tiempoEstacionadoInicio=" + tiempoEstacionadoInicio + ", tiempoEstacionadoFin="
                + tiempoEstacionadoFin + "]";
    }

    
    
}
