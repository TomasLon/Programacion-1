package org.edu.uniquindio.proyectofinal.model.enums;

/**
 * Enum que representa las especializaciones médicas disponibles.
 */

public enum Especializacion {
    MEDICOGENERAL("Médico general"),
    ODONTOLOGO("Odontólogo"),
    OFTALMOLOGO("Oftalmólogo"),
    INMUNOLOGO("Inmunólogo"),
    ONCOLOGO("Oncólogo"),
    NEUROLOGO("Neurólogo"),
    REUMATOLOGO("Reumatólogo");

    public final String especializacion;

    Especializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    @Override
    public String toString() {
        return especializacion;
    }
}
