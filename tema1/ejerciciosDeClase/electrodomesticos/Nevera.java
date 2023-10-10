package electrodomesticos;

public class Nevera extends Electrodomestico {
    
    private int capacidadFrigorifico;
    private int capacidadCongelador;
    private int sonoridad;
    
    public Nevera() {
        capacidadCongelador = 60;
        capacidadFrigorifico = 80;
    }

    public Nevera(String marca, String modelo, double precio, int capacidadCongelador, int capacidadFrigorifico, int sonoridad) {
        super(marca, modelo,precio);
        this.capacidadCongelador = capacidadCongelador;
        this.capacidadFrigorifico = capacidadFrigorifico;
        this.sonoridad = sonoridad;

    }

    public double consumoAnual() {
        if (capacidadFrigorifico>300 || capacidadCongelador>200) {
            return super.consumoAnual()+50;
        }
        return super.consumoAnual();
    }

    public int getCapacidadFrigorifico() {
        return capacidadFrigorifico;
    }

    public void setCapacidadFrigorifico(int capacidadFrigorifico) {
        this.capacidadFrigorifico = capacidadFrigorifico;
    }

    public int getCapacidadCongelador() {
        return capacidadCongelador;
    }

    public void setCapacidadCongelador(int capacidadCongelador) {
        this.capacidadCongelador = capacidadCongelador;
    }

    public int getSonoridad() {
        return sonoridad;
    }

    public void setSonoridad(int sonoridad) {
        this.sonoridad = sonoridad;
    }

    @Override
    public String toString() {
        return super.toString()+ " Nevera [capacidadFrigorifico=" + capacidadFrigorifico + ", capacidadCongelador=" + capacidadCongelador
                + ", sonoridad=" + sonoridad + "]";
    }
    

}
