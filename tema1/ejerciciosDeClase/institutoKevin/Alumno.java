package institutoKevin;

public class Alumno extends Persona{
    //atributos
    private int nota;

    //constructor
    public Alumno(String nombre, int edad, String aula,int nota) throws Exception {
        super(nombre, edad, aula);
        
        if(nota<=10 && nota >=0) {
        	this.nota = nota;
        }else {
        	throw new Exception("La nota es invalida");
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return super.toString()+" Alumno [nota=" + nota + "]";
    }

    //metodos

    
}
