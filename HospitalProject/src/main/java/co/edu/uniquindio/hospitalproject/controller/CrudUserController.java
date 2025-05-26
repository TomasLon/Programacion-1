package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Persona;
import co.edu.uniquindio.hospitalproject.model.Usuario;

import java.util.Collection;

public class CrudUserController {

    Hospital hospital;

    public CrudUserController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean crearUser(Usuario newUsuario) {
        return hospital.crearUsuario(newUsuario);
    }

    public boolean eliminarUsuario(String id) {
        return hospital.eliminarUsuario(id);
    }

    public boolean modificarUsuario(String id, Usuario usuario) {
        return hospital.actualizarUsuario(id, usuario);
    }

    public Collection<Usuario> listarUsuarios() {
        return hospital.listarUsuarios();
    }

    public Persona buscarPersonaID(String id) {
        return hospital.verificarPersonaID(id);
    }

}
