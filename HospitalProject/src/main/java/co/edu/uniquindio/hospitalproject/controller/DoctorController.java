package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Administrador;
import co.edu.uniquindio.hospitalproject.model.Doctor;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Usuario;

import java.util.Collection;
import java.util.LinkedList;

public class DoctorController {

    Hospital hospital;

    public DoctorController(Hospital hospital) {
        this.hospital = hospital;
    }

    public String retornarNombreDoc(String username){
        Collection<Doctor> listDoctorComparar = hospital.listarPersonasPorTipo(Doctor.class);
        LinkedList<Usuario> listUsersComparar = hospital.getListUsers();
        for (Usuario usuarioComparar : listUsersComparar) {
            if (usuarioComparar.getUsuario().equals(username)) {
                for (Doctor doctorComparar : listDoctorComparar) {
                    if (usuarioComparar.getPersona().getCedula().equals(doctorComparar.getCedula())) {
                        return doctorComparar.getNombre()+" "+doctorComparar.getApellido();
                    }
                }
                break;
            }

        }
        return "Desconocido";
    }

}
