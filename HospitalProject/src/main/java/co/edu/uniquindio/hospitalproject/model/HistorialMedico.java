package co.edu.uniquindio.hospitalproject.model;

import java.time.LocalDate;

public record HistorialMedico(Paciente paciente, String diagnostico, String tratamiento, LocalDate fechaConsulta) {
}
