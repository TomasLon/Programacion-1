package org.edu.uniquindio;

public class Transportador extends Vehiculo {
        private int capacidadSoldados;

        public Transportador(String id, String modelo, int anioFabricacion, int kilometraje, int cantidadMisiones, EstadoOperativo estado, int capacidadSoldados) {
            super(id, modelo, anioFabricacion, kilometraje, cantidadMisiones, estado);
            this.capacidadSoldados = capacidadSoldados;
        }

        public int getCapacidadSoldados() {
            return capacidadSoldados;
        }

        public void setCapacidadSoldados(int capacidadSoldados) {
            this.capacidadSoldados = capacidadSoldados;
        }
}