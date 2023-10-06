package tema1.entregaKevinMoreno.ejercicio3;

public class ParkingVehiculo implements Parking{

    private String direccion;
    private int plazasActuales;

    private static final double PRECIOMINUTO = 0.0425;
    private static final int MAXPLAZAS = 100; 

    public ParkingVehiculo(String direccion) {
        this.direccion = direccion;
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
    public void aparcaCoche() {
        
    }

    @Override
    public void sacaCoche() {
       
    }

    @Override
    public double getFactura() {
       return 0;
    }
    
}
