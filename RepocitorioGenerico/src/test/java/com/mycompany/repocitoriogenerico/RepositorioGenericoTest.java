package com.mycompany.repocitoriogenerico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RepositorioGenericoTest {
 @Test void productoConservaSusDatos() {
  var p = new Modelo.ProductoGrafico("Laptop",4500); assertEquals("Laptop",p.getNombre()); assertEquals(4500,p.getValorVentas());
 }
}
