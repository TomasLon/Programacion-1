package co.edu.uniquindio.hospitalproject.model.enums;

public enum TipoSangre {
    APOSITIVO("A+"),
    BPOSITIVO("B+"),
    OPOSITIVO("O+"),
    ABPOSITIVO("AB+"),
    ANEGATIVO("A-"),
    BNEGATIVO("B-"),
    ONEGATIVO("O-"),
    ABNEGATIVO("AB-");

    public final String tipoSangre;

    TipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public static TipoSangre fromTexto(String texto) {
        for (TipoSangre t : values()) {
            if (t.tipoSangre.equalsIgnoreCase(texto)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Género inválido: " + texto);
    }

    @Override
    public String toString() {
        return tipoSangre;
    }
}
