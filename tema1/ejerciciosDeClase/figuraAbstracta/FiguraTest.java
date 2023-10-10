package figuraAbstracta;

public class FiguraTest {
    
    public static void main(String[] args) {
        
        Rectangulo miRect = new Rectangulo(5, 4);
        Circulo miCirc = new Circulo(2.8);
        Triangulo miTri = new Triangulo(3, 4);
        Figura[] listaFiguras = { miRect,miCirc, miTri};

        for(int i =0; i<listaFiguras.length;i++){
            listaFiguras[i].calcularArea();;
            listaFiguras[i].mostrarArea();
        }

    }

}
