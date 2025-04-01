package org.edu.uniquindio;

public class Vehiculo {
    private String id;
    private String modelo;
    private int anioFabricacion;
    private int kilometraje;
    private int cantidadMisiones;
    private EstadoOperativo estado;

    public Vehiculo(String id, String modelo, int anioFabricacion, int kilometraje, int cantidadMisiones, EstadoOperativo estado) {
        this.id = id;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
        this.cantidadMisiones = cantidadMisiones;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getCantidadMisiones() {
        return cantidadMisiones;
    }

    public void setCantidadMisiones(int cantidadMisiones) {
        this.cantidadMisiones = cantidadMisiones;
    }

    public EstadoOperativo getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }
}
