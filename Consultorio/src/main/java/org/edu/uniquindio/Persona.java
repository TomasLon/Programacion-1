package org.edu.uniquindio;

import java.time.LocalDate;

public class Persona {
    public String nombre;
    public String cedula;
    public int edad;
    public LocalDate fechaNacimiento;


    public Persona(String nombre, String apellido, int edad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.cedula = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }


    public boolean respirar(){
        return true;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
