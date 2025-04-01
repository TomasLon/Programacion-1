package org.edu.uniquindio;


import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate fechaNacimiento = LocalDate.of(2007, 2, 9);

        Paciente nuevoPaciente =
                new Paciente("Pepito", "109", 16, LocalDate.of(2005, 4, 20));

        Doctor nuevoDoctor =
                new Doctor("Dr. Houuse", "1099", 20, LocalDate.of(2000, 10, 2), 1000000, true);
    }
}