package co.edu.uniquindio.hospitalproject.model;

public class Sala {
    //Atributos
    private String idSala;
    private String nombreSala;
    private Boolean estadoSala;

    //Constructor
    public Sala(String idSala, String nombreSala, Boolean estadoSala) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.estadoSala = estadoSala;
    }

    //Getter's and setter's

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Boolean getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(Boolean estadoSala) {
        this.estadoSala = estadoSala;
    }
}
