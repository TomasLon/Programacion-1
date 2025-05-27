package co.edu.uniquindio.hospitalproject.model.Interfaces;

import co.edu.uniquindio.hospitalproject.model.Sala;
import java.util.Collection;

public interface ICRUDSala {

    boolean crearSala(Sala sala);
    boolean eliminarSala(String idSala);
    boolean actualizarSala(String idSala, Sala salaActual);
    Collection<Sala> listarSala();

}
