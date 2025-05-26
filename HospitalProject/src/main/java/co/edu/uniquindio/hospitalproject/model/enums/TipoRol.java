package co.edu.uniquindio.hospitalproject.model.enums;

public enum TipoRol {

    PACIENTE("Paciente"),
    DOCTOR("Doctor"),
    ADMIN("Administrador");

    public final String tipoRol;

    TipoRol(String tipoRol){
        this.tipoRol = tipoRol;
    }

    public static TipoRol fromTexto(String texto) {
        for (TipoRol rol : values()) {
            if (rol.tipoRol.equalsIgnoreCase(texto)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("Género inválido: " + texto);
    }

    @Override
    public String toString() {
        return tipoRol;
    }
}
