package com.mycompany.sistema.gestion.de.empleados;
import controlador.EmpleadoController;
import java.util.ArrayList;
/**
 *
 * @author alexandermaradiaga
 */
public class SISTEMAGESTIONDEEMPLEADOS {

    public static void main(String[] args) {
        EmpleadoController controller = new EmpleadoController();

        // 1. Probar el registro de empleados
        boolean exito1 = controller.registrarEmpleado("EMP01", "Alexander Maradiaga", "Tegucigalpa", "Col. Palmira", 15000, 2500);
        boolean exito2 = controller.registrarEmpleado("EMP02", "Maria Lopez", "San Pedro Sula", "Barrio Guamilito", 18000, 3000);

        if (exito1 && exito2) {
            System.out.println("¡Empleados guardados correctamente en empleados.txt!");
        }

        // 2. Leer los datos persistidos en el archivo
        System.out.println("\n--- Lista de Empleados en Archivo ---");
        ArrayList<String> empleados = controller.listarEmpleados();
        for (String emp : empleados) {
            System.out.println(emp);
        }
    }
}
