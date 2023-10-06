package tema1.entregaKevinMoreno.ejercicio2;

import java.util.ArrayList;

public class OrdenadorTestKevin {
    
    public static void main(String[] args) {
        
        Ordenadores portatil = new Portatiles("5030X", 16, "intel core i5 10400F", 30);
        Ordenadores pcSobreMesa = new Sobremesa("32140B", 32, "Intel core i9 13500KF", "Sin tarjeta grafica");

        ArrayList<String> componentesPortatil = portatil.getCaracteristicas();
        ArrayList<String> componentesSobreMesa = pcSobreMesa.getCaracteristicas();

        System.out.println("Componentes de la portatil: "+componentesPortatil);
        System.out.println("Componentes de la pc sobremesa: "+componentesSobreMesa);

    }

}
