package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Doctor;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import co.edu.uniquindio.hospitalproject.model.Usuario;

import java.util.Collection;
import java.util.LinkedList;

public class PacienteController {

    Hospital hospital;

    public PacienteController(Hospital hospital) {
        this.hospital = hospital;
    }

    public String retornarNombrePaciente(String username){
        Collection<Paciente> listPacientesComparar = hospital.listarPersonasPorTipo(Paciente.class);
        LinkedList<Usuario> listUsersComparar = hospital.getListUsers();
        for (Usuario usuarioComparar : listUsersComparar) {
            if (usuarioComparar.getUsuario().equals(username)) {
                for (Paciente pacienteComparar : listPacientesComparar) {
                    if (usuarioComparar.getPersona().getCedula().equals(pacienteComparar.getCedula())) {
                        return pacienteComparar.getNombre()+" "+pacienteComparar.getApellido();
                    }
                }
                break;
            }

        }
        return "Desconocido";
    }

}
