package org.edu.uniquindio;

public class DatosDePrueba {
    public static void cargarDatos(Batallon batallon) {
        // Crear vehículos de prueba
        batallon.agregarVehiculo(new Vehiculo("V001", "Tanque T-90", 2010, 5000, 60, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V002", "Camión Logístico", 2015, 20000, 30, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V003", "Vehículo Médico", 2018, 15000, 10, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V004", "Vehículo Blindado", 2012, 8000, 70, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V005", "Vehículo de Reconocimiento", 2016, 12000, 25, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V006", "Camión de Suministros", 2014, 18000, 50, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V007", "Vehículo de Transporte", 2017, 30000, 15, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V008", "Vehículo de Combate", 2011, 22000, 45, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V009", "Tanque Leopard", 2009, 7000, 80, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V010", "Vehículo de Logística", 2013, 25000, 55, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V011", "Vehículo de Apoyo", 2019, 5000, 5, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V012", "Tanque Challenger", 2008, 3000, 90, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V013", "Vehículo de Rescate", 2020, 12000, 12, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V014", "Vehículo de Comunicaciones", 2021, 6000, 20, EstadoOperativo.DISPONIBLE));
        batallon.agregarVehiculo(new Vehiculo("V015", "Vehículo de Entrenamiento", 2022, 8000, 3, EstadoOperativo.DISPONIBLE));

        // Crear misiones de prueba
        batallon.agregarMision(new Mision("M001", "Operación Alpha", "2025-04-01", "Grupo A", null));
        batallon.agregarMision(new Mision("M002", "Operación Beta", "2025-04-05", "Grupo B", null));
        batallon.agregarMision(new Mision("M003", "Operación Charlie", "2025-04-10", "Grupo C", null));
        batallon.agregarMision(new Mision("M004", "Operación Delta", "2025-04-15", "Grupo D", null));
        batallon.agregarMision(new Mision("M005", "Operación Echo", "2025-04-20", "Grupo E", null));
        batallon.agregarMision(new Mision("M006", "Operación Foxtrot", "2025-04-25", "Grupo F", null));
        batallon.agregarMision(new Mision("M007", "Operación Golf", "2025-04-30", "Grupo G", null));
        batallon.agregarMision(new Mision("M008", "Operación Hotel", "2025-05-05", "Grupo H", null));
        batallon.agregarMision(new Mision("M009", "Operación India", "2025-05-10", "Grupo I", null));
        batallon.agregarMision(new Mision("M010", "Operación Juliett", "2025-05-15", "Grupo J", null));
        batallon.agregarMision(new Mision("M011", "Operación Kilo", "2025-05-20", "Grupo K", null));
        batallon.agregarMision(new Mision("M012", "Operación Lima", "2025-05-25", "Grupo L", null));
        batallon.agregarMision(new Mision("M013", "Operación Mike", "2025-05-30", "Grupo M", null));
        batallon.agregarMision(new Mision("M014", "Operación November", "2025-06-04", "Grupo N", null));
        batallon.agregarMision(new Mision("M015", "Operación Oscar", "2025-06-09", "Grupo O", null));
    }
}
