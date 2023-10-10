package persona;

import java.util.Random;

public class Persona {
    
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private int peso;
    private double altura;

    private final char HOMBRE='h';
    private final char MUJER='m';

    public Persona(){
        nombre="";
        sexo = HOMBRE;
        edad = 0;
        peso = 0;
        altura = 0;
        dni = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo){
        if (validaSexo(sexo)) {
            this.sexo=sexo;
            this.nombre = nombre;
            this.edad = edad;
            dni = generarDNI();
        }
    }

    public Persona(String nombre, int edad, String dni, char sexo, int peso, double altura){
        if (validaSexo(sexo) && validarDNI(dni)) {
            this.sexo = sexo;
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
            this.peso = peso;
            this.altura = altura;   
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        return (int)(peso/(altura*altura));
    }

    private boolean validarDNI(String dni){    
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = Integer.parseInt(dni.substring(0, 8))%23;

        if (letras[resto]==dni.charAt(8)) {
            return true;
        }else{
            return false;
        }
    }

    private boolean validaSexo(char sexo){
        if (sexo == HOMBRE || sexo == MUJER) {
            return true;
        }
        return false;
    }

    private String generarDNI(){
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        Random rand = new Random();
        int numero = rand.nextInt(90000000) + 10000000;
        int resto = numero%23;
        return Integer.toString(numero)+String.valueOf(letras[resto]);
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo + ", peso=" + peso
                + ", altura=" + altura;
    }

    

    

}
