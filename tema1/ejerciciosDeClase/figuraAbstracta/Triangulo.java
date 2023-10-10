package figuraAbstracta;

public class Triangulo extends Figura {
    
    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void calcularArea() {
        total = 0.5*base*altura;
    }

    @Override
    public String toString() {
        return "Triangulo [base=" + base + ", altura=" + altura + "]";
    }

    

    

}
