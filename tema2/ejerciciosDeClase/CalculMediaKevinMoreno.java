package tema2.ejerciciosDeClase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CalculMediaKevinMoreno {
    
    public static void main(String[] args) {
        
        File file = new File("tema2/archivos/jugadores.txt");
        
        try {
            
            if (file.exists()) {
                
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                double media=0;
                double estatura=0;
                int numLinea =0;

                while ((linea=br.readLine())!=null) {
                    media += Integer.parseInt(linea.split(" ")[1]);
                    estatura += Double.parseDouble(linea.split(" ")[2]);
                    numLinea ++;
                }
                br.close();

                System.out.println("La media de edad: "+media/numLinea); 
                System.out.println("La media de estatura es: "+estatura/numLinea) ;
                
                
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
