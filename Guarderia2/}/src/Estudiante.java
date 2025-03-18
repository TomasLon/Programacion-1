// SistemaNinoV1.java

class Estudiante {
    private String nombre;
    private int edad;
    private String genero;
    private String identificacion;
    private String alergias;
    private String nombreAcudiente;
    private String telefonoContacto;

    public Estudiante(String nombre, int edad, String genero, String documentoIdentidad,
                      String alergias, String nombreAcudiente, String telefonoContacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.identificacion = documentoIdentidad;
        this.alergias = alergias;
        this.nombreAcudiente = nombreAcudiente;
        this.telefonoContacto = telefonoContacto;
    }

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
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Estudiante" + identificacion + "\n" +
                "  Nombre: " + nombre + "\n" +
                "  Edad: " + edad + "\n" +
                "  Género: " + genero + "\n" +
                "  Identificación: " + identificacion + "\n" +
                "  Alergias: " + alergias + "\n" +
                "  Nombre Acudiente: " + nombreAcudiente + "\n" +
                "  Teléfono Contacto: " + telefonoContacto + "\n";
    }
}