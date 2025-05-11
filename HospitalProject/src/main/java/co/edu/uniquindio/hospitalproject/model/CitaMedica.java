package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.EstadoCita;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica {
    //Atributos
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private Paciente pacienteAsignado;
    private Doctor doctorAsignado;
    private Sala salaAsignada;
    private EstadoCita estadoCita;

    //Constructor
    public CitaMedica(LocalDate fechaCita, LocalTime horaCita, Paciente pacienteAsignado, Doctor doctorAsignado,
                      Sala salaAsignada, EstadoCita estadoCita) {
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.pacienteAsignado = pacienteAsignado;
        this.doctorAsignado = doctorAsignado;
        this.salaAsignada = salaAsignada;
        this.estadoCita = estadoCita;
    }

    //getter's and setter's
    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public void setDoctorAsignado(Doctor doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public Sala getSalaAsignada() {
        return salaAsignada;
    }

    public void setSalaAsignada(Sala salaAsignada) {
        this.salaAsignada = salaAsignada;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }
}
