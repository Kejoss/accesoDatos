package institutoKevin;

import java.util.ArrayList;

public class InstitutoTestKevin {
    
    public static void main(String[] args) {
        
		try {
			Profesor profeJuan = new Profesor("Juan", 20, "2.6", "Base de datos");
			Profesor profeMiguel = new Profesor("Miguel", 31, "2.7", "Ofimatica");
			Profesor profesorRoberto = new Profesor("Roberto", 28,"B3", "Montaje y mantenimiento");			
			
	        ArrayList<Profesor> listaProfesor = new ArrayList<Profesor>();
	        
	        listaProfesor.add(profeJuan);
	        listaProfesor.add(profeMiguel);
	        listaProfesor.add(profesorRoberto);

	        Alumno alumnoSergio = new Alumno("Sergio", 20, "2.6", 8);
	        Alumno alumnoJairo = new Alumno("Jairo", 25, "2.6", 8);
	        Alumno alumnoAdam = new Alumno("Adam", 20, "2.6", 8);
	        Alumno alumnoGuillermo = new Alumno("Guillermo", 26, "2.6", 8);
	        
	        ArrayList<Alumno> listaAlumnos= new ArrayList<Alumno>();
	        listaAlumnos.add(alumnoSergio);
	        listaAlumnos.add(alumnoJairo);
	        listaAlumnos.add(alumnoAdam);
	        listaAlumnos.add(alumnoGuillermo);
	        
	        Aula aula26 = new Aula("2.6", listaProfesor, listaAlumnos);
	        
	        System.out.println("Aula2.6 incluye= "+aula26);
			
			
		} catch (Exception ex) {
			System.out.println(ex);;
		}
       


    }
}
