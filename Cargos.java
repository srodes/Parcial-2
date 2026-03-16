import java.util.Arrays;

/**
 * Administrador de la lista de cargos profesionales válidos en la empresa.
 *
 * <p>Proporciona una lista interna de cargos (por defecto: "Desarrollador", "Diseñadora", "Gerente")
 * y operaciones para consultar, validar, añadir y mostrar los cargos disponibles.</p>
 */
public class Cargos {

    /**
     * Array interno con los nombres de los cargos disponibles.
     */
    private String[] lista;

    /**
     * Construye el administrador con una lista por defecto de cargos.
     */
    public Cargos() {
        this.lista = new String[] { "Desarrollador", "Diseñadora", "Gerente" };
    }

    /**
     * Obtiene el cargo en la posición indicada.
     *
     * @param index índice del cargo (0-based)
     * @return el nombre del cargo en la posición indicada
     * @throws IndexOutOfBoundsException si el índice está fuera del rango del array
     */
    public String get(int index) {
        if (index < 0 || index >= lista.length) {
            throw new IndexOutOfBoundsException(Mensajes.INDICE_FUERA_RANGO + index);
        }
        return lista[index];
    }

    /**
     * Devuelve una copia del array de cargos.
     *
     * @return copia del array {@code lista}
     */
    public String[] getLista() {
        return Arrays.copyOf(lista, lista.length);
    }

    /**
     * Comprueba si un texto corresponde a un cargo válido (comparación case-insensitive).
     *
     * @param cargo texto del cargo a validar (puede ser null)
     * @return {@code true} si el cargo coincide con alguno de los existentes; {@code false} en caso contrario
     */
    public boolean esCargoValido(String cargo) {
        if (cargo == null) return false;
        for (String c : lista) {
            if (c.equalsIgnoreCase(cargo)) return true;
        }
        return false;
    }

    /**
     * Agrega un nuevo cargo a la lista si no existe y no es null.
     *
     * @param cargo el nombre del nuevo cargo (si es null o ya existe, no se hace nada)
     */
    public void agregarCargo(String cargo) {
        if (cargo == null || esCargoValido(cargo)) return;
        lista = Arrays.copyOf(lista, lista.length + 1);
        lista[lista.length - 1] = cargo;
    }

    /**
     * Imprime por consola los cargos disponibles usando la constante {@link Mensajes#CARGOS_DISPONIBLES}.
     */
    public void mostrarCargos() {
        System.out.println(Mensajes.CARGOS_DISPONIBLES);
        for (int i = 0; i < lista.length; i++) {
            System.out.println(i + ": " + lista[i]);
        }
    }
}