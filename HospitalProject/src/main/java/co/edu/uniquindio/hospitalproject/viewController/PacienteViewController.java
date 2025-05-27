package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PacienteViewController {

    @FXML
    private Button btnActualizarDatosP;

    @FXML
    private Button btnCancelarCitaM;

    @FXML
    private Button btnBackToLogin;

    @FXML
    private Button btnConsultarHistorial;

    @FXML
    private Button btnSolicitarCitaMedica;

    @FXML
    private Label lblNombrePaciente;

    void agregarNombrePaciente(String nombre){
        lblNombrePaciente.setText("Bienvenido paciente " + nombre);
    }

    @FXML
    void btnActualizarDatosPersonales(ActionEvent event) {

    }

    @FXML
    void btnCancelarCitaMedica(ActionEvent event) {

    }

    @FXML
    void btnConsultarHistorialMedico(ActionEvent event) {

    }

    @FXML
    void btnSolicitarCitaM(ActionEvent event) {

    }

    @FXML
    void btnBackToLogin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "main.fxml");
    }
}
