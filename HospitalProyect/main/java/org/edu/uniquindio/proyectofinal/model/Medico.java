package org.edu.uniquindio.proyectofinal.model;

import org.edu.uniquindio.proyectofinal.model.enums.Especialidad;
import java.time.LocalDate;

public class Medico extends Persona {

    private Especialidad especialidad;
    private String licenciaMedica;
    private boolean disponibilidad;

    public Medico(String nombre, String apellido, String id, LocalDate fechaNacimiento, String genero, String telefono, String grupoSanguineo, Especialidad especialidad) {
        super(nombre, apellido, id, fechaNacimiento, genero, telefono, grupoSanguineo);
        this.especialidad = especialidad;
        this.licenciaMedica = licenciaMedica;
        this.disponibilidad = disponibilidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public void setLicenciaMedica(String licencia) {
        this.licenciaMedica = licencia;
    }
    public String getLicenciaMedica() {
        return licenciaMedica;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
