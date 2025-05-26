package co.edu.uniquindio.hospitalproject.model.Interfaces;

import co.edu.uniquindio.hospitalproject.model.Persona;
import java.util.Collection;


public interface ICRUDPersona {

    boolean crearPersona(Persona persona);
    boolean eliminarPersona(String id);
    boolean actualizarPersona(String id, Persona persona);
    <T extends Persona> Collection<T> listarPersonasPorTipo(Class<T> tipo);
}
