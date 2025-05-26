package co.edu.uniquindio.hospitalproject.viewController;


import co.edu.uniquindio.hospitalproject.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetallePacienteViewController {

    private Stage stage;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblFechaNacimiento;

    @FXML
    private Label lblGenero;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblTipoSangre;

    public void setPaciente(Paciente paciente) {
        lblCedula.setText("Cédula: " + paciente.getCedula());
        lblNombre.setText("Nombre: " + paciente.getNombre());
        lblApellido.setText("Apellido: " + paciente.getApellido());
        lblCorreo.setText("Correo: " + paciente.getEmail());
        lblTelefono.setText("Teléfono: " + paciente.getTelefono());
        lblFechaNacimiento.setText("Nacimiento: " + paciente.getFechaNacimiento());
        lblGenero.setText("Género: " + paciente.getGenero().genero);
        lblTipoSangre.setText("Tipo de sangre: " + paciente.getTipoSangre().tipoSangre);
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
        stage.close();
    }

}
