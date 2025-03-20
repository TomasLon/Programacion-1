public class Medico {

    //Atributos
    private String id;
    private String nombre;
    private String idLicencia;
    private String especialidad;

    //Constructor

    public Medico(String id, String nombre, String idLicencia, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.idLicencia = idLicencia;
        this.especialidad = especialidad;
    }

    //toString
    @Override
    public String toString() {
        return "Cedula del especialista: "+id+'\n'+
                "Nombre completo: "+nombre+'\n'+
                "Numero de la licencia profesional: "+idLicencia+'\n'+
                "Especialidad: "+especialidad+'\n';
    }


    //getter's and setter's

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(String idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
