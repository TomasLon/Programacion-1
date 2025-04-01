package org.edu.uniquindio;

public class Blindado extends Vehiculo {
    private int nivelBlindaje;

    public Blindado(String id, String modelo, int anioFabricacion, int kilometraje, int cantidadMisiones, EstadoOperativo estado, int nivelBlindaje) {
        super(id, modelo, anioFabricacion, kilometraje, cantidadMisiones, estado);
        this.nivelBlindaje = nivelBlindaje;
    }

    public int getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }
}