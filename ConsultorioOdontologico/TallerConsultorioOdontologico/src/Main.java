import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio("CONSULTORIO MUELITAS", "901.221.22.34.5");

        String[] options = {
                "Agregar un médico especialista",
                "Consultar especialistas registrados",
                "Eliminar un especialista del consultorio",
                "Actualizar datos de un especialista",
                "Actualizar o agregar un paciente al consultorio",
                "Eliminar un paciente del consultorio",
                "Mostrar los pacientes registrados",
                "Mostrar pacientes con más de 5 tratamientos",
                "Salir"
        };
        while(true){
            String option = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "MENÚ CONSULTORIO ODONTOLÓGICO",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (option == null || option.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;}

            switch (option){
                case "Agregar un médico especialista":
                    String id = JOptionPane.showInputDialog("Ingrese la cédula");
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo");
                    String idLicencia = JOptionPane.showInputDialog("Ingrese el número de la licencia profesional");
                    Especializacion[] especializaciones = Especializacion.values();
                    String [] optionEspecialidad = new String[especializaciones.length];
                    for (int i = 0; i < especializaciones.length; i++) {
                        optionEspecialidad[i] = especializaciones[i].getEspecializacion();
                    }
                    String especializacion = (String) JOptionPane.showInputDialog(
                            null,
                            "Selecciones su especialización",
                            "ESPECIALIZACIONES",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            optionEspecialidad,
                            optionEspecialidad[0]);

                    Medico newMedico = new Medico(id, nombre, idLicencia, especializacion);
                    boolean agregar = consultorio.crearMedico(newMedico);
                    if(agregar) {
                        JOptionPane.showMessageDialog(null, "Se ha agregado el especialista");
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar el especialista");
                    }
                    break;


                case "Consultar especialistas registrados":

                    Medico[] medico = consultorio.getListMedicos();
                    StringBuilder mensaje = new StringBuilder("La lista de médicos es: \n\n");
                    boolean flag = false;
                    for (Medico medico1 : medico) {
                        if(medico1 != null){
                            mensaje.append(medico1).append("\n");
                            flag = true;
                        }
                    }
                    if(!flag){
                        JOptionPane.showMessageDialog(null, "Lista vacía, ingrese al menos un especialista");
                    }else{
                        JOptionPane.showMessageDialog(null, mensaje.toString());
                    }
                    break;

                case "Eliminar un especialista del consultorio":
                    String idEliminar = JOptionPane.showInputDialog(null, "Ingrese la cédula del especialista que desea eliminar");
                    boolean banderaMensaje = false;
                    for (Medico eliminarMedico : consultorio.getListMedicos()) {
                        if (eliminarMedico != null && eliminarMedico.getId().equals(idEliminar)) {
                            consultorio.eliminarMedico(eliminarMedico);
                            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
                            banderaMensaje = true;
                            break;
                        }
                    }if (!banderaMensaje){
                    JOptionPane.showMessageDialog(null, "No se encontró el especialista");
                }
                    break;

                case "Actualizar datos de un especialista":
                    String idActualizar = JOptionPane.showInputDialog(null, "Ingrese la cédula del especialista que desea actualizar");
                    Medico medicoActualizado = null;
                    for (Medico actualizarMedico : consultorio.getListMedicos()) {
                        if (actualizarMedico != null && actualizarMedico.getId().equals(idActualizar)){
                            Especializacion[] nuevaEspecializacion = Especializacion.values();
                            String [] optionNuevaEspecialidad = new String[nuevaEspecializacion.length];
                            for (int i = 0; i < nuevaEspecializacion.length; i++) {
                                optionNuevaEspecialidad[i] = nuevaEspecializacion[i].getEspecializacion();
                            }
                            String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nombre actualizado");
                            String actualizarEspecializacion = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Selecciones su nueva especialización",
                                    "ESPECIALIZACIONES",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    optionNuevaEspecialidad,
                                    optionNuevaEspecialidad[0]);

                            medicoActualizado = new Medico(idActualizar, nuevoNombre, actualizarMedico.getIdLicencia(), actualizarEspecializacion);
                            medicoActualizado.setNombre(nuevoNombre);
                            medicoActualizado.setEspecialidad(actualizarEspecializacion);
                            consultorio.modificarMedico(medicoActualizado);
                            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
                            break;
                        }
                    }if(medicoActualizado == null){
                    JOptionPane.showMessageDialog(null, "No existe el especialista");
                }
                    break;
                case "Actualizar o agregar un paciente al consultorio":
                    boolean verificar = true;
                    String idHistoriaClinica = JOptionPane.showInputDialog(null, "Ingrese el número de la historia clínica");
                    for (Paciente agregarPaciente : consultorio.getListPacientes()) {
                        if(agregarPaciente != null && idHistoriaClinica.equals(agregarPaciente.idHistoriaClinica())){
                            JOptionPane.showMessageDialog(null,  "Estos son los datos de "+agregarPaciente.nombre()+" a continuación, se actualizará su historia clínica");
                            int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su edad actual"));
                            String nuevoTelefono = JOptionPane.showInputDialog(null, "Ingrese su número de telefono");
                            String nuevaDireccion = JOptionPane.showInputDialog(null, "Ingrese su dirección");
                            String nuevaFecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de la consulta");
                            int nuevoTratamiento = agregarPaciente.cantidadTratamientosHechos() + Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cuantos tratamientos se realizarán"));

                            Paciente actualizarPaciente = new Paciente(idHistoriaClinica, agregarPaciente.nombre(), nuevaEdad, nuevoTelefono, nuevaDireccion, nuevaFecha, nuevoTratamiento);
                            consultorio.actualizarPaciente(actualizarPaciente);
                            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
                            verificar = false;
                            break;
                        }


                    }if(verificar){
                    JOptionPane.showMessageDialog(null, "Se agregará un nuevo paciente");
                    String nombrePaciente = JOptionPane.showInputDialog(null,"Ingrese el nombre completo del paciente");
                    int edadPaciente = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el edad del paciente"));
                    String telefono = JOptionPane.showInputDialog(null,"Ingrese número telefónico del paciente");
                    String direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección del paciente");
                    String fechaRegistro = JOptionPane.showInputDialog(null, "Ingrese la fecha en la cuál es atendido por primera vez");
                    int CantTratamientos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de tratamientos que se realizarán"));

                    Paciente nuevoPaciente = new Paciente(idHistoriaClinica, nombrePaciente, edadPaciente, telefono, direccion, fechaRegistro, CantTratamientos);
                    consultorio.actualizarPaciente(nuevoPaciente);
                    JOptionPane.showMessageDialog(null, "Se agregó correctamente");
                }
                    break;

                case "Eliminar un paciente del consultorio":
                    String idBorrar = JOptionPane.showInputDialog(null, "Ingrese el numero de historia clínica del paciente que desea eliminar");
                    boolean verificarBorrar = false;
                    for (Paciente eliminarPaciente : consultorio.getListPacientes()) {
                        if(eliminarPaciente != null && eliminarPaciente.idHistoriaClinica().equals(idBorrar)){
                            consultorio.eliminarPaciente(eliminarPaciente);
                            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
                            verificarBorrar = true;
                            break;
                        }
                    }if(!verificarBorrar){
                    JOptionPane.showMessageDialog(null, "Paciente inexistente");
                }
                    break;

                case "Mostrar los pacientes registrados":
                    Paciente[] pacienteRegistrado = consultorio.getListPacientes();
                    StringBuilder mensajePaciente = new StringBuilder("Los historias clínicas de los pacientes registrados son: \n\n");
                    boolean existePaciente = false;
                    for (Paciente paciente1 : pacienteRegistrado) {
                        if(paciente1 != null){
                            mensajePaciente.append(paciente1).append("\n\n");
                            existePaciente = true;
                        }
                    }
                    if(!existePaciente){
                        JOptionPane.showMessageDialog(null, "Lista vacía, no existe ninguna historia clínica registrada a la fecha");
                    }else{
                        JOptionPane.showMessageDialog(null, mensajePaciente.toString());
                    }
                    break;

                default:
                    Paciente[] mas5Tratamientos = consultorio.pacientesmas5Tratamientos();
                    if(consultorio.pacientesmas5Tratamientos().length >= 1){
                        StringBuilder mensajeTratamientos = new StringBuilder("Los historias clínicas de los pacientes registrados son: \n\n");
                        for (Paciente pacienteTratamiento : mas5Tratamientos) {
                            mensajeTratamientos.append(pacienteTratamiento).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, mensajeTratamientos.toString());
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null, "No existen pacientes con más de 5 tratamientos");
                    }
                    break;
            }
        }
    }

}