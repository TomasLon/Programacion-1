package co.edu.uniquindio.hospitalproject.model;


public class Administrador extends Persona{

    //Atributos propios de Administrador
    private String email;

    //Constructor de Administrador extendido de Persona (versión con menos datos)
    public Administrador(String id, String nombre, String apellido, String email) {
        super(id, nombre, apellido);
        this.email = email;
    }

    //getter's and setter's
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
