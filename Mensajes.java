public final class Mensajes {
    private Mensajes() {} // no instancias

    // Textos de salida / prompts
    public static final String SOLICITAR_PORCENTAJE = "Introduzca el porcentaje de aumento de salario: ";
    public static final String LISTA_EMPLEADOS = "Lista de Empleados:";
    public static final String CARGOS_DISPONIBLES = "Cargos disponibles:";

    // Mensajes adicionales (opcionales)
    public static final String LISTA_LLENA = "No se pueden añadir más empleados: lista llena.";
    public static final String INDICE_FUERA_RANGO = "Índice de cargo fuera de rango: ";

    // Números "mágicos"
    public static final int CAPACIDAD_INICIAL_EMPLEADOS = 3;

    // Convenio salarial mínimo para validaciones
    public static final double SALARIO_CONVENIO = 15000.0;
}