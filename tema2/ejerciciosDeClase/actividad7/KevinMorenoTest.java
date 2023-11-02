package tema2.ejerciciosDeClase.actividad7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class KevinMorenoTest {
    
    public static void main(String[] args) {
        
        Path path = Paths.get("tema2/jsonKevinMoreno/KevinMoreno.json");

        try {
            
            //Convierto en String la lectura del json
            String json = Files.readString(path);

            //Aqui creo el objeto para metrle los datos
            KevinMorenoCV curriculum = new Gson().fromJson(json, KevinMorenoCV.class);

            System.out.println(curriculum);

            curriculum.setNivelIngles("B2");

            //Creo el gson para que se escriba el objeto como json
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().create();

            File file = path.toFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            //Aqui escribo el objeto a json            
            bw.write(gson.toJson(curriculum));
            bw.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
