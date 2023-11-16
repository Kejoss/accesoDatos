package tema2.ejercicios.actividad3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Actividad3 {
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        File file = new File("tema2/archivos/meteo.txt");
        ArrayList<String> listameteorologica = new ArrayList<String>();
        try {
            if (file.exists()) {
            int vuelta = 0;
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea=bf.readLine())!=null) {
                if (vuelta!=0) {
                  listameteorologica.add(linea);  
                }
                vuelta++;
            }
            bf.close();   
            }

        } catch (Exception e) {
            e.printStackTrace();
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

                    listameteorologica.add(ciudad+" "+fecha+" "+temMax+" "+temMin);
                    registrarTemperatura(ciudad+" "+fecha+" "+temMax+" "+temMin);

                    break;
                case 2:

                    System.out.println("Ingresa el nombre de la ciudad");
                    String ciudadBus = sc.next();

                    for (String string : listameteorologica) {
                        if (string.split(" ")[0].equalsIgnoreCase(ciudadBus)) {
                            System.out.println(string);
                        }
                    }

                    break;
                case 3:
                    
                    System.out.println("Ingresa la ciudad ");
                    String ciudadMedia= sc.next();
                    int mediaMin=0, mediaMax = 0, vuelta=0;
                    for (String string : listameteorologica) {
                        
                        if (string.split(" ")[0].equalsIgnoreCase(ciudadMedia)) {
                            mediaMax+=Integer.parseInt(string.split(" ")[2]);
                            mediaMin+=Integer.parseInt(string.split(" ")[3]);
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
    
    private static void registrarTemperatura(String linea){

        File file = new File("tema2/archivos/meteo.txt");
        try {
            
            BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
            br.newLine();
            br.write(linea);
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

}
