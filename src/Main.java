import java.util.ArrayList;
import java.util.List;

class Empleado {
    private String identificacion;
    private String nombreCompleto;
    private String puesto;
    private String correo;
    private String telefono;
    private String fechaContratacion;

    public Empleado(String identificacion, String nombreCompleto, String puesto, String correo, String telefono, String fechaContratacion) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Identificacion='" + identificacion + '\'' +
                ", Nombre='" + nombreCompleto + '\'' +
                ", Puesto='" + puesto + '\'' +
                ", Correo='" + correo + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Fecha Contratacion='" + fechaContratacion + '\'' +
                '}';
    }
}

public class Main {
    private static List<Empleado> empleados = new ArrayList<>();

    public static void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public static Empleado buscarEmpleadoPorId(String id) {
        for (Empleado e : empleados) {
            if (e.getIdentificacion().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public static void listarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Empleado emp1 = new Empleado("001", "Ana Gómez", "Desarrolladora", "ana@email.com", "123456789", "2023-05-10");
        Empleado emp2 = new Empleado("002", "Carlos Pérez", "Analista", "carlos@email.com", "987654321", "2022-08-15");

        agregarEmpleado(emp1);
        agregarEmpleado(emp2);

        System.out.println("Lista de empleados:");
        listarEmpleados();

        System.out.println("\nBúsqueda de empleado con ID 001:");
        System.out.println(buscarEmpleadoPorId("001"));
    }
}
