
public class Consultorio {

    //Atributos
    private String nombre;
    private String nit;
    private final Medico[] listMedicos = new Medico[30];
    private final Paciente[] listPacientes = new Paciente[30];



    //Constructor
    public Consultorio(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    //Metodos para medicos

    //Verificar si un médico ya existe por su ID
    public int verificarMedico(Medico medicoVerificado){
        for (int i = 0; i < listMedicos.length; i++){
            if(listMedicos[i]!= null && medicoVerificado.getId().equals(listMedicos[i].getId())){
                return i;
            }
        }return -1;
    }
    //Verificar si se puede agregar un medico
    public Boolean crearMedico(Medico newMedico){
        int indice = verificarMedico(newMedico);
        if(indice != -1){
            return false;
        }
        for (int i = 0; i < listMedicos.length; i++){
            if (listMedicos[i] == null){
                listMedicos[i] = newMedico;
                return true;
            }
        }return false;
    }

    //Verificar si se puede modificar un medico
    public Boolean modificarMedico(Medico modificarMedico){
        for (int i = 0; i < listMedicos.length; i++){
            if (listMedicos[i] != null && listMedicos[i].getId().equals(modificarMedico.getId())){
                listMedicos[i] = modificarMedico;
                return true;
            }
        }return false;
    }

    //verificar y eliminar un medico
    public Boolean eliminarMedico(Medico eliminarMedico){
        for(int i = 0; i < listMedicos.length; i++){
            if (listMedicos[i] != null && listMedicos[i].getId().equals(eliminarMedico.getId())){
                listMedicos[i] = null;
                return true;}
        }return false;
    }

    //Ver la lista de médicos
    public Medico[] getListMedicos() {
        return listMedicos;
    }


    //Métodos para paciente

    //Obtener pacientes registrados
    public Paciente[] getListPacientes() {
        return listPacientes;
    }

    //Agregar y/o actualizar un paciente
    public void actualizarPaciente(Paciente actualizarPaciente){
        for (int i = 0; i < listPacientes.length; i++){
            if (listPacientes[i] == null){
                listPacientes[i] = actualizarPaciente;
                return;
            }
        }
    }

    //Eliminar historiales de un paciente
    public Boolean eliminarPaciente(Paciente eliminarPaciente){
        for (int i = 0; i < listPacientes.length; i++){
            if (listPacientes[i] != null && listPacientes[i].idHistoriaClinica().equals(eliminarPaciente.idHistoriaClinica())){
                listPacientes[i] = null;

            }
        }return true;
    }

    public Paciente[] pacientesmas5Tratamientos(){
        int cantPacientes = 0;
        for (Paciente listPaciente : listPacientes) {
            if (listPaciente != null && listPaciente.cantidadTratamientosHechos() > 5) {
                cantPacientes++;
            }
        }
        Paciente[] pacientesMas5Tratamientos = new Paciente[cantPacientes];
        int indice = 0;
        for (Paciente listPaciente : listPacientes) {
            if (listPaciente != null && listPaciente.cantidadTratamientosHechos() >= 5) {
                pacientesMas5Tratamientos[indice] = listPaciente;
                indice++;
            }
        }
        return pacientesMas5Tratamientos;
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
}
