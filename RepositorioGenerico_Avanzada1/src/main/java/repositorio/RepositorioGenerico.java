package repositorio;
import java.util.*;

public class RepositorioGenerico<T> {
    private final Map<String,T> elementos = new LinkedHashMap<>();
    private final Deque<String> historial = new ArrayDeque<>();

    public void agregar(String clave, T elemento) {
        if (clave == null || clave.isBlank()) throw new IllegalArgumentException("Clave obligatoria");
        Objects.requireNonNull(elemento, "Elemento obligatorio");
        if (elementos.containsKey(clave)) throw new IllegalArgumentException("La clave ya existe: " + clave);
        elementos.put(clave, elemento);
        historial.push(clave);
    }
    public List<T> obtenerTodos() {
        return Collections.unmodifiableList(new ArrayList<>(elementos.values()));
    }
    public T buscarPorClave(String clave) { return elementos.get(clave); }
    public T deshacerUltimo() {
        return historial.isEmpty() ? null : elementos.remove(historial.pop());
    }
}
