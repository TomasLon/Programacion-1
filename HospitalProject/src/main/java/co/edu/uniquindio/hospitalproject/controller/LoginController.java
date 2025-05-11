package co.edu.uniquindio.hospitalproject.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Button btnLogin;

    @FXML
    private MenuItem btnRolAdmin;

    @FXML
    private MenuItem btnRolMedico;

    @FXML
    private MenuItem btnRolPaciente;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private MenuButton menuRol;

    @FXML
    private TextField txtUsername;

    @FXML
    void validarLogin(ActionEvent event) {

    }
}
