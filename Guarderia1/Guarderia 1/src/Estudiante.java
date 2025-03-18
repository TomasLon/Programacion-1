public class Estudiante {
    private String nombre;
    private int edad;
    private String genero;
    private String Identificacion;
    private String alergias;
    private String nombreAcudiente;
    private String numAcudiente;

    //Constructor
    public Estudiante(String nombre, int edad, String genero, String identificacion,
                      String alergias, String nombreAcudiente, String numAcudiente) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        Identificacion = identificacion;
        this.alergias = alergias;
        this.nombreAcudiente = nombreAcudiente;
        this.numAcudiente = numAcudiente;
    }

    //toString
    @Override
    public String toString() {
        return "nombre: " + nombre + '\n' +
                "edad: " + edad + '\n' +
                "genero: " + genero + '\n' +
                "Identificacion: " + Identificacion + '\n' +
                "alergias: " + alergias + '\n' +
                "nombre del acudiente: " + nombreAcudiente + '\n' +
                "numero del Acudiente: " + numAcudiente + '\n';
    }

    //Getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getNumAcudiente() {
        return numAcudiente;
    }

    public void setNumAcudiente(String numAcudiente) {
        this.numAcudiente = numAcudiente;
    }
}