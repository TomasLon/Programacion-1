package co.edu.uniquindio.hospitalproject.model.enums;

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

    public static Especializacion fromTexto(String texto) {
        for (Especializacion e : values()) {
            if (e.especializacion.equalsIgnoreCase(texto)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Especialización inválida: " + texto);
    }


    @Override
    public String toString() {
        return especializacion;
    }
}
