package tema2.ejerciciosDeClase;

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
        File file = new File("tema2/ejerciciosDeClase/agenda.txt");
        ArrayList<String> listameteorologica = new ArrayList<String>();
        try {
            if (file.exists()) {
            int vuelta = 0;
            BufferedReader bf = new BufferedReader(new FileReader(file));
            while (bf.readLine()!=null) {
                if (vuelta!=0) {
                  listameteorologica.add(bf.readLine());  
                }
                vuelta++;
            }
            bf.close();   
            }

        } catch (Exception e) {
            // TODO: handle exception
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
                    registrarTemperatura(listameteorologica);

                    break;
                case 2:
                    


                    break;
                case 3:
                    
                    break;
            
                default:
                    break;
            }

        }


    } 
    
    private static void registrarTemperatura(ArrayList<String>listameteorologica){

        File file = new File("tema2/ejerciciosDeClase/agenda.txt");
        try {
            
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            for (String string : listameteorologica) {
                br.write(string);
            }
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

}
