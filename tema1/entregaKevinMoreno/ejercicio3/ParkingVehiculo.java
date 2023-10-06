package tema1.entregaKevinMoreno.ejercicio3;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;


public class ParkingVehiculo implements Parking{

    private String direccion;
    private ArrayList<Vehiculo> listaVehiculos;
    private int plazasActuales;

    private int tiempoEstacionado;
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
        tiempoEstacionado = LocalDateTime.now().getMinute();
    }

    @Override
    public void sacaCoche(Vehiculo vehiculo) {
       Iterator<Vehiculo> it = listaVehiculos.iterator();
       while (it.hasNext()) {
            if (it.next().equals(vehiculo)) {
                it.remove();
            }
       }
    }

    @Override
    public double getFactura(Vehiculo vehiculo) {
       for (Vehiculo vehiculo2 : listaVehiculos) {
            if (vehiculo.equals(vehiculo2)) {
                
            }
       }
        return 0;
    }
    
}
