package co.edu.uniquindio.hospitalproject.model.enums;

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

    public static Genero fromTexto(String texto) {
        for (Genero g : values()) {
            if (g.genero.equalsIgnoreCase(texto)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Género inválido: " + texto);
    }

    @Override
    public String toString() {
        return genero;
    }
}
