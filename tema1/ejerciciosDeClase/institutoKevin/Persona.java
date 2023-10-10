package institutoKevin;

import java.util.Arrays;

public class Persona {

    //Atributos
    private String nombre;
    private int edad;
    private String aula;
    
    //constructores
    public Persona(String nombre, int edad, String aula)throws Exception {
       //validamos si el alumno esta en la lista de alumno
       if(this instanceof Alumno && Arrays.asList(ConstantesKevin.LISTA_ALUMNOS).contains(nombre) ){
                    this.nombre=nombre;
                    this.edad = edad;
                    this.aula = aula;

       }else if(this instanceof Profesor && Arrays.asList(ConstantesKevin.LISTA_PROFESORES).contains(nombre)){
                this.nombre=nombre;
                this.edad = edad;
                this.aula = aula;
       }else {
    	   throw new Exception(nombre+" no es un no es un profesor ni un alumno"); 
       }
    }


    //metodos

    public String getAula() {
        return aula;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", aula=" + aula + "]";
    }

    
    
}
