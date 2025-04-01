package org.edu.uniquindio;

import java.time.LocalDate;

public class Paciente extends Persona{

    public Paciente(String nombre, String cedula, int edad, LocalDate fechaNacimiento) {
        super(nombre, cedula, edad, fechaNacimiento);
    }


}
