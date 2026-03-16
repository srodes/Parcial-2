import java.util.Scanner;

public class SistemaGestionEmpleados {

    public static void main(String[] args) {
        Empleados empleados = new Empleados(Mensajes.CAPACIDAD_INICIAL_EMPLEADOS);
        Cargos cargos = new Cargos();

        // Dar de alta los tres empleados usando el nuevo método y la lista de cargos
        empleados.altaEmpleado(new Empleado("Juan", cargos.get(0), 50000));
        empleados.altaEmpleado(new Empleado("María", cargos.get(1), 45000));
        empleados.altaEmpleado(new Empleado("Pedro", cargos.get(2), 60000));

        Scanner scanner = new Scanner(System.in);
        System.out.print(Mensajes.SOLICITAR_PORCENTAJE);
        double porcentaje = scanner.nextDouble();

        empleados.aumentarSalario(porcentaje);

        empleados.mostrarListado();

        scanner.close();
    }
}