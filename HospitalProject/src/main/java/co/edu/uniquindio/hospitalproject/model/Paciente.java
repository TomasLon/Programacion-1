package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;


import java.time.LocalDate;

public class Paciente extends Persona {

    //Atributos propios de Paciente
    private String email;
    private String telefono;

    //Constructor de paciente extendido con Persona

    public Paciente(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                    Genero genero, TipoSangre tipoSangre, String email, String telefono) {
        super(id, nombre, apellido, fechaNacimiento, genero, tipoSangre);

        this.email = email;
        this.telefono = telefono;
    }


    //Getter's and setter's

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return getNombre() + " " + getApellido();
    }




}

