package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DoctorViewController {

    @FXML
    private Button btnBackToLogin;

    @FXML
    private Button btnGestionarHorariosConsulta;

    @FXML
    private Button btnHistorialMedicoPaciente;

    @FXML
    private Button btnNotificarCambioCitas;

    @FXML
    private Button btnRegistrarDiagnosticoYTratamiento;

    @FXML
    private Label lbltxtNombreDoctor;

    void agregarNombreDoctor(String nombre){
        lbltxtNombreDoctor.setText("Bienvenido doctor " + nombre);
    }

    @FXML
    void btnBackToLogin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "main.fxml");
    }

    @FXML
    void btnGestionarHorariosConsulta(ActionEvent event) {

    }

    @FXML
    void btnHistorialPacienteMedico(ActionEvent event) {

    }

    @FXML
    void btnNotificarCambioCitas(ActionEvent event) {

    }

    @FXML
    void btnRegistrarDiagnosticoYTratamiento(ActionEvent event) {

    }

}
