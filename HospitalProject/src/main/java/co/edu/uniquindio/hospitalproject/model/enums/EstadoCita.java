package co.edu.uniquindio.hospitalproject.model.enums;

public enum EstadoCita {

    PENDIENTE("Pendiente"),
    CONFIRMADA("Confirmada"),
    ENESPERA("En espera"),
    FINALIZADA("Finalizada"),
    CANCELADA("Cancelada"),
    REPROGRAMADA("Reprogramada");

    public final String estadoCita;

    EstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    @Override
    public String toString() {
        return estadoCita;
    }
}
