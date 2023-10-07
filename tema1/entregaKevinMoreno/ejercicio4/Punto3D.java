package tema1.entregaKevinMoreno.ejercicio4;

public class Punto3D extends Punto {

    private int z;

    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }
    
    public double distancia(Punto otroPunto) {
        if (otroPunto instanceof Punto3D) {
            Punto3D otroPunto3D=(Punto3D) otroPunto;
            return Math.sqrt(Math.pow(otroPunto3D.getX()-this.getX(), 2)+ Math.pow(otroPunto3D.getY()-this.getY(), 2)+Math.pow(otroPunto3D.getZ()-this.getZ(), 2));
        } else {
            return super.distancia(otroPunto);
        }
    }

    public boolean equals(Punto punto) {
        if (punto instanceof Punto3D) {
            if(this.getZ() == ((Punto3D)punto).getZ() && ((Punto3D)punto).getX()==this.getX() && ((Punto3D)punto).getY() == this.getY()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
     }

}
