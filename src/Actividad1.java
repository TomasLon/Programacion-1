//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

class Actividad1 {
    private String identificacion;
    private String nombreCompleto;
    private String puesto;
    private String correo;
    private String telefono;
    private String fechaContratacion;

    public Actividad1(String identificacion, String nombreCompleto, String puesto, String correo, String telefono, String fechaContratacion) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getFechaContratacion() {
        return this.fechaContratacion;
    }

    public String toString() {
        return "Empleado{Identificacion='" + this.identificacion + "', Nombre='" + this.nombreCompleto + "', Puesto='" + this.puesto + "', Correo='" + this.correo + "', Telefono='" + this.telefono + "', Fecha Contratacion='" + this.fechaContratacion + "'}";
    }
}
