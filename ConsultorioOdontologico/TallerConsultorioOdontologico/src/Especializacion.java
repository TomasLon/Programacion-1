public enum Especializacion {
    //Odontología General, Ortodoncia, Endodoncia, Cirugía Oral
    ODONTOLOGIAGENERAL ("Odontología General"),
    ORTODONCIA("Ortodoncia"),
    ENDODONCIA("Endodoncia"),
    CIRUGIAORAL("Cirugía Oral");

    private final String especializacion;

    Especializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }
}
