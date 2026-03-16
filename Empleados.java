
/**
 * Gestor de una colección fija de {@link Empleado}.
 *
 * <p>Proporciona operaciones para:
 * - dar de alta empleados con validación,
 * - aumentar salarios,
 * - mostrar el listado,
 * y obtener el array subyacente.</p>
 *
 * <p>El atributo interno se llama {@code lista} para evitar redundancias como {@code empleados.empleados}.</p>
 */
public class Empleados {

    /**
     * Array que contiene los empleados registrados. Las posiciones libres contienen {@code null}.
     */
    private Empleado[] lista;

    /**
     * Crea un gestor de empleados con la capacidad indicada.
     *
     * @param capacidad número máximo de empleados que se pueden almacenar (longitud del array)
     */
    public Empleados(int capacidad) {
        this.lista = new Empleado[capacidad];
    }

    /**
     * Intenta dar de alta un empleado tras validar sus atributos.
     *
     * <p>Validaciones aplicadas:
     * - nombre: no nulo, trim no vacío, al menos dos palabras;
     * - cargo: no nulo y debe existir en la lista de {@link Cargos};
     * - salario: no {@link Double#isNaN(double)}, no negativo y >= {@link Mensajes#SALARIO_CONVENIO}.</p>
     *
     * @param e el empleado a dar de alta (puede ser null, en cuyo caso devuelve {@code false})
     * @return {@code true} si el empleado fue añadido correctamente; {@code false} si no (validación fallida o lista llena)
     */
    public boolean altaEmpleado(Empleado e) {
        if (e == null) return false;

        // Validar nombre
        String nombre = e.getNombre();
        if (nombre == null) return false;
        String nombreTrim = nombre.trim();
        if (nombreTrim.isEmpty()) return false;
        String[] palabras = nombreTrim.split("\\s+");
        if (palabras.length < 2) return false;

        // Validar cargo usando Cargos
        String cargo = e.getCargo();
        if (cargo == null) return false;
        Cargos cargos = new Cargos();
        if (!cargos.esCargoValido(cargo)) return false;

        // Validar salario
        double salario = e.getSalario();
        if (Double.isNaN(salario)) return false;
        if (salario < 0) return false;
        if (salario < Mensajes.SALARIO_CONVENIO) return false;

        // Añadir al primer hueco libre
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = e;
                return true;
            }
        }
        System.out.println(Mensajes.LISTA_LLENA);
        return false;
    }

    /**
     * Aumenta el salario de todos los empleados existentes en la lista en el porcentaje indicado.
     *
     * @param porcentaje porcentaje de aumento (por ejemplo 10.0 = +10%)
     */
    public void aumentarSalario(double porcentaje) {
        for (Empleado emp : lista) {
            if (emp != null) {
                emp.setSalario(emp.getSalario() * (1 + porcentaje / 100.0));
            }
        }
    }

    /**
     * Muestra por consola el listado de empleados no nulos almacenados en {@code lista}.
     * Utiliza la constante {@link Mensajes#LISTA_EMPLEADOS} para el título.
     */
    public void mostrarListado() {
        System.out.println(Mensajes.LISTA_EMPLEADOS);
        for (Empleado emp : lista) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    /**
     * Devuelve el array interno (referencia directa).
     *
     * <p>Nota: la llamada devuelve la referencia al array interno; modificarlo desde fuera
     * afectará al estado del gestor.</p>
     *
     * @return el array de empleados (posiciones libres contienen {@code null})
     */
    public Empleado[] getLista() {
        return lista;
    }
}