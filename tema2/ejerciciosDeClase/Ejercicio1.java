package tema2.ejerciciosDeClase;

import java.io.File;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        File directorio = new File("tema2");

        try {
            if (directorio.exists() && directorio.isDirectory()) {

                String[] contenido = new String[directorio.listFiles().length];
                File contenidos;

                int numero = 1;
                int contador =0;
                while (numero==1) {
                    
                    if (directorio.listFiles()[contador]!= null) {
                     System.out.println(directorio.listFiles()[contador].getName());  
                     contenido[contador] = directorio.listFiles()[contador].getName();
                    }

                }




                for (int i = 0; i < directorio.listFiles().length; i++) {
                    System.out.println(directorio.listFiles()[i].getName());  
                     contenido[i] = directorio.listFiles()[i].getName();
                }


                for (int i = 0; i < contenido.length; i++) {
                    contenidos = new File(contenido[i]);
                    contenidos.listFiles();
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private String[] listarContenido(File file){
        String[] contenido = new  
    }

}   
