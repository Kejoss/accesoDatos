package impresora;

public class ImpresoraTinta implements Impresora{

    private int velocidad;

    public ImpresoraTinta(int velocidad) {
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
        if (((ImpresoraLaser)impresora).getVelocidad()> this.velocidad) {
            return false;
        }else{
            return true;
        }
    }




}
