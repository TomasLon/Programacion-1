package org.edu.uniquindio;

public class Mision {
    private String fecha;
    private String ubicacion;
    private String personalAsignado;
    private Vehiculo vehiculosUtilizados; // Suponiendo que es un único vehículo; cambiar a arreglo si es necesario.

    public Mision(String id, String fecha, String ubicacion, String personalAsignado, Vehiculo vehiculosUtilizados) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personalAsignado = personalAsignado;
        this.vehiculosUtilizados = vehiculosUtilizados;
    }

    // Getters y Setters

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPersonalAsignado() {
        return personalAsignado;
    }

    public void setPersonalAsignado(String personalAsignado) {
        this.personalAsignado = personalAsignado;
    }

    public Vehiculo getVehiculosUtilizados() {
        return vehiculosUtilizados;
    }

    public void setVehiculosUtilizados(Vehiculo vehiculosUtilizados) {
        this.vehiculosUtilizados = vehiculosUtilizados;
    }
}
