package ejercicio1;

public class ComplejoTest {
    
    public static void main(String[] args) {
        
        Complejo cp = new Complejo();
        Complejo cp2 = new Complejo();

        cp.asignar(20, -3);
        cp2.asignar(-4, 20);

        Complejo resultado = cp.sumar(cp,cp2);

        resultado.imprimir();


    }

}
