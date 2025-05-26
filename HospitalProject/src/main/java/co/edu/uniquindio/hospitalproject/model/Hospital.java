package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDPersona;
import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDUsuario;
import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDAdmin;
import co.edu.uniquindio.hospitalproject.model.enums.Especializacion;

import java.util.ArrayList;
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
        if (!verificarPersona(persona.getCedula())) {
            if (persona instanceof Doctor doctor) {
                String idProfesional = doctor.getIdProfesional();
                Especializacion especializacion = doctor.getEspecializacion();
                Boolean disponible = doctor.getDoctorDisponible();
            } else if (persona instanceof Paciente paciente) {
                String email = paciente.getEmail();
                String telefono = paciente.getTelefono();
            }
            personas.add(persona);
            centinela = true;
        }

        return centinela;
    }


    @Override
    public boolean eliminarPersona(String id) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getCedula().equals(id)) {
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
            if (persona.getCedula().equals(id)) {
                persona.setCedula(actualizado.getCedula());
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
    public <T extends Persona> Collection<T> listarPersonasPorTipo(Class<T> tipo) {
        List<T> resultado = new ArrayList<>();

        for (Persona persona : personas) {
            if (tipo.isInstance(persona)) {
                resultado.add(tipo.cast(persona));
            }
        }

        return resultado;
    }


    // CRUD Admin

    @Override
    public boolean crearAdmin(Administrador administrador) {
        boolean centinela = false;
        if (!verificarPersona(administrador.getCedula())) {
            administradors.add(administrador);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarAdmin(String id) {
        boolean centinela = false;
        for (Administrador administrador : administradors) {
            if (administrador.getCedula().equals(id)) {
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
            if (administrador.getCedula().equals(id)) {
                administrador.setCedula(actualizado01.getCedula());
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

    //CRUD Usuario

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
            if (persona.getCedula().equals(id)) {
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
