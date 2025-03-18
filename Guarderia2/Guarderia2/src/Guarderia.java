import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Guarderia {
    private List<Estudiante> estudiantes;
    private String nombreGuarderia;

    public Guarderia(String nombreGuarderia, List<Estudiante> estudiantes) {
        this.nombreGuarderia = nombreGuarderia;
        this.estudiantes = estudiantes;
    }

    public void matricularEstudiante(Estudiante estudiante) {
        if (buscarEstudiante(estudiante.getIdentificacion()).isPresent()) {
            JOptionPane.showInputDialog("El estudiante con ID " + estudiante.getIdentificacion() + " ya está matriculado.");
            return;
        }
        estudiantes.add(estudiante);
        System.out.println("Estudiante matriculado exitosamente: " + estudiante.getNombre());
    }

    public void darDeBaja(String identificacion) {
        boolean eliminado = estudiantes.removeIf(estudiante -> estudiante.getIdentificacion().equals(identificacion));
        if (eliminado) {
            System.out.println("Estudiante dado de baja exitosamente.");
        } else {
            System.out.println("No se encontró un estudiante con la ID " + identificacion);
        }
    }

    public Optional<Estudiante> buscarEstudiante(String identificacion) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getIdentificacion().equals(identificacion))
                .findFirst();
    }

    public void listarEstudiantes() {
        JOptionPane.showInputDialog("\nListado de estudiantes en " + nombreGuarderia + ":");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes matriculados.");
        } else {
            estudiantes.forEach(System.out::println);
        }
    }

    public void mostrarMayoresDe5() {
        System.out.println("\nEstudiantes mayores de 5 años:");
        boolean hayMayores = estudiantes.stream()
                .filter(estudiante -> estudiante.getEdad() > 5)
                .peek(System.out::println)
                .count() > 0;

        if (!hayMayores) {
            System.out.println("No hay estudiantes mayores de 5 años.");
        }
    }

    public int getTotalEstudiantes() {
        return estudiantes.size();
    }
}
