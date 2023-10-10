package electrodomesticos;

public class Electrodomestico {
    
    private String marca;
    private String modelo;
    private double precio;
    private String color;
    private int potenciaW;
    private int horasUtilizadas;
    private int diasUtilizacion;
    private double precioEnergia;
    
    public Electrodomestico() {
        marca = "bosch";
        modelo = "7200";
        precio = 400;
        color = "gris";
        potenciaW = 2300;
        horasUtilizadas = 1;
        diasUtilizacion = 3;
        precioEnergia = 0.40397;
    }

    public Electrodomestico(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Electrodomestico(String marca, String modelo, double precio, String color, int potenciaW,
            int horasUtilizadas, int diasUtilizacion, double precioEnergia) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.potenciaW = potenciaW;
        this.horasUtilizadas = horasUtilizadas;
        this.diasUtilizacion = diasUtilizacion;
        this.precioEnergia = precioEnergia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPotenciaW() {
        return potenciaW;
    }

    public void setPotenciaW(int potenciaW) {
        this.potenciaW = potenciaW;
    }

    public int getHorasUtilizadas() {
        return horasUtilizadas;
    }

    public void setHorasUtilizadas(int horasUtilizadas) {
        this.horasUtilizadas = horasUtilizadas;
    }

    public int getDiasUtilizacion() {
        return diasUtilizacion;
    }

    public void setDiasUtilizacion(int diasUtilizacion) {
        this.diasUtilizacion = diasUtilizacion;
    }

    public double getPrecioEnergia() {
        return precioEnergia;
    }

    public void setPrecioEnergia(double precioEnergia) {
        this.precioEnergia = precioEnergia;
    }

    public double consumoAnual(){       
        return (52*diasUtilizacion*horasUtilizadas*(potenciaW/1000))*precioEnergia;
    }

    @Override
    public String toString() {
        return "Electrodomestico [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", color=" + color
                + ", potenciaW=" + potenciaW + ", horasUtilizadas=" + horasUtilizadas + ", diasUtilizacion="
                + diasUtilizacion + ", precioEnergia=" + precioEnergia + "]";
    }        

}
