package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.model.enums.TipoRol;

import java.time.LocalDate;

public class Usuario{

    //Atributos de Usuario
    private String usuario;
    private String password;
    private TipoRol tipoRol;
    private Persona persona;

    //Constructor
    public Usuario(String usuario, String password, TipoRol tipoRol, Persona persona) {
        this.usuario = usuario;
        this.password = password;
        this.tipoRol = tipoRol;
        this.persona = persona;
    }


    //getter's and setter's

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }

    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
