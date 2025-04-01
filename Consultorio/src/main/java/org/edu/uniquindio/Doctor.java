package org.edu.uniquindio;

import java.time.LocalDate;

public class Doctor extends Persona{
    private double sueldo;
    private boolean licenciaProfesional;

    public Doctor(String nombre, String cedula, int edad, LocalDate fechaNacimiento, double sueldo, boolean b) {
        super(nombre, cedula, edad, fechaNacimiento);

        this.licenciaProfesional = licenciaProfesional;
        this.sueldo = sueldo;
    }
}
