package co.edu.uniquindio.hospitalproject.model;

public class Hospital {

    //Atributos hospital
    private String nombre;
    private String nit;

    //Constructor
    public Hospital(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    //Métodos


    //getter's and setter's
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
}
