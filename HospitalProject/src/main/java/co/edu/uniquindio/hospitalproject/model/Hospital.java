package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDPersona;
import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDUsuario;
import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDAdmin;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Hospital implements ICRUDPersona, ICRUDUsuario, ICRUDAdmin {

    //Atributos hospital
    private String nombre;
    private String nit;
    private LinkedList<Usuario> listUsers = new LinkedList<>();
    private Collection<Persona> personas;
    private Collection<Administrador> administradors;

//    public void agregarUser() {
//        Usuario user1 = new Usuario("Carlos", "112233", TipoRol.ADMIN);
//        listUsers.add(user1);
//        Usuario user2 = new Usuario("1234", "4567", TipoRol.ADMIN);
//        listUsers.add(user2);
//        Usuario user3 = new Usuario("5678", "1234", TipoRol.ADMIN);
//        listUsers.add(user3);
//        Usuario user4 = new Usuario("Daniel", "1234", TipoRol.PACIENTE);
//        listUsers.add(user4);
//        Usuario user5 = new Usuario("Maria", "1234", TipoRol.DOCTOR);
//        listUsers.add(user5);
//    }

    //Constructor
    public Hospital(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.personas = new LinkedList<>();
        this.administradors = new LinkedList<>();
    }

    //Métodos de CRUD´s

    @Override
    public boolean crearPersona(Persona persona) {
        boolean centinela = false;
        if (!verificarPersona(persona.getId())) {
            personas.add(persona);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarPersona(String id) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                personas.remove(persona);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    @Override
    public boolean actualizarPersona(String id, Persona actualizado) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                persona.setId(actualizado.getId());
                persona.setNombre(actualizado.getNombre());
                persona.setApellido(actualizado.getApellido());
                persona.setFechaNacimiento(actualizado.getFechaNacimiento());
                persona.setGenero(actualizado.getGenero());
                persona.setTipoSangre(actualizado.getTipoSangre());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    @Override
    public Collection<Persona> listarPersonas() {
        return personas;
    }


    // CRUD Admin

    @Override
    public boolean crearAdmin(Administrador administrador) {
        boolean centinela = false;
        if (!verificarPersona(administrador.getId())) {
            administradors.add(administrador);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarAdmin(String id) {
        boolean centinela = false;
        for (Administrador administrador : administradors) {
            if (administrador.getId().equals(id)) {
                administradors.remove(administrador);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    @Override
    public boolean actualizarAdmin(String id, Administrador actualizado01) {
        boolean centinela = false;
        for (Administrador administrador : administradors) {
            if (administrador.getId().equals(id)) {
                administrador.setId(actualizado01.getId());
                administrador.setNombre(actualizado01.getNombre());
                administrador.setApellido(actualizado01.getApellido());
                administrador.setEmail(actualizado01.getEmail());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    @Override
    public Collection<Administrador> listarAdmin() {
        return administradors;
    }

    @Override
    public boolean crearUsuario(Usuario usuario) {
        boolean centinela = false;
        if (!verificarPersona(usuario.getUsuario())) {
            listUsers.add(usuario);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarUsuario(String usuario) {
        boolean centinela = false;
        for (Usuario usuario1 : listarUsuarios()) {
            if (usuario1.getUsuario().equals(usuario)) {
                listarUsuarios().remove(usuario1);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    @Override
    public boolean actualizarUsuario(String usuario, Usuario usuario01) {
        boolean centinela = false;
        for (Usuario user : listarUsuarios()) {
            if (user.getUsuario().equals(usuario)) {
                user.setUsuario(usuario01.getUsuario());
                user.setPassword(usuario01.getPassword());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    @Override
    public Collection<Usuario> listarUsuarios() {
        return listUsers;
    }

    // Metodos de verificacion de instancias

    public boolean verificarPersona(String id) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }




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
