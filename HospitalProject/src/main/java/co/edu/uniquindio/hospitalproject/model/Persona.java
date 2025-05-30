package co.edu.uniquindio.hospitalproject.model;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;

import java.time.LocalDate;


public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String apellido;
    protected LocalDate fechaNacimiento;
    protected Genero genero;
    protected TipoSangre tipoSangre;

    //Constructor para clase Usuario, Paciente y Doctor/Médico
    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                   Genero genero, TipoSangre tipoSangre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.tipoSangre = tipoSangre;
    }

    //Constructor para clase Administrador (Menos datos)
    public Persona(String id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getter's and setter's

    public String getCedula() {
        return id;
    }

    public void setCedula(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

}