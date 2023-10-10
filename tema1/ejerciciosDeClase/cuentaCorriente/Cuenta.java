package cuentaCorriente;

import java.math.BigInteger;
import java.time.LocalDate;

public class Cuenta {
    
    private String dni;
    private String nombre;
    private String numCuenta;
    private double saldo;

    private static int dia = LocalDate.now().getDayOfMonth();
    private double cantidadActual = 0;
    private double cantidadActualRetirada = 0;
    private final int IMPORTEMAXIMOINGRESAR = 6000;
    private final int IMPORTEMAZIMORETIRAR = 3000;
    
    public Cuenta(String dni, String nombre, String numCuenta, double saldo) throws Exception{
        this.dni = dni;
        this.nombre = nombre;
        if (validarCuentaBancaria(numCuenta)) {
            this.numCuenta = numCuenta;   
        }else{
            throw new Exception("El numero de cuenta Iban es invalida") ;
        }
        this.saldo = saldo;
    }

    public Cuenta(String numCuenta, double saldo){
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getDni(){
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }
    public static void setDia(int dia) {
        Cuenta.dia = dia;
    }
    public static int getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return "Cuenta [dni=" + dni + ", nombre=" + nombre + ", numCuenta=" + numCuenta + ", saldo=" + saldo
                + ", cantidadActual=" + cantidadActual + ", cantidadActualRetirada=" + cantidadActualRetirada
                + ", IMPORTEMAXIMOINGRESAR=" + IMPORTEMAXIMOINGRESAR + ", IMPORTEMAZIMORETIRAR=" + IMPORTEMAZIMORETIRAR
                + "]";
    }

    public void ingresarDinero(double cantidad){
        if (dia<LocalDate.now().getDayOfMonth()) {
            dia = LocalDate.now().getDayOfMonth();
            cantidadActual =0;
        }else{
            if (cantidadActual<=IMPORTEMAXIMOINGRESAR) {
                saldo +=cantidad;
                System.out.println("Se ha realizado la operacion con exito");
            }
        }

    }

    public void sacarDinero(double cantidad){
        if (dia<LocalDate.now().getDayOfMonth()) {
            dia = LocalDate.now().getDayOfMonth();
            cantidadActualRetirada =0;
        }else{
            if (cantidadActualRetirada<=IMPORTEMAZIMORETIRAR) {
                saldo -=cantidad;
                System.out.println("Se ha realizado la operacion con exito");
            }
        }
    }

    public void mostrarSaldo(){
        System.out.println("Su saldo es de: "+saldo);
    }

    public void cambioTitular(String dni, String nombre){
        this.nombre = nombre;
        this.dni = dni;
        System.out.println("Se ha cambiado el titular de la cuenta con exito");
    }

    private boolean validarCuentaBancaria(String numCuenta){
        return validarIban(numCuenta) && validarPrimerDigitoControl(numCuenta) && validarSegundoDigitoControl(numCuenta);
    }

  private boolean validarPrimerDigitoControl(String numCuenta){
    String primerasCuatro = numCuenta.substring(4, 8);
    String segundasCuatro = numCuenta.substring(8, 12);

    int[] numeros = {4,8,5,10};
    int []numeros2 = {9,7,3,6};

    int sumaPrimerasCuatro = 0;
    int sumaSegundasCuatro = 0;

    for (int i = 0; i < primerasCuatro.length(); i++) {
        sumaPrimerasCuatro +=Integer.parseInt(String.valueOf(primerasCuatro.charAt(i)))*numeros[i];
        sumaSegundasCuatro +=Integer.parseInt(String.valueOf(segundasCuatro.charAt(i)))*numeros2[i];

    }

    int resto =(sumaPrimerasCuatro+sumaSegundasCuatro)%11;
    resto = 11-resto;

    if (resto == 10) {
        resto =1;
    }else if (resto==11) {
            resto =0;
        }
    if (resto == Integer.parseInt(String.valueOf(numCuenta.charAt(12)))) {
        return true;
    }else{
        return false;
    }
    
  }

  private boolean validarSegundoDigitoControl(String numCuenta){
    String ultimos10Digitos = numCuenta.substring(14);
    int suma =0;
    int modular=0;

    for (int i = 0; i < ultimos10Digitos.length(); i++) {
        if (i>3) {
            modular = (int)Math.pow(2, i)%11;
            suma +=modular*Integer.parseInt(String.valueOf(ultimos10Digitos.charAt(i)));
        }else{
            suma +=Math.pow(2, i)*Integer.parseInt(String.valueOf(ultimos10Digitos.charAt(i)));
        }
    }

    int resto = suma %11;
    resto =11-resto;

    if (resto == 10) {
        resto =1;
    }else if (resto==11) {
            resto =0;
        }
    if (resto == Integer.parseInt(String.valueOf(numCuenta.charAt(13)))) {
        return true;
    }else{
        return false;
    }

  }

  private boolean validarIban(String numCuenta){
    String nuevoIban = numCuenta.substring(4)+"142800";
    BigInteger bigNuevoIban = new BigInteger(nuevoIban);
    BigInteger big97 = new BigInteger("97");
    BigInteger big98 = new BigInteger("98");

    BigInteger resto = bigNuevoIban.mod(big97);
    resto = big98.subtract(resto);

    String restotext;
    if (resto.toString().length()==1) {
        restotext ="0"+resto.toString();
    }else{
        restotext = resto.toString();
    }

    if (restotext.contentEquals(numCuenta.substring(2, 4)) && validarPrimerDigitoControl(numCuenta) && validarSegundoDigitoControl(numCuenta)) {
        return true;
    }
    return false;
  }

}
