package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.TipoRol;
import java.util.LinkedList;

public class Hospital {

    //Atributos hospital
    private String nombre;
    private String nit;
    private LinkedList<Usuario> listUsers = new LinkedList<>();

    public void agregarUser() {
        Usuario user1 = new Usuario("Carlos", "112233", TipoRol.ADMIN);
        listUsers.add(user1);
        Usuario user2 = new Usuario("1234", "4567", TipoRol.ADMIN);
        listUsers.add(user2);
        Usuario user3 = new Usuario("5678", "1234", TipoRol.ADMIN);
        listUsers.add(user3);
        Usuario user4 = new Usuario("Daniel", "1234", TipoRol.PACIENTE);
        listUsers.add(user4);
        Usuario user5 = new Usuario("Maria", "1234", TipoRol.DOCTOR);
        listUsers.add(user5);
    }

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
    public LinkedList<Usuario> getListUsers() {
        return listUsers;
    }
    public void setListUsers(LinkedList<Usuario> listUsers) {
        this.listUsers = listUsers;
    }
}
