package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Sala;

import java.util.Collection;

public class CrudSalasController {

    Hospital hospital;

    public CrudSalasController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean crearSala(Sala newSala){
        return hospital.crearSala(newSala);
    }

    public boolean eliminarSala(String idSala){
        return hospital.eliminarSala(idSala);
    }

    public boolean modificarSala(String idSalaAct, Sala newSala){
        return hospital.actualizarSala(idSalaAct, newSala);
    }

    public Collection<Sala> listarSalas(){
        return hospital.listarSala();
    }

}
