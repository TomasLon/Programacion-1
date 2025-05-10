package org.edu.uniquindio.proyectofinal.model.enums;

/**
 * Enum que representa los tipos de géneros disponibles a elegir
 */

public enum Genero {
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    OTRO("Otro");

    public final String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
}
