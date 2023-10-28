package tema2.ejerciciosDeClase.actividad4;

public class Clientes implements Comparable<Clientes> {
    
    private String dni;
    private String nombre;
    private String fechaNac;
    private double saldo;

    public Clientes(String dni, String nombre, String fechaNac, double saldo){
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Clientes [dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", saldo=" + saldo + "]";
    }

    @Override
    public int compareTo(Clientes o) {

        if (this.getSaldo()>o.getSaldo()) {
            return -1;
        }

        if (this.getSaldo()<o.getSaldo()) {
            return 1;            
        }

        return 0;

    }

    

}
