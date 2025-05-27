package co.edu.uniquindio.hospitalproject.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GestionarHorariosViewController {

    @FXML
    private ComboBox<?> ComboBoxHora;

    @FXML
    private ComboBox<?> ComboBoxMinutos;

    @FXML
    private DatePicker DateFechaCita;

    @FXML
    private Button btmBack;

    @FXML
    private Button btmSolicitarCita;

    @FXML
    private Label lblNombreDoctor;

    @FXML
    private TextField txtIdDoctor;

}
