package persona;

import java.util.Scanner;

public class PersonaTest {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre");
        String nombre= sc.next();
        System.out.println("Escribe la edad");
        int edad = sc.nextInt();
        System.out.println("Escribe el sexo: h = hombre y m = mujer");
        char sexo = sc.next().charAt(0);
        System.out.println("Escribe el peso ");
        int peso = sc.nextInt();
        System.out.println("Escribe la altura");
        Double altura = sc.nextDouble();

        sc.close();

        Persona persona1 = new Persona(nombre, edad, "35680417B", sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        persona3.setAltura(1.71);
        persona3.setEdad(29);
        persona3.setNombre("Richard");
        persona3.setPeso(78);

        System.out.println("");
        System.out.println("El IMC de persona1: "+persona1.calcularIMC());
        System.out.println("El IMC de persona2: "+persona2.calcularIMC());
        System.out.println("El IMC de persona3: "+persona3.calcularIMC());

        System.out.println();
        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);

        
    }

}
