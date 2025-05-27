package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.model.HistorialMedico;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class CrearCitaViewController {

    @FXML
    private Button btmVolver;

    @FXML
    private Label lblCedulaPaciente;

    @FXML
    private Label lblNombrePaciente;

    @FXML
    private TableColumn<HistorialMedico, String> tbcFecha;

    @FXML
    private TableColumn<HistorialMedico, String> tbcDiagnostico;

    @FXML
    private TableColumn<HistorialMedico, String> tbcTratamiento;

    @FXML
    private TableView<HistorialMedico> tblHistorialMedico;

    private ObservableList<HistorialMedico> historialList = FXCollections.observableArrayList();

    // Paciente que se mostrará
    private Paciente paciente;

    @FXML
    public void initialize() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        tbcFecha.setCellValueFactory(cellData ->
                javafx.beans.binding.Bindings.createStringBinding(() ->
                        cellData.getValue().fechaConsulta().format(formatter)));

        tbcDiagnostico.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().diagnostico()));

        tbcTratamiento.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().tratamiento()));

        tblHistorialMedico.setItems(historialList);

        btmVolver.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SceneManager.cambiarEscena(stage, "actualizarDatosPersonales.fxml");
        });
    }


    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
        lblCedulaPaciente.setText("Cédula: " + paciente.getCedula());
        lblNombrePaciente.setText("Nombre: " + paciente.getNombreCompleto());

        cargarHistorialPaciente();
    }

    private void cargarHistorialPaciente() {
        historialList.clear();

        // Aquí debes obtener el historial real del paciente
        // Ejemplo:
        // historialList.addAll(paciente.getHistorialMedico());

        // Por ahora solo agrego un comentario para que lo reemplaces
        // Quita el comentario y reemplaza por tu código para obtener historial real
    }
}
