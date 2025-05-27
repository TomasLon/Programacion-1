package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Administrador;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Usuario;

import java.util.Collection;
import java.util.LinkedList;

public class AdminController {
    
    Hospital hospital;
    
    public AdminController(Hospital hospital) {
        this.hospital = hospital;
    }
    
    public String retornarNombreAdmin(String username){
        Collection<Administrador> listAdminComparar = hospital.listarAdmin();
        LinkedList<Usuario> listUsersComparar = hospital.getListUsers();
        for (Usuario usuarioComparar : listUsersComparar) {
            if (usuarioComparar.getUsuario().equals(username)) {
                for (Administrador administradorComparar : listAdminComparar) {
                    if (usuarioComparar.getPersona().getCedula().equals(administradorComparar.getCedula())) {
                        return administradorComparar.getNombre()+" "+administradorComparar.getApellido();
                    }
                }
                break;
            }

        }
        return "Desconocido";
    }

}
