package tema1.entregaKevinMoreno.ejercicio4;

public class Suceso extends Punto3D {

    private String tiempo;
    private String descripcion;

    public Suceso(int x, int y, int z, String tiempo, String descripcion) {
        super(x, y, z);
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
