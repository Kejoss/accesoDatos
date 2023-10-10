package figuraAbstracta;

public abstract class Figura {
    
    double total = 0;
    
    public void mostrarArea(){
        System.out.println("Area calculada de "+this.getClass()+" es: "+total);
    }

    abstract public void calcularArea();

}
