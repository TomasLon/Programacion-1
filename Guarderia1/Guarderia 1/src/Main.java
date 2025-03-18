import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int cantEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        Estudiante estudiante1 = new Estudiante("Juan Pérez", 3, "Masculino", "1",
                "Ninguna", "María Pérez", "123456789");

        Estudiante estudiante2 = new Estudiante("Ana Gómez", 2, "Femenino", "2",
                "Polen", "Carlos Gómez", "987654321");

        Estudiante estudiante3 = new Estudiante("Luis Martínez", 8, "Masculino", "3",
                "Mariscos", "Elena Martínez", "456123789");

        Estudiante estudiante4 = new Estudiante("Sofía Ramírez", 4, "Femenino", "4",
                "Ninguna", "Roberto Ramírez", "789321456");

        Estudiante estudiante5 = new Estudiante("Miguel Torres", 6, "Masculino", "5",
                "Lácteos", "Laura Torres", "321654987");

        listaEstudiantes.add(estudiante1);
        listaEstudiantes.add(estudiante2);
        listaEstudiantes.add(estudiante3);
        listaEstudiantes.add(estudiante4);
        listaEstudiantes.add(estudiante5);

        for(int i = 1; i <= cantEstudiantes; i++){
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
            String genero = JOptionPane.showInputDialog("Ingrese el genero");
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion");
            String alergias = JOptionPane.showInputDialog("Ingrese si tiene alergias");
            String nombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre del acudiente");
            String numAcudiente = JOptionPane.showInputDialog("Ingrese el numero de contacto del acudiente");

            Estudiante newEstudiante =
                    new Estudiante(nombre, edad, genero, identificacion,
                            alergias, nombreAcudiente, numAcudiente);

            listaEstudiantes.add(newEstudiante);
        }

        JOptionPane.showMessageDialog(null, listaEstudiantes);

    }
}