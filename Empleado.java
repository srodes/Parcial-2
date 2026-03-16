/**
 * Representa un empleado de la empresa.
 *
 * <p>La clase encapsula los atributos básicos de un empleado:
 * nombre, cargo y salario, y ofrece getters/setters para cada uno.
 * También redefine {@link #toString()} para presentar la información
 * en formato legible.</p>
 */
class Empleado {

    /**
     * Nombre completo del empleado.
     * Puede contener espacios; las validaciones se realizan fuera de esta clase.
     */
    private String nombre;

    /**
     * Cargo profesional del empleado (p. ej. "Desarrollador").
     * Se recomienda utilizar la clase {@link Cargos} para gestionar valores válidos.
     */
    private String cargo;

    /**
     * Salario del empleado en la unidad monetaria del sistema.
     * Puede ser decimal; las validaciones (no negativo, convenio, etc.) se realizan
     * fuera de esta clase cuando sea necesario.
     */
    private double salario;

    /**
     * Construye un nuevo objeto Empleado con los atributos indicados.
     *
     * @param nombre el nombre completo del empleado (puede ser null si la validación se hace externamente)
     * @param cargo  el cargo del empleado (texto libre; usar {@link Cargos} para valores controlados)
     * @param salario el salario del empleado
     */
    public Empleado(String nombre, String cargo, double salario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return el nombre completo (puede ser null)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre el nuevo nombre (puede ser null; las reglas de validación son externas)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el cargo del empleado.
     *
     * @return el cargo (puede ser null)
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     *
     * @param cargo el cargo a asignar (texto libre; preferible usar {@link Cargos})
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene el salario del empleado.
     *
     * @return el salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     *
     * @param salario el salario a asignar
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Devuelve una representación textual del empleado con nombre, cargo y salario.
     *
     * @return cadena con los datos del empleado
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}