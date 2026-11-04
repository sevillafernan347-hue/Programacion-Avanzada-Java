package Modelo;
import Exepciones.SaldoInsuficienteException;

public class CuentaBancaria {
    private double saldo;
    public CuentaBancaria(double saldoInicial) {
        if (!Double.isFinite(saldoInicial) || saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial invalido");
        saldo = saldoInicial;
    }
    public synchronized void retirar(double monto) throws SaldoInsuficienteException {
        if (!Double.isFinite(monto) || monto <= 0) throw new IllegalArgumentException("Monto invalido");
        if (monto > saldo) throw new SaldoInsuficienteException("Fondos insuficientes para el retiro", monto - saldo);
        saldo -= monto;
    }
    public synchronized double getSaldo() { return saldo; }
}
