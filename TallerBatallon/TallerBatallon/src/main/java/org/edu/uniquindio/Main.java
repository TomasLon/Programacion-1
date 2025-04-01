package org.edu.uniquindio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Batallon batallon = new Batallon();
        DatosDePrueba.cargarDatos(batallon);

        String[] opciones = {
                "Agregar vehículo", "Eliminar vehículo", "Buscar vehículo", "Actualizar vehículo", "Listar vehículos",
                "Agregar misión", "Eliminar misión", "Buscar misión", "Actualizar misión", "Listar misiones",
                "Vehículos con más de 50 misiones", "Salir"
        };

        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                    null, "Seleccione una opción:", "Menú Batallón", JOptionPane.PLAIN_MESSAGE,
                    null, opciones, opciones[0]
            );

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }

            switch (opcionSeleccionada) {
                case "Agregar vehículo":
                    batallon.agregarVehiculo(pedirDatosVehiculo());
                    break;
                case "Eliminar vehículo":
                    batallon.eliminarVehiculo(JOptionPane.showInputDialog("Ingrese el ID del vehículo a eliminar:"));
                    break;
                case "Buscar vehículo":
                    Vehiculo v = batallon.buscarVehiculo(JOptionPane.showInputDialog("Ingrese el ID del vehículo a buscar:"));
                    JOptionPane.showMessageDialog(null, (v != null) ? v.toString() : "Vehículo no encontrado.");
                    break;
                case "Actualizar vehículo":
                    batallon.actualizarVehiculo(pedirDatosVehiculo());
                    break;
                case "Listar vehículos":
                    batallon.listarVehiculos();
                    break;
                case "Agregar misión":
                    batallon.agregarMision(pedirDatosMision());
                    break;
                case "Eliminar misión":
                    batallon.eliminarMision(JOptionPane.showInputDialog("Ingrese el ID de la misión a eliminar:"));
                    break;
                case "Buscar misión":
                    Mision m = batallon.buscarMision(JOptionPane.showInputDialog("Ingrese el ID de la misión a buscar:"));
                    JOptionPane.showMessageDialog(null, (m != null) ? m.toString() : "Misión no encontrada.");
                    break;
                case "Actualizar misión":
                    batallon.actualizarMision(pedirDatosMision());
                    break;
                case "Listar misiones":
                    batallon.listarMisiones();
                    break;
                case "Vehículos con más de 50 misiones":
                    batallon.listarVehiculosConMasDe50Misiones();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo.");
            }
        }
    }

    private static Vehiculo pedirDatosVehiculo() {
        return new Vehiculo(
                JOptionPane.showInputDialog("Ingrese el ID del vehículo:"),
                JOptionPane.showInputDialog("Ingrese el modelo del vehículo:"),
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricación:")),
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje:")),
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de misiones completadas:")),
                EstadoOperativo.valueOf(JOptionPane.showInputDialog("Ingrese el estado del vehículo (OPERATIVO/NO_OPERATIVO):").toUpperCase())
        );
    }

    private static Mision pedirDatosMision() {
        return new Mision(
                JOptionPane.showInputDialog("Ingrese el ID de la misión:"),
                JOptionPane.showInputDialog("Ingrese la fecha de la misión:"),
                JOptionPane.showInputDialog("Ingrese la ubicación de la misión:"),
                JOptionPane.showInputDialog("Ingrese el personal asignado:"),
                null // Aquí podrías agregar una lógica para asociar un vehículo
        );
    }
}