package tema2.ejercicios.actividad5;

import java.io.Serializable;

public class Registro implements Serializable {
    
    private String ciudad;
    private String fecha;
    private String tempMax;
    private String tempMin;

    public Registro(String ciudad, String fecha, String tempMax, String tempMin) {
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    @Override
    public String toString() {
        return "Registro [ciudad=" + ciudad + ", fecha=" + fecha + ", tempMax=" + tempMax + ", tempMin=" + tempMin
                + "]";
    }
    

}
