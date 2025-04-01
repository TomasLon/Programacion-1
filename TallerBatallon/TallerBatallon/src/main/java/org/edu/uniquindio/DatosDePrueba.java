package org.edu.uniquindio;

public class DatosDePrueba {
    public static void cargarDatos(Batallon batallon) {
        // Crear vehículos de prueba
        batallon.agregarVehiculo(new Vehiculo("V001", "Tanque T-90", 2010, 5000, 60, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V002", "Camión Logístico", 2015, 20000, 30, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V003", "Vehículo Médico", 2018, 15000, 10, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V004", "Vehículo Blindado", 2012, 8000, 70, EstadoOperativo.DISPONIBLE));

        // Crear misiones de prueba
        batallon.agregarMision(new Mision("M001", "Operación Alpha", "2025-04-01", null, null));
        batallon.agregarMision(new Mision("M002", "Operación Beta", "2025-04-05", null, null));
        batallon.agregarMision(new Mision("M003", "Operación Charlie", "2025-04-10", null, null));
        batallon.agregarMision(new Mision("M004", "Operación Delta", "2025-04-15", null, null));
    }
}
