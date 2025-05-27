package co.edu.uniquindio.hospitalproject.model;

import java.time.LocalDate;

public record Notificacion(String mensaje, Paciente destinatario, LocalDate fecha) {
}
