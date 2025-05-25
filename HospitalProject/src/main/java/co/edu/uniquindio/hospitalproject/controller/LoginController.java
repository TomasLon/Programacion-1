package co.edu.uniquindio.hospitalproject.controller;

import co.edu.uniquindio.hospitalproject.model.Usuario;

import java.util.LinkedList;

public class LoginController {

    private LinkedList<Usuario>listUsers;

    public void setListUsers(LinkedList<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

    public boolean validarUsuario(String user, String password, String rolUser) {
        for (Usuario usuario : listUsers) {
            if (user.equals(usuario.getUsuario()) && password.equals(usuario.getPassword())
                    && rolUser.equals(usuario.getTipoRol().toString())) {
                return true;
            }
        }
        return false;
    }


}
