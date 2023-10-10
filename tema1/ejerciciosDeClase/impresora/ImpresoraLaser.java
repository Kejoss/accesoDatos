package impresora;

public class ImpresoraLaser implements Impresora {

    private int velocidad;

    public ImpresoraLaser(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
    }

    @Override
    public int getVelocidad() {
       return velocidad;
    }

    @Override
    public boolean esMasRapida(Impresora impresora) {
        if (((ImpresoraTinta)impresora).getVelocidad()> this.velocidad) {
            return false;
        }else{
            return true;
        }
    }
    
}
