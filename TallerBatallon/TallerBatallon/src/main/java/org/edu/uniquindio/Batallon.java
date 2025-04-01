package org.edu.uniquindio;
import java.util.ArrayList;
import java.util.Arrays;

public class Batallon {
    private Vehiculo[] vehiculos;
    private Mision[] misiones;
    private int contadorVehiculos;
    private int contadorMisiones;

    public Batallon(int capacidadVehiculos, int capacidadMisiones) {
        vehiculos = new Vehiculo[capacidadVehiculos];
        misiones = new Mision[capacidadMisiones];
        contadorVehiculos = 0;
        contadorMisiones = 0;
    }

    // Vehículos

    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null || buscarVehiculo(vehiculo.getId()) != null) return false;
        if (contadorVehiculos < vehiculos.length) {
            vehiculos[contadorVehiculos++] = vehiculo;
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(String id) {
        int indice = buscarIndiceVehiculo(id);
        if (indice == -1) return false;

        System.arraycopy(vehiculos, indice + 1, vehiculos, indice, contadorVehiculos - indice - 1);
        vehiculos[--contadorVehiculos] = null;
        return true;
    }

    public Vehiculo buscarVehiculo(String id) {
        int indice = buscarIndiceVehiculo(id);
        return indice != -1 ? vehiculos[indice] : null;
    }

    public boolean actualizarVehiculo(Vehiculo vehiculoActualizado) {
        if (vehiculoActualizado == null) return false;
        int indice = buscarIndiceVehiculo(vehiculoActualizado.getId());
        if (indice == -1) return false;
        vehiculos[indice] = vehiculoActualizado;
        return true;
    }

    private int buscarIndiceVehiculo(String id) {
        for (int i = 0; i < contadorVehiculos; i++) {
            if (vehiculos[i] != null && vehiculos[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // Misiones

    public boolean agregarMision(Mision mision) {
        if (mision == null || buscarMision(mision.getId()) != null) return false;
        if (contadorMisiones < misiones.length) {
            misiones[contadorMisiones++] = mision;
            return true;
        }
        return false;
    }

    public boolean eliminarMision(String id) {
        int indice = buscarIndiceMision(id);
        if (indice == -1) return false;

        System.arraycopy(misiones, indice + 1, misiones, indice, contadorMisiones - indice - 1);
        misiones[--contadorMisiones] = null;
        return true;
    }

    public Mision buscarMision(String id) {
        int indice = buscarIndiceMision(id);
        return indice != -1 ? misiones[indice] : null;
    }

    public boolean actualizarMision(Mision misionActualizada) {
        if (misionActualizada == null) return false;
        int indice = buscarIndiceMision(misionActualizada.getId());
        if (indice == -1) return false;
        misiones[indice] = misionActualizada;
        return true;
    }

    private int buscarIndiceMision(String id) {
        for (int i = 0; i < contadorMisiones; i++) {
            if (misiones[i] != null && misiones[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // Método optimizado para obtener vehículos con más de 50 misiones

    public Vehiculo[] obtenerVehiculosConMasDe50Misiones() {
        ArrayList<Vehiculo> resultado = new ArrayList<>();

        for (int i = 0; i < contadorVehiculos; i++) {
            if (vehiculos[i].getCantidadMisiones() > 50) {
                resultado.add(vehiculos[i]);
            }
        }

        return resultado.toArray(new Vehiculo[0]);
    }
}
