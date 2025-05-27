package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.CrudPacienteController;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuscarPacienteIDViewController {

    @FXML
    private Button btnBuscarPaciente;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtIDPaciente;

    private CrudPacienteController pacienteController;

    @FXML
    public void initialize() {
        // ⚠️ Usa tu fuente real de hospital (singleton, inyección, etc.)
        Hospital hospital = SceneManager.getHospital(); // Suponiendo que SceneManager lo maneja
        pacienteController = new CrudPacienteController(hospital);

        btnBuscarPaciente.setOnAction(event -> buscarPacientePorID());
        btnVolver.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SceneManager.cambiarEscena(stage, "admin.fxml");
        });
    }

    private void buscarPacientePorID() {
        String id = txtIDPaciente.getText().trim();

        if (id.isEmpty()) {
            mostrarAlerta("Error", "Debe ingresar una cédula.");
            return;
        }

        Paciente paciente = pacienteController.buscarPaciente(id);
        if (paciente != null) {
            mostrarAlerta("Paciente encontrado", paciente.toString());
        } else {
            mostrarAlerta("No encontrado", "No se encontró ningún paciente con esa cédula.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
