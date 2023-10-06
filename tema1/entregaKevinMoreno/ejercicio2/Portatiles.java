package tema1.entregaKevinMoreno.ejercicio2;

import java.util.ArrayList;

public class Portatiles extends Ordenadores {

    private int peso;

    public Portatiles(String codigo, int ram, String cpu, int peso) {
        super(codigo, ram, cpu);
        this.peso = peso;
    }

    @Override
    public ArrayList<String> getCaracteristicas() {
       ArrayList<String> resultado = new ArrayList<String>();

        resultado.add("Codigo: "+codigo);
        resultado.add("CPU: "+cpu);
        resultado.add("RAM: "+Integer.toString(ram));
        resultado.add("Peso: "+Integer.toString(peso));

        return resultado;
    }

    @Override
    public String toString() {
        return super.toString()+" Portatiles [peso=" + peso + "]";
    }

    
    
}
