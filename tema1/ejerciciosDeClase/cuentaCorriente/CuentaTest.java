package cuentaCorriente;

public class CuentaTest {
    
    public static void main(String[] args) {
        try {
            Cuenta cuenta = new Cuenta("ES9214650340551748792505", 0);
            Cuenta cuenta2 = new Cuenta("64230412Z","Paul","ES9214650340551748792505",600);

            cuenta.cambioTitular("35680417B", "Carmen");
            cuenta2.ingresarDinero(600);
            cuenta2.mostrarSaldo();
            cuenta2.sacarDinero(200);
            cuenta2.mostrarSaldo();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}