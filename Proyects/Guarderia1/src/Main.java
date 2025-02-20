import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int cantidadEstudiantes=1;
        ArrayList<Estudiante> listaEstudiantes = new ArrayList <Estudiante>();
        Estudiante estudiante1 = new Estudiante("Juan Pérez", 15, "Masculino", "ID001", "Ninguna", "María Pérez", "123456789");
        Estudiante estudiante2 = new Estudiante("Ana Gómez", 14, "Femenino", "ID002", "Polen", "Carlos Gómez", "987654321");
        Estudiante estudiante3 = new Estudiante("Luis Fernández", 16, "Masculino", "ID003", "Lácteos", "Lucía Fernández", "456789123");
        Estudiante estudiante4 = new Estudiante("Sofía Ramírez", 15, "Femenino", "ID004", "Gluten", "Jorge Ramírez", "789123456");
        Estudiante estudiante5 = new Estudiante("Carlos Torres", 14, "Masculino", "ID005", "Nueces", "Elena Torres", "321654987");

        listaEstudiantes.add(estudiante1);
        listaEstudiantes.add(estudiante2);
        listaEstudiantes.add(estudiante3);
        listaEstudiantes.add(estudiante4);
        listaEstudiantes.add(estudiante5);

        for(int i = 0; i < cantidadEstudiantes; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el edad del estudiante"));
            String genero = JOptionPane.showInputDialog("Ingrese el genero del estudiante");
            String identificacion = JOptionPane.showInputDialog("Ingrese el identificacion del estudiente");
            String alergias = JOptionPane.showInputDialog("Ingrese alergias del estudiante");
            String nombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre del acudiente del estudiante");
            String telefonoContacto = JOptionPane.showInputDialog("Ingrese el telefono del acudiente del estudiante");

            Estudiante newEstudiante =
                    new Estudiante(nombre, edad, genero, identificacion, alergias,
                            nombreAcudiente, telefonoContacto);
            JOptionPane.showMessageDialog(null, newEstudiante);
            listaEstudiantes.add(newEstudiante);

        }




    }


}