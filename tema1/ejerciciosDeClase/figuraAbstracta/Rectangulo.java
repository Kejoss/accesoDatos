package figuraAbstracta;

public class Rectangulo extends Figura {
    
    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void calcularArea() {
        total = base *altura;
    }

    @Override
    public String toString() {
        return "Rectangulo [base=" + base + ", altura=" + altura + "]";
    }


}
