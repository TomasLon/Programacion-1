package org.edu.uniquindio;

public class Apoyo extends Vehiculo {
    private Funcion Funcion;

    public Apoyo(String id, String modelo, int anioFabricacion, int kilometraje, int cantidadMisiones, EstadoOperativo estado, Funcion Funcion) {
        super(id, modelo, anioFabricacion, kilometraje, cantidadMisiones, estado);
        this.Funcion = Funcion;
    }

    public Funcion getFuncion() {
        return Funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.Funcion = funcion;
    }
}

