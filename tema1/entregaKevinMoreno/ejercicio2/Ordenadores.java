package tema1.entregaKevinMoreno.ejercicio2;

import java.util.ArrayList;

public abstract class Ordenadores {
    
    protected String codigo;
    protected int ram;
    protected String cpu;

    public Ordenadores(String codigo, int ram, String cpu){
        this.codigo = codigo;
        this.ram = ram;
        this.cpu = cpu;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public abstract ArrayList<String> getCaracteristicas();

    @Override
    public String toString() {
        return "Ordenadores [codigo=" + codigo + ", ram=" + ram + ", cpu=" + cpu + "]";
    }

    

}
