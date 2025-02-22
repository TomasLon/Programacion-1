import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();

        // Estudiantes predefinidos
        listaEstudiantes.add(new Estudiante("Juan Pérez", 3, "Masculino", "ID001", "Ninguna", "María Pérez", "123456789"));
        listaEstudiantes.add(new Estudiante("Ana Gómez", 6, "Femenino", "ID002", "Polen", "Carlos Gómez", "987654321"));
        listaEstudiantes.add(new Estudiante("Luis Fernández", 5, "Masculino", "ID003", "Lácteos", "Lucía Fernández", "456789123"));
        listaEstudiantes.add(new Estudiante("Sofía Ramírez", 7, "Femenino", "ID004", "Gluten", "Jorge Ramírez", "789123456"));
        listaEstudiantes.add(new Estudiante("Carlos Torres", 4, "Masculino", "ID005", "Nueces", "Elena Torres", "321654987"));

        Guarderia guarderia = new Guarderia("Guardería Infantil", listaEstudiantes);

        int opcion;
        do {
            String menu = """
                    *** MENÚ ***
                    1. Mostrar Lista de Estudiantes
                    2. Registrar Estudiante
                    3. Dar de Baja Estudiante
                    4. Buscar Estudiante por Identificación
                    5. Mostrar Niños Mayores de 5 Años
                    6. Salir
                    Ingrese una opción:""";

            opcion = obtenerEntero(menu);

            if (opcion == 1) {
                guarderia.listarEstudiantes();
            } else if (opcion == 2) {
                registrarEstudiante(guarderia);
            } else if (opcion == 3) {
                darDeBajaEstudiante(guarderia);
            } else if (opcion == 4) {
                buscarEstudiante(guarderia);
            } else if (opcion == 5) {
                guarderia.mostrarMayoresDe5();
            } else if (opcion == 6) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void registrarEstudiante(Guarderia guarderia) {
        String nombre = obtenerTexto("Ingrese el nombre del estudiante:");
        int edad = obtenerEntero("Ingrese la edad del estudiante:");
        String genero = obtenerTexto("Ingrese el género del estudiante:");
        String identificacion = obtenerTexto("Ingrese la identificación del estudiante:");
        String alergias = obtenerTexto("Ingrese las alergias del estudiante:");
        String nombreAcudiente = obtenerTexto("Ingrese el nombre del acudiente:");
        String telefonoContacto = obtenerTexto("Ingrese el teléfono del acudiente:");

        Estudiante nuevoEstudiante = new Estudiante(nombre, edad, genero, identificacion, alergias, nombreAcudiente, telefonoContacto);
        guarderia.matricularEstudiante(nuevoEstudiante);
    }

    private static void darDeBajaEstudiante(Guarderia guarderia) {
        String identificacion = obtenerTexto("Ingrese la identificación del estudiante a dar de baja:");
        guarderia.darDeBaja(identificacion);
    }

    private static void buscarEstudiante(Guarderia guarderia) {
        String identificacion = obtenerTexto("Ingrese la identificación del estudiante a buscar:");
        guarderia.buscarEstudiante(identificacion).ifPresentOrElse(
                estudiante -> JOptionPane.showMessageDialog(null, estudiante.toString()),
                () -> JOptionPane.showMessageDialog(null, "Estudiante no encontrado.")
        );
    }

    // Métodos para validaciones
    private static int obtenerEntero(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) return -1; // Si el usuario cancela, retorna -1
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    private static String obtenerTexto(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. No puede estar vacío.");
            }
        } while (input == null || input.trim().isEmpty());
        return input;
    }
}
