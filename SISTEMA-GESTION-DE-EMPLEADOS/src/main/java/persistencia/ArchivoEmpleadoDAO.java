package persistencia;
import modelo.Empleado;
import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class ArchivoEmpleadoDAO {
    private final Path rutaArchivo;
    public ArchivoEmpleadoDAO() { this(Path.of("empleados.txt")); }
    public ArchivoEmpleadoDAO(Path rutaArchivo) { this.rutaArchivo = Objects.requireNonNull(rutaArchivo); }
    public synchronized void guardarEmpleado(Empleado emp) throws IOException {
        String linea = emp.getId() + ";" + emp.getNombre() + ";" + emp.getDireccion().getCiudad() + ";" + emp.getDireccion().getCalle() + ";" + emp.calcularSalario();
        Files.writeString(rutaArchivo, linea + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    public ArrayList<String> leerEmpleados() throws IOException {
        if (Files.notExists(rutaArchivo)) return new ArrayList<>();
        return new ArrayList<>(Files.readAllLines(rutaArchivo, StandardCharsets.UTF_8));
    }
}
