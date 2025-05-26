package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Doctor;
import co.edu.uniquindio.hospitalproject.model.Hospital;

import java.util.Collection;

public class CrudDoctorController {

    Hospital hospital;

    public CrudDoctorController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean agregarDoctor(Doctor newDoctor) {
        return hospital.crearPersona(newDoctor);
    }

    public boolean eliminarDoctor(String idDoctor) {
        return hospital.eliminarPersona(idDoctor);
    }

    public boolean actualizarDoctor(String idDoctorAct, Doctor doctorActualizar) {
        return hospital.actualizarPersona(idDoctorAct, doctorActualizar);
    }

    public Collection<Doctor> listarDoctores () {
        return hospital.listarPersonasPorTipo(Doctor.class);
    }

}
