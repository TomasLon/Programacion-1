package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.model.enums.TipoRol;
import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;
import javafx.scene.shape.Line;

import java.time.LocalDate;
import java.util.LinkedList;

public class Hospital {

    //Atributos hospital
    private String nombre;
    private String nit;
    private LinkedList<Usuario> listUsers = new LinkedList<>();
    private LinkedList<Administrador> listAdmins = new LinkedList<>();

    public void agregarUser() {
        Usuario user1 = new Usuario("Carlos", "112233", TipoRol.ADMIN,listAdmins.get(0));
        listUsers.add(user1);
        Usuario user2 = new Usuario("Sofia", "112233", TipoRol.ADMIN, listAdmins.get(1));
        listUsers.add(user2);
        Usuario user3 = new Usuario("Dylan", "1234", TipoRol.ADMIN, listAdmins.get(2));
        listUsers.add(user3);
//        Usuario user4 = new Usuario("Daniel", "1234", TipoRol.PACIENTE);
//        listUsers.add(user4);
//        Usuario user5 = new Usuario("Maria", "1234", TipoRol.DOCTOR);
//        listUsers.add(user5);
    }

    public void agregarAdmin() {
        Administrador admin1 = new Administrador("1070590018", "Carlos", "Molina", "caml.7carlos@gmail.com");
        listAdmins.add(admin1);
        Administrador admin2 = new Administrador("1090273308", "Sofia", "Botero", "sofiaboteroalbarracin@gmail.com");
        listAdmins.add(admin2);
        Administrador admin3 = new Administrador("1072111458", "Dylan", "Molina", "dylanmolina1213@gmail.com");
        listAdmins.add(admin3);
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
    public LinkedList<Administrador> getListAdmins() {
        return listAdmins;
    }
    public void setListAdmins(LinkedList<Administrador> listAdmins) {
        this.listAdmins = listAdmins;
    }
}
