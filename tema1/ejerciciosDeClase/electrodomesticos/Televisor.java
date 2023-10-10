package electrodomesticos;

public class Televisor extends Electrodomestico {
    
    private int resolucion;

    public Televisor(){
        resolucion=4;
    }

    public Televisor(String marca, String modelo, double precio, int resolucion) {
        super(marca, modelo, precio);
        this.resolucion = resolucion;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    @Override
    public double consumoAnual() {
        if (resolucion>50) {
            return super.consumoAnual()+30;
        }
        return super.consumoAnual();
    }

    @Override
    public String toString() {
        return super.toString()+" Televisor [resolucion=" + resolucion + "]";
    }

    

}
