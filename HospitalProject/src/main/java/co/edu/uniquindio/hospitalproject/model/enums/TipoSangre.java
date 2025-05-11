package co.edu.uniquindio.hospitalproject.model.enums;

public enum TipoSangre {
    A("A"),
    B("B"),
    O("O"),
    AB("AB");

    public final String tipoSangre;

    TipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    @Override
    public String toString() {
        return tipoSangre;
    }
}
