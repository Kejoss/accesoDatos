package tema1.entregaKevinMoreno.ejercicio3;

import java.util.Date;

public class Vehiculo {
    
    private String matricula;
    private Date fechaInicio;
    private Date fechaFin;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }
    

}
