package org.edu.uniquindio.proyectofinal.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Administrador extends Persona{

    LinkedList<Medico> listMedicos = new LinkedList<>();
    LinkedList<Paciente> listPacientes = new LinkedList<>();



    public Administrador(String nombre, String apellido, String id,
                         LocalDate fechaNacimiento, String genero, String telefono, String grupoSanguineo) {
        super(nombre, apellido, id, fechaNacimiento, genero, telefono, grupoSanguineo);
    }
}
