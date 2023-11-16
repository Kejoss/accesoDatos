package tema2.ejercicios.actividad4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        File file = new File("tema2/archivos/clientes.txt");
        ArrayList<Clientes> listaclientes = new ArrayList<Clientes>();
        Clientes cliente;
        try {
            
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                while ((linea = br.readLine())!= null) {
                    cliente = new Clientes(linea.split(" ")[0], linea.split(" ")[1], linea.split(" ")[2], Double.parseDouble(linea.split(" ")[3]));
                    listaclientes.add(cliente);
                }
                br.close(); 
            }else{
                System.out.println("No existe el archivo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("1- Alta de Cliente \n2- Baja cliente \n3- Listar clientes \n4- saldo medio de clientes \n5- Salir");
        int opr;
        while ((opr = sc.nextInt())!=5) {
            System.out.println("");
            switch (opr) {
                case 1:

                    System.out.println("Ingresa el DNI");
                    String dni = sc.next();
                    System.out.println("ingresa el nombre");
                    String nombre  = sc.next();
                    System.out.println("Ingresa la fecha de nacimiento (AA-MM-DD)");
                    String fechaNac = sc.next();
                    System.out.println("Ingresa el saldo");
                    double saldo = sc.nextDouble();
                    
                    cliente = new Clientes(dni, nombre, fechaNac, saldo);
                    listaclientes.add(cliente);
                    addCliente(cliente);

                    break;

                case 2:
                    
                    System.out.println("Ingresa el DNI del cliente para borrar");
                    String dniDel = sc.next();
                    
                    Iterator<Clientes> it = listaclientes.iterator();
                    while (it.hasNext()) {
                        
                        if (it.next().getDni().equalsIgnoreCase(dniDel)) {
                            it.remove();
                            eliminarCliente(listaclientes);
                        }
                    }

                    break;

                case 3:
            
                    Collections.sort(listaclientes);;

                    for (Clientes clientes : listaclientes) {
                        System.out.println(clientes + " edad: "+calcularEdad(clientes));
                    }

                    break;

                case 4:
                    
                    int suma = 0;
                    int vuelta =0;

                    for (Clientes clientes : listaclientes) {
                        suma +=clientes.getSaldo();
                        vuelta++;
                    }

                    System.out.println("La media de saldo de todos los clientes es: "+(suma/vuelta));

                    break;
            
                default:
                System.out.println("Numero invalido");
                    break;
            }

            System.out.println("\n1- Alta de Cliente \n2- Baja cliente \n3- Listar clientes \n4- saldo medio de clientes \n5- Salir");
        }

        sc.close();
    }

    private static void addCliente(Clientes cliente){
        File file = new File("tema2/archivos/clientes.txt");

        try {
            if (file.exists()) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.newLine();
                bw.write(cliente.getDni()+" "+cliente.getNombre()+" "+cliente.getFechaNac()+" "+cliente.getSaldo());
                bw.close();
            }else{
                System.out.println("No existe el archivo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void eliminarCliente(ArrayList<Clientes> listaClientes){

        File file = new File("tema2/archivos/clientes.txt");
        try {
            
            if (file.exists()) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (Clientes clientes : listaClientes) {
                    bw.write(clientes.getDni()+" "+clientes.getNombre()+" "+clientes.getFechaNac()+" "+clientes.getSaldo());
                    bw.newLine();
                }
                bw.close();

            }else{
                System.out.println("El archivo no existe");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static int calcularEdad(Clientes cliente){

        int dia= Integer.parseInt(cliente.getFechaNac().split("-")[2]);
        int mes= Integer.parseInt(cliente.getFechaNac().split("-")[1]);
        int anio= Integer.parseInt(cliente.getFechaNac().split("-")[0]);

        dia = LocalDate.now().getDayOfMonth()-dia;
        mes = LocalDate.now().getMonthValue()-mes;
        anio = LocalDate.now().getYear()-anio;

        if (mes ==0) {
            
            if (dia >=0) {
                return anio;
            }else {
                return anio-1;
            }
        }else{
            
            if (mes>0) {
                return anio;
            }else{
                return anio-1;
            }

        }
    }


}
