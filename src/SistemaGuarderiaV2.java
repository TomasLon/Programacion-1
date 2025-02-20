// SistemaGuarderiaV2.java
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class EstudianteGuarderia {
    private String nombre;
    private int edad;
    private String genero;
    private String documentoIdentidad;
    private String alergias;
    private String nombreAcudiente;
    private String telefonoContacto;

    public EstudianteGuarderia(String nombre, int edad, String genero, String documentoIdentidad,
                               String alergias, String nombreAcudiente, String telefonoContacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.documentoIdentidad = documentoIdentidad;
        this.alergias = alergias;
        this.nombreAcudiente = nombreAcudiente;
        this.telefonoContacto = telefonoContacto;
    }

    // Getters y setters con retorno en cadena
    public EstudianteGuarderia setNombre(String nombre) { this.nombre = nombre; return this; }
    public EstudianteGuarderia setEdad(int edad) { this.edad = edad; return this; }
    public EstudianteGuarderia setGenero(String genero) { this.genero = genero; return this; }
    public EstudianteGuarderia setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; return this; }
    public EstudianteGuarderia setAlergias(String alergias) { this.alergias = alergias; return this; }
    public EstudianteGuarderia setNombreAcudiente(String nombreAcudiente) { this.nombreAcudiente = nombreAcudiente; return this; }
    public EstudianteGuarderia setTelefonoContacto(String telefonoContacto) { this.telefonoContacto = telefonoContacto; return this; }

    // Getters necesarios
    public String getNombre() { return nombre; }
    public String getDocumentoIdentidad() { return documentoIdentidad; }

    @Override
    public String toString() {
        return "Estudiante{\n" +
                "  nombre='" + nombre + "'\n" +
                "  edad=" + edad + "\n" +
                "  género='" + genero + "'\n" +
                "  documentoIdentidad='" + documentoIdentidad + "'\n" +
                "  alergias='" + alergias + "'\n" +
                "  nombreAcudiente='" + nombreAcudiente + "'\n" +
                "  telefonoContacto='" + telefonoContacto + "'\n" +
                '}';
    }
}

class AdministradorGuarderia {
    private List<EstudianteGuarderia> estudiantes;
    private String nombreGuarderia;

    public AdministradorGuarderia(String nombreGuarderia) {
        this.nombreGuarderia = nombreGuarderia;
        this.estudiantes = new ArrayList<>();
    }

    public void matricularEstudiante(EstudianteGuarderia estudiante) {
        if (buscarEstudiante(estudiante.getDocumentoIdentidad()).isPresent()) {
            System.out.println("El estudiante con documento " + estudiante.getDocumentoIdentidad() + " ya está matriculado.");
            return;
        }
        estudiantes.add(estudiante);
        System.out.println("Estudiante matriculado exitosamente: " + estudiante.getNombre());
    }

    public void darDeBaja(String documentoIdentidad) {
        boolean eliminado = estudiantes.removeIf(estudiante -> estudiante.getDocumentoIdentidad().equals(documentoIdentidad));
        if (eliminado) {
            System.out.println("Estudiante dado de baja exitosamente.");
        } else {
            System.out.println("No se encontró un estudiante con el documento " + documentoIdentidad);
        }
    }

    public Optional<EstudianteGuarderia> buscarEstudiante(String documentoIdentidad) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getDocumentoIdentidad().equals(documentoIdentidad))
                .findFirst();
    }

    public void listarEstudiantes() {
        System.out.println("\nListado de estudiantes en " + nombreGuarderia + ":");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes matriculados.");
        } else {
            estudiantes.forEach(System.out::println);
        }
    }

    public int getTotalEstudiantes() {
        return estudiantes.size();
    }
}

public class SistemaGuarderiaV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministradorGuarderia admin = new AdministradorGuarderia("Pequeños Gigantes V2");
        System.out.println("=== Sistema de Guardería V2 ===");

        while (true) {
            System.out.println("\n1. Matricular estudiante");
            System.out.println("2. Dar de baja estudiante");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Listar estudiantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    System.out.print("Documento Identidad: ");
                    String documento = scanner.nextLine();
                    System.out.print("Alergias: ");
                    String alergias = scanner.nextLine();
                    System.out.print("Nombre Acudiente: ");
                    String acudiente = scanner.nextLine();
                    System.out.print("Teléfono Contacto: ");
                    String telefono = scanner.nextLine();

                    admin.matricularEstudiante(new EstudianteGuarderia(nombre, edad, genero, documento, alergias, acudiente, telefono));
                    break;
                case 2:
                    System.out.print("Documento Identidad del estudiante a eliminar: ");
                    String docEliminar = scanner.nextLine();
                    admin.darDeBaja(docEliminar);
                    break;
                case 3:
                    System.out.print("Documento Identidad del estudiante a buscar: ");
                    String docBuscar = scanner.nextLine();
                    admin.buscarEstudiante(docBuscar).ifPresentOrElse(
                            estudiante -> System.out.println("Estudiante encontrado: " + estudiante),
                            () -> System.out.println("No se encontró el estudiante."));
                    break;
                case 4:
                    admin.listarEstudiantes();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}