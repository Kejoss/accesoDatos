package tema1.entregaKevinMoreno.ejercicio2;

import java.util.ArrayList;

public class Sobremesa extends Ordenadores {
    
     private String descripcion;

    public Sobremesa(String codigo, int ram, String cpu, String descripcion) {
        super(codigo, ram, cpu);
        this.descripcion =  descripcion;
    }

    public ArrayList<String> getCaracteristicas() {
        ArrayList<String> resultado = new ArrayList<String>();

        resultado.add("Codigo: "+codigo);
        resultado.add("CPU: "+cpu);
        resultado.add("RAM: "+Integer.toString(ram));
        resultado.add("Descripcion: "+descripcion);

        return resultado;
    }

    @Override
    public String toString() {
        return super.toString()+" Sobremesa [descripcion=" + descripcion + "]";
    } 

    
}
