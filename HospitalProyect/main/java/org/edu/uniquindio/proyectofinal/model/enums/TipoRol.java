package org.edu.uniquindio.proyectofinal.model.enums;

public enum TipoRol {

    PACIENTE("Paciente"),
    DOCTOR("Doctor"),
    ADMIN("Administrador");

    public final String tipoRol;

    TipoRol(String tipoRol){
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return tipoRol;
    }
}
