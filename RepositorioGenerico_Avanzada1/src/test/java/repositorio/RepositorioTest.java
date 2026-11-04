package repositorio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RepositorioTest {
 @Test void deshacerEliminaTambienLaClave() {
  var r = new RepositorioGenerico<String>(); r.agregar("a","uno"); r.agregar("b","dos");
  assertEquals("dos",r.deshacerUltimo()); assertNull(r.buscarPorClave("b")); assertEquals(java.util.List.of("uno"),r.obtenerTodos());
  assertEquals("uno",r.deshacerUltimo()); assertNull(r.deshacerUltimo());
 }
 @Test void clavesDuplicadasNoAlteranLosDatos() {
  var r = new RepositorioGenerico<String>(); r.agregar("a","uno");
  assertThrows(IllegalArgumentException.class,()->r.agregar("a","dos")); assertEquals("uno",r.buscarPorClave("a")); assertEquals(1,r.obtenerTodos().size());
 }
 @Test void mismoObjetoEnClavesDistintasYListaProtegida() {
  var r = new RepositorioGenerico<String>(); r.agregar("a","igual"); r.agregar("b","igual"); var foto=r.obtenerTodos();
  r.deshacerUltimo(); assertEquals("igual",r.buscarPorClave("a")); assertNull(r.buscarPorClave("b")); assertEquals(2,foto.size());
  assertThrows(UnsupportedOperationException.class,()->foto.add("otro"));
 }
}
