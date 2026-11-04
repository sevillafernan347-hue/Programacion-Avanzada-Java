package controlador;
import modelo.Empleado;
import modelo.Direccion;
import persistencia.ArchivoEmpleadoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class EmpleadoController {
    private final ArchivoEmpleadoDAO dao;
    public EmpleadoController() { this(new ArchivoEmpleadoDAO()); }
    public EmpleadoController(ArchivoEmpleadoDAO dao) { this.dao = Objects.requireNonNull(dao); }
    public boolean registrarEmpleado(String id, String nombre, String ciudad, String calle, double salario, double bono) {
        try {
            validarTexto(id); validarTexto(nombre); validarTexto(ciudad); validarTexto(calle);
            if (!Double.isFinite(salario) || !Double.isFinite(bono) || salario < 0 || bono < 0 || !Double.isFinite(salario + bono))
                throw new IllegalArgumentException("Salario o bono invalido");
            dao.guardarEmpleado(new Empleado(id, nombre, new Direccion(ciudad, calle), salario, bono));
            return true;
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("No se pudo registrar el empleado: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<String> listarEmpleados() {
        try { return dao.leerEmpleados(); }
        catch (IOException e) { throw new java.io.UncheckedIOException("No se pudieron leer los empleados", e); }
    }
    private static void validarTexto(String valor) {
        if (valor == null || valor.isBlank() || valor.contains(";") || valor.contains("\n") || valor.contains("\r"))
            throw new IllegalArgumentException("Texto vacio o con separadores no permitidos");
    }
}
