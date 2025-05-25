package co.edu.uniquindio.hospitalproject.model.Interfaces;

import co.edu.uniquindio.hospitalproject.model.Administrador;
import co.edu.uniquindio.hospitalproject.model.Persona;

import java.util.Collection;

public interface ICRUDAdmin {

    boolean crearAdmin(Administrador administrador);
    boolean eliminarAdmin(String id);
    boolean actualizarAdmin(String id, Administrador administrador);
    Collection<Administrador> listarAdmin();
}
