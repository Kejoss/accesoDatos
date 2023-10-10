package institutoKevin;

import java.util.Arrays;

public class Profesor extends Persona{
    //atributos
    private String materia;
    
    //constructor
    public Profesor(String nombre, int edad, String aula,String materia) throws Exception {
        super(nombre, edad, aula);
        if(Arrays.asList(ConstantesKevin.LISTA_MATERIAS).contains(materia)) {
        	this.materia=materia;
        }else {
        	throw new Exception("La materia no existe");
        }
    }
    
    public String getMateria() {
        return materia;
    }
    
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    @Override
    public String toString() {
        return super.toString()+" Profesor [materia=" + materia + "]";
    }
    
    //metodos

    
}
