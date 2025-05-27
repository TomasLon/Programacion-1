package co.edu.uniquindio.hospitalproject.model;

import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDPersona;
import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDUsuario;
import co.edu.uniquindio.hospitalproject.model.Interfaces.ICRUDAdmin;
import co.edu.uniquindio.hospitalproject.model.enums.Especializacion;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.model.enums.TipoRol;
import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Hospital implements ICRUDPersona, ICRUDUsuario, ICRUDAdmin {

    //Instancia de Hospital (para mantener las listas con sus datos hasta que el programa cierre)
    private static Hospital instancia;

    //Atributos hospital
    private String nombre;
    private String nit;
    private LinkedList<Usuario> listUsers = new LinkedList<>();
    private Collection<Persona> personas;
    private Collection<Administrador> administradors;
    private boolean datosPrecargados = false;

    //Constructor privado
    private Hospital(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.personas = new LinkedList<>();
        this.administradors = new LinkedList<>();
    }

    public static Hospital getInstancia() {
        if (instancia == null) {
            instancia = new Hospital("Hospital UQ", "123.456.789");
        }
        return instancia;
    }

    //Metodo para precargar datos users de tipo Admin (única forma de crearlos) y a su vez, evitar duplicados (cosa q estaba pasando)
    public void precargarDatos() {
        if (datosPrecargados) return;
        //Datos Precargados:
        //Creacion de admins
        Administrador admin1 = new Administrador("590590","Carlos","Molina","caml.7carlos@gmail.com");
        Administrador admin2 = new Administrador("109054", "Tomas", "Londoño", "tomaslondoño@gmail.com");
        Administrador admin3 = new Administrador("1198043", "Juan Pablo", "Londoño", "jplondoño@gmail.com");
        crearAdmin(admin1);
        crearAdmin(admin2);
        crearAdmin(admin3);

        //Creación de un paciente y doctor (para validaciones y demás)
        Doctor doctor1 = new Doctor("49023", "Sofia", "Rodriguez", LocalDate.of(1996, 10, 25),
                Genero.FEMENINO, TipoSangre.ABPOSITIVO, Especializacion.ONCOLOGO, "1230-323", true);
        Paciente paciente1 = new Paciente("1090232", "Kasandra", "Ramirez", LocalDate.of(1980, 12, 22),
                Genero.FEMENINO, TipoSangre.BNEGATIVO, "kasanRamirez22@gmail.com", "3286543232");
        crearPersona(doctor1);
        crearPersona(paciente1);

        //Creación de usuarios
        Usuario user1 = new Usuario("CarlosMol", "112233", TipoRol.ADMIN, admin1);
        Usuario user2 = new Usuario("TomasLon", "223344", TipoRol.ADMIN, admin2);
        Usuario user3 = new Usuario("JuanPa", "334455", TipoRol.ADMIN, admin3);
        Usuario user4 = new Usuario("SofRodriguez", "456789", TipoRol.DOCTOR, doctor1);
        Usuario user5 = new Usuario("KasaRam", "Kasandra", TipoRol.PACIENTE, paciente1);
        crearUsuario(user1);
        crearUsuario(user2);
        crearUsuario(user3);
        crearUsuario(user4);
        crearUsuario(user5);

        datosPrecargados = true;
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
                administrador.setCedula(administrador.getCedula());
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
        for (Persona persona : personas) {
            if (persona.getCedula().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Persona verificarPersonaID(String id) {
        for (Persona persona : personas) {
            if (persona.getCedula().equals(id)) {
                return persona;
            }
        }
        return null;
    }

    //Datos pre-cargados (3 admins nomás)
//    Administrador admin1 = new Administrador("590590","Carlos","Molina","caml.7carlos@gmail.com");
//    Administrador admin2 = new Administrador("109054", "Tomas", "Londoño", "tomaslondoño@gmail.com");
//    Administrador admin3 = new Administrador("1198043", "Juan Pablo", "Londoño", "jplondoño@gmail.com");




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
