import java.util.ArrayList;

public class Guarderia {
    private String nombre;
    private String nit;
    private ArrayList<Estudiante> listEstudiantes;


    public void agregarEstudiante(Estudiante newEstudiante){
        listEstudiantes.add(newEstudiante);
    }

    public  void eliminarEstudiante(Estudiante estudiante){
        listEstudiantes.remove(estudiante);
    }

    public void actualizarEstudiante(Estudiante estudiante){


        for (Estudiante  indexEstudiante : listEstudiantes) {

            if(indexEstudiante.getIdentificacion().equals(estudiante.getIdentificacion())){

                indexEstudiante.setNombre(estudiante.getNombre());
                indexEstudiante.setEdad(estudiante.getEdad());
                indexEstudiante.setGenero(estudiante.getGenero());
                indexEstudiante.setAlergias(estudiante.getAlergias());
                indexEstudiante.setNombreAcudiente(estudiante.getNombreAcudiente());
                indexEstudiante.setTelefonoContacto(estudiante.getTelefonoContacto());
                break;
            }
        }
    }

    public void listarEstudiantes(){

        for (Estudiante estudiante : listEstudiantes) {
            System.out.println("Estudiante "+listEstudiantes.indexOf(estudiante)+" "+estudiante);

        }
    }

    public Guarderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(ArrayList<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }
}
