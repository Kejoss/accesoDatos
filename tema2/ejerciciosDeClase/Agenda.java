package tema2.ejerciciosDeClase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Agenda {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        File file = new File("tema2/archivos/agenda.txt");
        ArrayList<String> listaContactos = new ArrayList<String>(20);
        try {
            
            if (file.exists()) {
                
                String Linea;
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((Linea = br.readLine())!= null) {
                    listaContactos.add(Linea);
                } 

            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        int operador;
        System.out.println("Que operacion quieres realizar");
        System.out.println("1- Nuevo Contacto, 2-Buscar por nombe, 3-Mostar todos, 4-salir");
        while ((operador = sc.nextInt())!=4) {
            
            switch (operador) {
                case 1:
                    
                    System.out.println("ingresa el nombre");
                    String nombre = sc.next();
                    System.out.println("Ingresa el numero de telefono");
                    String telefono = sc.next();

                    if (listaContactos.size()<20) {
                        if (existeContacto(nombre+" "+telefono, listaContactos)) {
                            System.out.println("El nombre del contacto ya existe");
                        }else{
                            anniadirContacto(nombre+" "+telefono);
                            listaContactos.add(nombre+" "+telefono);
                        }
                    }else{
                        System.out.println("No hay espacio para agregar otro contacto");
                    }

                    break;
                case 2:
                    System.out.println("Ingresa lo que quieres buscar");
                    String prefijo = sc.next();
                    for (String string : listaContactos) {
                        if (string.startsWith(prefijo)) {
                            System.out.println(string);
                        }
                    }

                    break;
                case 3:
                    Collections.sort(listaContactos);
                    for (String string : listaContactos) {
                        System.out.println(string);
                    }    

                    break;
                    
                default:
                    System.out.println("numero invalido");
                    break;
            }

        System.out.println("\n"+"Que operacion quieres realizar");
        System.out.println("1- Nuevo Contacto, 2-Buscar por nombe, 3-Mostar todos, 4-salir");

        }
        sc.close();
        System.out.println("Fin del programa");
    }

    private static boolean existeContacto(String contacto, ArrayList<String> listaContactos){
        
        for (String string : listaContactos) {
            
            if (string.split(" ")[0].equalsIgnoreCase(string)) {
                return true;
            }

        }
        
        return false;
    }

    private static void anniadirContacto(String contacto){
        File file = new File("tema2/archivos/agenda.txt");
        BufferedWriter bw;
        try {
           
            if (file.exists()) {
                
                bw = new BufferedWriter(new FileWriter(file,true));
                bw.newLine();
                bw.write(contacto);
                bw.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
