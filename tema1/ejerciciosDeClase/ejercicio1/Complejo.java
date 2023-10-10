package ejercicio1;

public class Complejo {
    
    private double dPReal;
    private double dPImg;

    public Complejo(){
        
    }

    public void asignar(double x, double y){
        dPReal= x;
        dPImg = y;
    }
    public double getdPReal() {
        return dPReal;
    }


    public void setdPReal(double dPReal) {
        this.dPReal = dPReal;
    }


    public double getdPImag() {
        return dPImg;
    }


    public void setdPImag(double dPImag) {
        this.dPImg = dPImag;
    }

    public Complejo sumar(Complejo c1, Complejo c2){
        Complejo c3 = new Complejo();
        c3.asignar((c1.getdPReal()+c2.getdPReal()), (c1.getdPImag()+c2.getdPImag())); 
        return c3; 
    }

    public void imprimir(){
        System.out.println("numero real: "+dPReal+" numero imaginario: "+dPImg);
    }

}
