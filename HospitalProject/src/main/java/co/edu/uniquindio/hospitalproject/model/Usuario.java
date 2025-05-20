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

    //Constructor
    public Usuario(String usuario, String password, TipoRol tipoRol) {
        this.usuario = usuario;
        this.password = password;
        this.tipoRol = tipoRol;
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
}
