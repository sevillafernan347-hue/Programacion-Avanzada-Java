package com.mycompany.procesamientoasincrono;
import Modelo.CuentaBancaria;
import Exepciones.SaldoInsuficienteException;
import java.util.concurrent.*;

public class ProcesamientoAsincrono {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        ExecutorService ejecutor = Executors.newFixedThreadPool(2);
        try {
            Future<String> primero = ejecutor.submit(() -> retirar(cuenta, 700));
            Future<String> segundo = ejecutor.submit(() -> retirar(cuenta, 500));
            System.out.println(primero.get());
            System.out.println(segundo.get());
            System.out.println("Saldo final: " + cuenta.getSaldo());
        } finally { ejecutor.shutdown(); }
    }
    private static String retirar(CuentaBancaria cuenta, double monto) {
        try { cuenta.retirar(monto); return "Retiro realizado: " + monto; }
        catch (SaldoInsuficienteException e) { return e.getMessage() + ". Faltan: " + e.getMontoFaltante(); }
    }
}
