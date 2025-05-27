package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.CrudCitaController;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.CitaMedica;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistrarDiagnosticoViewController {

    @FXML private Button btnEnviar;
    @FXML private Button btnVolver;

    @FXML private MenuButton menuEspecialidadCita;
    @FXML private MenuItem optCancelada;
    @FXML private MenuItem optConfirmar;
    @FXML private MenuItem optEnEspera;
    @FXML private MenuItem optFinalizada;
    @FXML private MenuItem optPendiente;
    @FXML private MenuItem optReprogramada;

    @FXML private TextField txtDiagnostico;
    @FXML private TextField txtIDDoctor;
    @FXML private TextField txtIDPaciente;
    @FXML private TextField txtTratamiento;

    private String estadoSeleccionado = "";

    private CrudCitaController citaController;

    @FXML
    public void initialize() {
        Hospital hospital = SceneManager.getHospital(); // usa tu método de acceso
        citaController = new CrudCitaController(hospital);

        configurarMenuEstados();

        btnEnviar.setOnAction(this::registrarDiagnostico);
        btnVolver.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SceneManager.cambiarEscena(stage, "admin.fxml");
        });
    }

    private void configurarMenuEstados() {
        optCancelada.setOnAction(e -> seleccionarEstado("Cancelada"));
        optConfirmar.setOnAction(e -> seleccionarEstado("Confirmada"));
        optEnEspera.setOnAction(e -> seleccionarEstado("En espera"));
        optFinalizada.setOnAction(e -> seleccionarEstado("Finalizada"));
        optPendiente.setOnAction(e -> seleccionarEstado("Pendiente"));
        optReprogramada.setOnAction(e -> seleccionarEstado("Reprogramada"));
    }

    private void seleccionarEstado(String estado) {
        estadoSeleccionado = estado;
        menuEspecialidadCita.setText(estado);
    }

    private void registrarDiagnostico(ActionEvent event) {
        String idPaciente = txtIDPaciente.getText().trim();
        String idDoctor = txtIDDoctor.getText().trim();
        String diagnostico = txtDiagnostico.getText().trim();
        String tratamiento = txtTratamiento.getText().trim();

        if (idPaciente.isEmpty() || idDoctor.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty() || estadoSeleccionado.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar completos.");
            return;
        }

        boolean exito = citaController.registrarDiagnostico(idPaciente, idDoctor, diagnostico, tratamiento, estadoSeleccionado);

        if (exito) {
            mostrarAlerta("Éxito", "Diagnóstico registrado correctamente.");
        } else {
            mostrarAlerta("Error", "No se pudo registrar el diagnóstico. Verifique los datos.");
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
