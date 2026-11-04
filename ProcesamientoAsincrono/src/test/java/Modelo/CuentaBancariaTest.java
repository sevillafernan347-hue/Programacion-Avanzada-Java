package Modelo;
import Exepciones.SaldoInsuficienteException;
import java.util.concurrent.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CuentaBancariaTest {
 @Test void saldoInsuficienteNoCambiaSaldo() throws Exception {
  var c = new CuentaBancaria(100); var e=assertThrows(SaldoInsuficienteException.class,()->c.retirar(150));
  assertEquals(50,e.getMontoFaltante()); assertEquals(100,c.getSaldo()); c.retirar(100); assertEquals(0,c.getSaldo());
 }
 @Test void rechazaMontosInvalidos() {
  assertThrows(IllegalArgumentException.class,()->new CuentaBancaria(-1)); var c=new CuentaBancaria(100);
  for(double n : new double[]{0,-1,Double.NaN,Double.POSITIVE_INFINITY}) assertThrows(IllegalArgumentException.class,()->c.retirar(n));
 }
 @Test void retirosConcurrentesNoSobregiranLaCuenta() throws Exception {
  var c=new CuentaBancaria(1000); var pool=Executors.newFixedThreadPool(8);
  try {
   var trabajos=new java.util.ArrayList<Future<Boolean>>();
   for(int i=0;i<100;i++) trabajos.add(pool.submit(()->{try{c.retirar(25);return true;}catch(SaldoInsuficienteException e){return false;}}));
   int exitos=0; for(var f:trabajos) if(f.get(10,TimeUnit.SECONDS)) exitos++;
   assertEquals(40,exitos); assertEquals(0,c.getSaldo());
  } finally {pool.shutdownNow();}
 }
}
