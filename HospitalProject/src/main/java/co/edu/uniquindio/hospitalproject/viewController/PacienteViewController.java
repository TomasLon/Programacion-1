package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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

    private Paciente pacienteActual;
    private Hospital hospital;

    public void setPacienteActual(Paciente paciente, Hospital hospital) {
        this.pacienteActual = paciente;
        this.hospital = hospital;
    }


    @FXML
    private Label lblNombrePaciente;

    void agregarNombrePaciente(String nombre){
        lblNombrePaciente.setText("Bienvenido paciente " + nombre);
    }

    @FXML
    void btnActualizarDatosPersonales(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "actualizarDatosPersonales.fxml");
    }

    @FXML
    void btnCambiarEstadoCitaMedica(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "cambiarEstadoCita.fxml");
    }

    @FXML
    void btnConsultarHistorialMedico(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "consultarHistorialMedico.fxml");
    }

    @FXML
    void btnSolicitarCitaM(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "crearCitaMedica.fxml");
    }

    @FXML
    void btnBackToLogin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "main.fxml");
    }
}
