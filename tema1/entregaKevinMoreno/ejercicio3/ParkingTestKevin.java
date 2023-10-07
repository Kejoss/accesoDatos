package tema1.entregaKevinMoreno.ejercicio3;

public class ParkingTestKevin {
    
    public static void main(String[] args) {
        
        Vehiculo vehiculo1 = new Vehiculo("1234-ABC");
        Vehiculo vehiculo2 = new Vehiculo("4568-XSD");
        Vehiculo vehiculo3 = new Vehiculo("5321-SAS");
        Vehiculo vehiculo4 = new Vehiculo("5321-AZX");
        Vehiculo vehiculo5 = new Vehiculo("2351-AXd");

        ParkingVehiculo pv = new ParkingVehiculo("Casa de Adham");

        pv.aparcaCoche(vehiculo1);
        pv.aparcaCoche(vehiculo2);
        pv.aparcaCoche(vehiculo3);
        pv.aparcaCoche(vehiculo4);
        pv.aparcaCoche(vehiculo5);

        pv.sacaCoche(vehiculo5);
        pv.sacaCoche(vehiculo4);
        pv.sacaCoche(vehiculo3);
        pv.sacaCoche(vehiculo2);
        pv.sacaCoche(vehiculo1);

        System.out.println(pv.getFactura(vehiculo5));
        System.out.println(pv.getFactura(vehiculo4));
        System.out.println(pv.getFactura(vehiculo3));
        System.out.println(pv.getFactura(vehiculo2));
        System.out.println(pv.getFactura(vehiculo1));

    }

}
