package org.edu.uniquindio.proyectofinal.model;

import org.edu.uniquindio.proyectofinal.model.enums.Genero;
import org.edu.uniquindio.proyectofinal.model.enums.TipoRol;
import org.edu.uniquindio.proyectofinal.model.enums.TipoSangre;

import java.time.LocalDate;

public class Usuario extends Persona{

    //Atributos propios de clase usuario (Para el LogIN)
    private String Usuario;
    private String Password;
    private TipoRol tipoRol;

    //Constructor de usuario extendido de Persona
    public Usuario(String id, String nombre, String apellido, LocalDate fechaNacimiento, Genero genero,
                   TipoSangre tipoSangre, String Usuario, String Password, TipoRol tipoRol) {
        super(id, nombre, apellido, fechaNacimiento, genero, tipoSangre);
        this.Usuario = Usuario;
        this.Password = Password;
        this.tipoRol = tipoRol;
    }

    //getter's and setter's

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }
}
