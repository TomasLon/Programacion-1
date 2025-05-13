package co.edu.uniquindio.hospitalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController {


    @FXML
    private Button btnToLogin;

    @FXML
    private Label lblNombreHospitalBienvenida;

    @FXML
    void goToLogin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "login.fxml");
    }


}
