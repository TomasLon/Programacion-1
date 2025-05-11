package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;


import java.time.LocalDate;

public class Paciente extends Persona {

    //Atributos propios de Paciente
    private String direccion;
    private String email;
    private int telefono;

    //Constructor de paciente extendido con Persona

    public Paciente(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                    Genero genero, TipoSangre tipoSangre, String direccion, String email, int telefono) {
        super(id, nombre, apellido, fechaNacimiento, genero, tipoSangre);

        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }


    //Getter's and setter's

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

