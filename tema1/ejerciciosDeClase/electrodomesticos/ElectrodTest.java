package electrodomesticos;

import java.util.ArrayList;

public class ElectrodTest {
    
    public static void main(String[] args) {
        
        ArrayList<Electrodomestico> listaElectrodomesticos = new ArrayList<Electrodomestico>();

        Electrodomestico tv = new Televisor("LG", "mnc-5422", 300, 60);
        Electrodomestico cafetera = new Electrodomestico("Sansumg", "754-txtsa", 30, "blanco", 40, 2, 7, 0.50);
        Electrodomestico nevera = new Nevera("LG", "NTFS-5622", 400, 30, 50, 12);
        Electrodomestico aspiradora = new Electrodomestico();

        listaElectrodomesticos.add(nevera);
        listaElectrodomesticos.add(tv);
        listaElectrodomesticos.add(cafetera);
        listaElectrodomesticos.add(aspiradora);

        int suma=0;
        for (Electrodomestico electrodomestico : listaElectrodomesticos) {
            System.out.println("Marca: "+electrodomestico.getMarca()+" modelo: "+electrodomestico.getModelo()+" consumo anual: "+electrodomestico.consumoAnual());
            suma+=electrodomestico.consumoAnual();
        }
        System.out.println("Consumo total: "+suma);
    }

}
