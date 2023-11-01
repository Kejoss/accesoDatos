package tema2.ejerciciosDeClase.actividad6;

import java.io.Serializable;

import tema2.ejerciciosDeClase.actividad4.Clientes;

public class ClienteSer implements Serializable, Comparable<ClienteSer> {
    
    private String dni;
    private String nombre;
    private String fechaNac;
    private double saldo;
    
    public ClienteSer(String dni, String nombre, String fechaNac, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.saldo = saldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ClienteSer [dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", saldo=" + saldo + "]";
    }

    @Override
    public int compareTo(ClienteSer o) {
        if (this.getSaldo()>o.getSaldo()) {
            return -1;
        }

        if (this.getSaldo()<o.getSaldo()) {
            return 1;            
        }

        return 0;
    }

}
