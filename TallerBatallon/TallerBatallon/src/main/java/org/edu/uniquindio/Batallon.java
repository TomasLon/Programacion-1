package org.edu.uniquindio;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Batallon {
    private List<Vehiculo> vehiculos;
    private List<Mision> misiones;

    public Batallon() {
        this.vehiculos = new ArrayList<>();
        this.misiones = new ArrayList<>();
    }

    // Vehículos
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null || buscarVehiculo(vehiculo.getId()) != null) return false;
        return vehiculos.add(vehiculo);
    }

    public boolean eliminarVehiculo(String id) {
        return vehiculos.removeIf(v -> v.getId().equals(id));
    }

    public Vehiculo buscarVehiculo(String id) {
        return vehiculos.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean actualizarVehiculo(Vehiculo vehiculoActualizado) {
        Vehiculo vehiculo = buscarVehiculo(vehiculoActualizado.getId());
        if (vehiculo == null) return false;
        vehiculos.remove(vehiculo);
        return vehiculos.add(vehiculoActualizado);
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos en el batallón.");
            return;
        }
        StringBuilder mensaje = new StringBuilder("Lista de Vehículos:\n");
        for (Vehiculo v : vehiculos) {
            mensaje.append(v.getId()).append(" - ").append(v.getModelo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public void listarVehiculosConMasDe50Misiones() {
        List<Vehiculo> vehiculosFiltrados = vehiculos.stream()
                .filter(v -> v.getCantidadMisiones() > 50)
                .toList();

        if (vehiculosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos con más de 50 misiones.");
            return;
        }

        StringBuilder mensaje = new StringBuilder("Vehículos con más de 50 misiones:\n");
        for (Vehiculo v : vehiculosFiltrados) {
            mensaje.append(v.getId()).append(" - ").append(v.getModelo()).append(" (Misiones: ")
                    .append(v.getCantidadMisiones()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    // Misiones
    public boolean agregarMision(Mision mision) {
        if (mision == null || buscarMision(mision.getId()) != null) return false;
        return misiones.add(mision);
    }

    public boolean eliminarMision(String id) {
        return misiones.removeIf(m -> m.getId().equals(id));
    }

    public Mision buscarMision(String id) {
        return misiones.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean actualizarMision(Mision misionActualizada) {
        Mision mision = buscarMision(misionActualizada.getId());
        if (mision == null) return false;
        misiones.remove(mision);
        return misiones.add(misionActualizada);
    }

    public void listarMisiones() {
        if (misiones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay misiones en el batallón.");
            return;
        }
        StringBuilder mensaje = new StringBuilder("Lista de Misiones:\n");
        for (Mision m : misiones) {
            mensaje.append(m.getId()).append(" - ").append(m.getUbicacion()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}