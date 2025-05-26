package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminViewController {

    @FXML
    private Button btnConsultarOcupacionHP;

    @FXML
    private Button btnGenerarReporteCita;

    @FXML
    private Button btnGestionDoctor;

    @FXML
    private Button btnGestionHorarios;

    @FXML
    private Button btnGestionPaciente;

    @FXML
    private Button btnGestionSala;

    @FXML
    private Button btnGestionUsuarios;

    @FXML
    private Button btnLogOutAdmin;

    @FXML
    private Label lblTextAdmin;

    @FXML
    void btnBackToLoginAdmin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "main.fxml");
    }

    @FXML
    void btnGestionarUsuarios(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "crudUsers.fxml");
    }

    @FXML
    void consultarOcupacionHP(ActionEvent event) {

    }

    @FXML
    void generarReporte(ActionEvent event) {

    }

    @FXML
    void gestionarDoctores(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "crudDoctor.fxml");
    }

    @FXML
    void gestionarHorarios(ActionEvent event) {

    }

    @FXML
    void gestionarPacientes(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "crudPaciente.fxml");
    }

    @FXML
    void gestionarSalas(ActionEvent event) {

    }

}
