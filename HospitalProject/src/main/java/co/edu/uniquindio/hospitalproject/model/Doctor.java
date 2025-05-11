package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.model.enums.Especializacion;

import java.time.LocalDate;

public class Doctor extends Persona{

    //Atributos propios de Doctor
    private Especializacion especializacion;
    private String idProfesional;
    private Boolean doctorDisponible;

    //Constructor de Doctor extendido de Persona
    public Doctor(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                  Genero genero, TipoSangre tipoSangre, Especializacion especializacion,
                  String idProfesional, Boolean doctorDisponible) {
        super(id, nombre, apellido, fechaNacimiento, genero, tipoSangre);
        this.especializacion = especializacion;
        this.idProfesional = idProfesional;
        this.doctorDisponible = doctorDisponible;
    }

    //Getter's and setter's

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializacion especializacion) {
        this.especializacion = especializacion;
    }

    public String getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(String idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Boolean getDoctorDisponible() {
        return doctorDisponible;
    }

    public void setDoctorDisponible(Boolean doctorDisponible) {
        this.doctorDisponible = doctorDisponible;
    }
}
