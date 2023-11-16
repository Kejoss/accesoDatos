package tema2.ejercicios.actividad6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        ClienteSer cliente;
        ArrayList<ClienteSer> listaclientes = new ArrayList<ClienteSer>();
        try {

            FileInputStream fis = new FileInputStream("tema2/archivos/clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (ois.available()!=-1) {
                
                cliente = (ClienteSer)ois.readObject();
                listaclientes.add(cliente);

            }
            ois.close();

        } catch (Exception e) {
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
                    
                    cliente = new ClienteSer(dni, nombre, fechaNac, saldo);
                    listaclientes.add(cliente);
                    importarArray(listaclientes);

                    break;

                case 2:
                    
                    System.out.println("Ingresa el DNI del cliente para borrar");
                    String dniDel = sc.next();
                    
                    Iterator<ClienteSer> it = listaclientes.iterator();
                    while (it.hasNext()) {
                        
                        if (it.next().getDni().equalsIgnoreCase(dniDel)) {
                            it.remove();
                            importarArray(listaclientes);
                        }
                    }

                    break;

                case 3:
            
                    Collections.sort(listaclientes);

                    for (ClienteSer clientes : listaclientes) {
                        System.out.println(clientes + " edad: "+calcularEdad(clientes));
                    }

                    break;

                case 4:
                    
                    int suma = 0;
                    int vuelta =0;

                    for (ClienteSer clientes : listaclientes) {
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

    private static void importarArray(ArrayList<ClienteSer> listacliente){

        try {

            FileOutputStream fis = new FileOutputStream("tema2/archivos/clientes.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fis);

            for (ClienteSer clienteSer : listacliente) {
                oos.writeObject(clienteSer);
            }
            oos.close();
        } catch (Exception e) {
        }
    }


    private static int calcularEdad(ClienteSer cliente){

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
