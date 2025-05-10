package org.edu.uniquindio.proyectofinal.model;

import java.time.LocalDate;

public class Paciente extends Persona {
    private double numeroHistoriaClinica;

    public Paciente(String nombre, String apellido, String id, LocalDate fechaNacimiento,
                    String genero, String telefono, String grupoSanguineo, double numeroHistoriaClinica) {
        super(nombre, apellido, id, fechaNacimiento, genero, telefono, grupoSanguineo);

        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }
    public double getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }
    public void setNumeroHistoriaClinica(double numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }
}
