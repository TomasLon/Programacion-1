package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrudPacienteViewController {

    @FXML
    private Button btnBack;

    @FXML
    private MenuItem btnABNegativo;

    @FXML
    private MenuItem btnABPositivo;

    @FXML
    private MenuItem btnANegativo;

    @FXML
    private MenuItem btnAPositivo;

    @FXML
    private Button btnActualizarPaciente;

    @FXML
    private Button btnAgregarPaciente;

    @FXML
    private MenuItem btnBNegativo;

    @FXML
    private MenuItem btnBPositivo;

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnEliminarPaciente;

    @FXML
    private MenuItem btnGeneroFemenino;

    @FXML
    private MenuItem btnGeneroMasculino;

    @FXML
    private Button btnMostrarInformacion;

    @FXML
    private MenuItem btnONegativo;

    @FXML
    private MenuItem btnOPositivo;

    @FXML
    private MenuItem btnOtroGenero;

    @FXML
    private DatePicker dateFechaNacimiento;

    @FXML
    private MenuButton menuGeneroPaciente;

    @FXML
    private MenuButton menuTipoSangre;

    @FXML
    private TableView<?> tblListPaciente;

    @FXML
    private TextField txtApellidoPaciente;

    @FXML
    private TextField txtEmailPaciente;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private TextField txtTelefonoPaciente;

    @FXML
    void actualizarPaciente(ActionEvent event) {

    }

    @FXML
    void agregarPaciente(ActionEvent event) {

    }

    @FXML
    void btnABNegativo(ActionEvent event) {

    }

    @FXML
    void btnABPositivo(ActionEvent event) {

    }

    @FXML
    void btnANegativo(ActionEvent event) {

    }

    @FXML
    void btnAPositivo(ActionEvent event) {

    }

    @FXML
    void btnBNegativo(ActionEvent event) {

    }

    @FXML
    void btnBPositivo(ActionEvent event) {

    }

    @FXML
    void btnGeneroFemenino(ActionEvent event) {

    }

    @FXML
    void btnGeneroMasculino(ActionEvent event) {

    }

    @FXML
    void btnONegativo(ActionEvent event) {

    }

    @FXML
    void btnOPositivo(ActionEvent event) {

    }

    @FXML
    void btnOtroGenero(ActionEvent event) {

    }

    @FXML
    void deseleccionarPaciente(ActionEvent event) {

    }

    @FXML
    void eliminarPaciente(ActionEvent event) {

    }

    @FXML
    void mostrarInformacionPaciente(ActionEvent event) {

    }

    @FXML
    void btnBackToAdmin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "admin.fxml");
    }

}
