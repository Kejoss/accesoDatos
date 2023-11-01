package tema2.ejerciciosDeClase.actividad5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Actividad35 {
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Registro> listameteorologica = new ArrayList<Registro>();
        try {
            FileInputStream file = new FileInputStream("tema2/archivos/meteo.dat");
            ObjectInputStream ois = new ObjectInputStream(file); 
            Registro registro;

            while (ois.available()!=-1) {
                
                registro = (Registro)ois.readObject();
                listameteorologica.add(registro);
            }
            ois.close();


        } catch (Exception e) {

        }

        for (Registro registro : listameteorologica) {
            System.out.println(registro);
        }

        System.out.println("¿Que operacion quieres hacer?");
        System.out.println("1- Registrar nueva temperatura, 2-Mostar historial de registros, 3-Mostar media de temperatura, 4-salir");
        int operador;
        while ((operador = sc.nextInt())!=4) {
            
            switch (operador) {
                case 1:
                    System.out.println("Ingresa el nombre de la ciudad");
                    String ciudad = sc.next();
                    System.out.println("Ingresa la fecha: AA-MM-DD");
                    String fecha =sc.next();
                    System.out.println("Temperatura Maxima");
                    String temMax = sc.next();
                    System.out.println("Temperatura minima");
                    String temMin = sc.next();
                    
                    Registro registro = new Registro(ciudad, fecha, temMax, temMin);
                    listameteorologica.add(registro);
                    registrarTemperatura(listameteorologica);

                    break;
                case 2:

                    System.out.println("Ingresa el nombre de la ciudad");
                    String ciudadBus = sc.next();

                    for (Registro registroShow: listameteorologica) {
                        if (registroShow.getCiudad().equalsIgnoreCase(ciudadBus)) {
                            System.out.println(registroShow);
                        }
                    }

                    break;
                case 3:
                    
                    System.out.println("Ingresa la ciudad ");
                    String ciudadMedia= sc.next();
                    int mediaMin=0, mediaMax = 0, vuelta=0;
                    for (Registro registroMedia : listameteorologica) {
                        
                        if (registroMedia.getCiudad().equalsIgnoreCase(ciudadMedia)) {
                            mediaMax+=Integer.parseInt(registroMedia.getTempMax());
                            mediaMin+=Integer.parseInt(registroMedia.getTempMin());
                            vuelta++;
                        }
                    }

                    System.out.println("Media de temperatura minima: "+(mediaMin/vuelta));
                    System.out.println("Media de temperatura maxima: "+(mediaMax/vuelta));
                    System.out.println("Media de temperatura general: "+(((mediaMin/vuelta)+(mediaMax/vuelta))/2));

                  break;
            
                default:
                    break;
            }
            System.out.println("\n 1- Registrar nueva temperatura, 2-Mostar historial de registros, 3-Mostar media de temperatura, 4-salir");

        }

        sc.close();
    } 
    
    private static void registrarTemperatura(ArrayList<Registro> listaregistro){

        try {
            
            FileOutputStream fos = new FileOutputStream("tema2/archivos/meteo.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);          
            
            for (Registro registro2 : listaregistro) {
                oos.writeObject(registro2);
            }
            oos.close();

        } catch (Exception e) {
        }

    }
    
    

}
