package impresora;

public interface Impresora {
    
    public void imprimir(String texto);
    public int getVelocidad();
    public boolean esMasRapida(Impresora impresora);


}
