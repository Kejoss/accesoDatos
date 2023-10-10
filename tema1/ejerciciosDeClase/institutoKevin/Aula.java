package institutoKevin;

import java.util.ArrayList;
import java.util.Arrays;

public class Aula {

    //atributos
    private String nombreAula;
    private int numEstudiantes;
    private String[] profesoresAsig;
    private String[] alumnosAsig;
    private String[] materias;
    
    //constructores
    public Aula(String nombreAula, ArrayList<Profesor> listaProfesor, ArrayList<Alumno> listaAlumnos
            ) throws Exception {

        if(Arrays.asList(ConstantesKevin.LISTA_CLASES).contains(nombreAula)&&
        		listaAlumnos.size() < ConstantesKevin.MAX_ESTUDIANTES){
        	
        	Profesor[] profesor = new Profesor[listaProfesor.size()];
        	listaProfesor.toArray(profesor);
        	
        	Alumno[] alumno= new Alumno[listaAlumnos.size()];
        	listaAlumnos.toArray(alumno);
        	
        	alumnosAsig=new String[listaAlumnos.size()];
        	profesoresAsig=new String[listaProfesor.size()];
        	materias=new String[listaProfesor.size()];
        	
            this.nombreAula = nombreAula;
            this.numEstudiantes = listaAlumnos.size();
            
            for (int i = 0; i < alumno.length; i++) {
            	if(alumnosAsig[i]==null) {
            		alumnosAsig[i]=alumno[i].getNombre();
            	}
			}
            
            for (int i = 0; i < profesor.length; i++) {
            	if(profesor[i].getAula().equalsIgnoreCase(nombreAula)) {
    				profesoresAsig[i]=profesor[i].getNombre();
    				materias[i]= profesor[i].getMateria();
            	}
			}            
            
        }else{
            throw new Exception("No existe el aula");
        }
    }



	public String getNombreAula() {
        return nombreAula;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public String[] getProfesoresAsig() {
        return profesoresAsig;
    }

    public String[] getAlumnosAsig() {
        return alumnosAsig;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    public void setProfesoresAsig(String[] profesoresAsig) {
        this.profesoresAsig = profesoresAsig;
    }

    public void setAlumnosAsig(String[] alumnosAsig) {
        this.alumnosAsig = alumnosAsig;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Aula [nombreAula=" + nombreAula + ", numEstudiantes=" + numEstudiantes + ", profesoresAsig="
                + Arrays.toString(profesoresAsig) +","+"\n"+ "alumnosAsig=" + Arrays.toString(alumnosAsig) + ", materias="
                + Arrays.toString(materias) + "]";
    }

    
    //Metodos

    
}
