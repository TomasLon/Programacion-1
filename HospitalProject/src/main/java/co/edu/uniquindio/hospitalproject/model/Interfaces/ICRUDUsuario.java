package co.edu.uniquindio.hospitalproject.model.Interfaces;

import co.edu.uniquindio.hospitalproject.model.Usuario;
import java.util.Collection;

public interface ICRUDUsuario {

    boolean crearUsuario(Usuario usuario);
    boolean eliminarUsuario(String usuario);
    boolean actualizarUsuario(String usuario, Usuario usuario01);
    Collection<Usuario> listarUsuarios();
}
