package controlador;
import persistencia.ArchivoEmpleadoDAO;
import java.nio.file.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
class EmpleadoControllerTest {
 @TempDir Path dir;
 @Test void persisteYRecuperaTextoEnUtf8() {
  Path archivo=dir.resolve("empleados.txt"); var c=new EmpleadoController(new ArchivoEmpleadoDAO(archivo));
  assertTrue(c.listarEmpleados().isEmpty()); assertTrue(c.registrarEmpleado("E1","María","Tegucigalpa","Calle 1",15000,2500));
  var nuevo=new EmpleadoController(new ArchivoEmpleadoDAO(archivo)); assertEquals(java.util.List.of("E1;María;Tegucigalpa;Calle 1;17500.0"),nuevo.listarEmpleados());
 }
 @Test void falloDeEscrituraDevuelveFalse() {
  var c=new EmpleadoController(new ArchivoEmpleadoDAO(dir.resolve("no-existe/empleados.txt")));
  assertFalse(c.registrarEmpleado("E1","Ana","Ciudad","Calle",100,20));
 }
 @Test void validaDatosAntesDeEscribir() {
  var c=new EmpleadoController(new ArchivoEmpleadoDAO(dir.resolve("empleados.txt")));
  assertFalse(c.registrarEmpleado("E;1","Ana","Ciudad","Calle",100,20));
  assertFalse(c.registrarEmpleado("E1","Ana","Ciudad","Calle",Double.NaN,20)); assertTrue(c.listarEmpleados().isEmpty());
 }
 @Test void lecturaFallidaEsExplicita() {
  var c=new EmpleadoController(new ArchivoEmpleadoDAO(dir)); assertThrows(java.io.UncheckedIOException.class,c::listarEmpleados);
 }
}
