public record Paciente(String idHistoriaClinica, String nombre, int edad, String telefono, String direccion,
                       String fechaUltimaConsulta, int cantidadTratamientosHechos) {

    //toString
    @Override
    public String toString() {
        return "Numero historia clinica: "+idHistoriaClinica+'\n'+
                "Nombre y apellido: "+nombre+'\n'+
                "Edad: "+edad+'\n'+
                "Telefono: "+telefono+'\n'+
                "Dirección: "+direccion+'\n'+
                "Fecha de la última consulta: "+fechaUltimaConsulta+'\n'+
                "Cantidad de tratamientos realizados: "+cantidadTratamientosHechos;
    }
}
