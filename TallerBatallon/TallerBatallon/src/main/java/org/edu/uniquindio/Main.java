package org.edu.uniquindio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Batallon batallon = new Batallon(10, 10);
        DatosDePrueba.cargarDatos(batallon); // Cargar datos de prueba

        String[] opciones = {
                "Agregar vehículo",
                "Eliminar vehículo",
                "Buscar vehículo",
                "Actualizar vehículo",
                "Agregar misión",
                "Eliminar misión",
                "Buscar misión",
                "Actualizar misión",
                "Vehículos con más de 50 misiones",
                "Salir"
        };

        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Batallón",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }

            switch (opcionSeleccionada) {
                case "Agregar vehículo":
                    agregarVehiculo(batallon);
                    break;
                case "Eliminar vehículo":
                    eliminarVehiculo(batallon);
                    break;
                case "Buscar vehículo":
                    buscarVehiculo(batallon);
                    break;
                case "Actualizar vehículo":
                    actualizarVehiculo(batallon);
                    break;
                case "Agregar misión":
                    agregarMision(batallon);
                    break;
                case "Eliminar misión":
                    eliminarMision(batallon);
                    break;
                case "Buscar misión":
                    buscarMision(batallon);
                    break;
                case "Vehículos con más de 50 misiones":
                    mostrarVehiculosFrecuentes(batallon);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo.");
            }
        }
    }

    // Métodos para agregar, eliminar, buscar, actualizar vehículos y misiones...
    // (Resto de métodos como los que ya has implementado anteriormente)



private static void agregarVehiculo(Batallon batallon) {
        try {
            String id = JOptionPane.showInputDialog("Ingrese el ID del vehículo:");
            if (id == null || id.trim().isEmpty()) return;

            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
            if (modelo == null || modelo.trim().isEmpty()) return;

            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricación:"));
            int kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje:"));
            int misiones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de misiones completadas:"));
            EstadoOperativo estado = EstadoOperativo.DISPONIBLE; // O asignar un estado según sea necesario

            Vehiculo nuevoVehiculo = new Vehiculo(id, modelo, anio, kilometraje, misiones, estado);
            if (batallon.agregarVehiculo(nuevoVehiculo)) {
                JOptionPane.showMessageDialog(null, "Vehículo agregado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: No se pudo agregar el vehículo (ID duplicado o sin espacio disponible).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numéricos válidos.");
        }
    }

    private static void eliminarVehiculo(Batallon batallon) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del vehículo a eliminar:");
        if (id == null || id.trim().isEmpty()) return;

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el vehículo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = batallon.eliminarVehiculo(id);
            JOptionPane.showMessageDialog(null, eliminado ? "Vehículo eliminado correctamente." : "Error: No se encontró el vehículo.");
        }
    }

    private static void buscarVehiculo(Batallon batallon) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del vehículo a buscar:");
        if (id == null || id.trim().isEmpty()) return;

        Vehiculo vehiculo = batallon.buscarVehiculo(id);
        JOptionPane.showMessageDialog(null, vehiculo != null ? "Vehículo encontrado: " + vehiculo.getModelo() : "Vehículo no encontrado.");
    }

    private static void actualizarVehiculo(Batallon batallon) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del vehículo a actualizar:");
        if (id == null || id.trim().isEmpty()) return;

        Vehiculo vehiculo = batallon.buscarVehiculo(id);
        if (vehiculo != null) {
            try {
                int nuevoKilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje:"));
                vehiculo.setKilometraje(nuevoKilometraje);
                batallon.actualizarVehiculo(vehiculo);
                JOptionPane.showMessageDialog(null, "Vehículo actualizado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    private static void agregarMision(Batallon batallon) {
        String id = JOptionPane.showInputDialog("Ingrese el ID de la misión:");
        if (id == null || id.trim().isEmpty()) return;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la misión:");
        if (nombre == null || nombre.trim().isEmpty()) return;

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la misión:");
        if (fecha == null || fecha.trim().isEmpty()) return;

        // Asignar un vehículo a la misión, si es necesario. Por ahora, se asigna null.
        Vehiculo vehiculoUtilizado = null; // Cambiar esto si quieres asignar un vehículo específico.

        Mision nuevaMision = new Mision(id, fecha, nombre, null, vehiculoUtilizado);
        if (batallon.agregarMision(nuevaMision)) {
            JOptionPane.showMessageDialog(null, "Misión agregada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo agregar la misión (ID duplicado o sin espacio disponible).");
        }
    }


    private static void eliminarMision(Batallon batallon) {
        String id = JOptionPane.showInputDialog("Ingrese el ID de la misión a eliminar:");
        if (id == null || id.trim().isEmpty()) return;

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la misión?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = batallon.eliminarMision(id);
            JOptionPane.showMessageDialog(null, eliminado ? "Misión eliminada correctamente." : "Error: No se encontró la misión.");
        }
    }

    private static void buscarMision(Batallon batallon) {
        String id = JOptionPane.showInputDialog("Ingrese el ID de la misión a buscar:");
        if (id == null || id.trim().isEmpty()) return;

        Mision mision = batallon.buscarMision(id);
        JOptionPane.showMessageDialog(null, mision != null ? "Misión encontrada: " + mision.getUbicacion() : "Misión no encontrada.");
    }

    private static void mostrarVehiculosFrecuentes(Batallon batallon) {
        Vehiculo[] vehiculos = batallon.obtenerVehiculosConMasDe50Misiones();
        if (vehiculos.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay vehículos con más de 50 misiones.");
        } else {
            StringBuilder mensaje = new StringBuilder("Vehículos con más de 50 misiones:\n");
            for (Vehiculo v : vehiculos) {
                mensaje.append(v.getModelo()).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }
}
