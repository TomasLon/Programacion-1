package co.edu.uniquindio.hospitalproject.controller;


import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Paciente;

import java.util.Collection;

public class CrudPacienteController {
    Hospital hospital;

    public CrudPacienteController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean crearPaciente(Paciente paciente) {
        return hospital.crearPersona(paciente);
    }

    public boolean eliminarPaciente(String idPaciente){
        return hospital.eliminarPersona(idPaciente);
    }

    public boolean modificarPaciente(String idPaciente, Paciente pacienteActualizar) {
        return hospital.actualizarPersona(idPaciente, pacienteActualizar);
    }

    public Collection<Paciente> listarPacientes() {
        return hospital.listarPersonasPorTipo(Paciente.class);
    }



}
