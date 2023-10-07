package tema1.entregaKevinMoreno.ejercicio4;

public class Punto {
    
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distancia(Punto punto){
        return Math.sqrt((Math.pow(punto.getX()-x, 2)+Math.pow(punto.getY()-y, 2)));
    }

     public boolean equals(Punto punto) {
        if (punto instanceof Punto3D) {
            return false;
        }else{
            if(this.x == punto.getX() && this.y == punto.getY()){
                return true;
            }else{
                return false;
            }
        }
     }
    
}


