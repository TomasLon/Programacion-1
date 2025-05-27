package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import javafx.stage.Stage;

public class ActualizarDatosPacienteViewController {

    @FXML
    private Button btnGuardarCambios, btnVolver;

    @FXML
    private Label lblApellidoActual, lblCorreoElectActual, lblGeneroActual,
            lblNombreActual, lblNumeroTelActual;

    @FXML
    private MenuButton menuGenero;

    @FXML
    private MenuItem optFemenino, optMasculino, optOtro;

    @FXML
    private TextField txtApellido, txtCorreoElect, txtNombre, txtNumeroTel;

    @FXML
    private VBox vBoxDatos;

    private Paciente pacienteActual;

    @FXML
    public void initialize() {
        optFemenino.setOnAction(e -> menuGenero.setText("Femenino"));
        optMasculino.setOnAction(e -> menuGenero.setText("Masculino"));
        optOtro.setOnAction(e -> menuGenero.setText("Otro"));

        btnGuardarCambios.setOnAction(e -> guardarCambios());
        btnVolver.setOnAction(this::volver);
    }

    public void inicializarDatos(Paciente paciente) {
        this.pacienteActual = paciente;

        lblNombreActual.setText("Nombre: " + paciente.getNombre());
        lblApellidoActual.setText("Apellido: " + paciente.getApellido());
        lblCorreoElectActual.setText("Correo: " + paciente.getEmail());
        lblNumeroTelActual.setText("Teléfono: " + paciente.getTelefono());
        lblGeneroActual.setText("Género: " + (paciente.getGenero() != null ? paciente.getGenero().toString() : ""));
    }

    private void guardarCambios() {
        if (pacienteActual == null) return;

        String nuevoNombre = txtNombre.getText().trim();
        String nuevoApellido = txtApellido.getText().trim();
        String nuevoCorreo = txtCorreoElect.getText().trim();
        String nuevoTelefono = txtNumeroTel.getText().trim();
        String nuevoGeneroTexto = menuGenero.getText();

        if (!nuevoNombre.isEmpty()) pacienteActual.setNombre(nuevoNombre);
        if (!nuevoApellido.isEmpty()) pacienteActual.setApellido(nuevoApellido);
        if (!nuevoCorreo.isEmpty()) pacienteActual.setEmail(nuevoCorreo);
        if (!nuevoTelefono.isEmpty()) pacienteActual.setTelefono(nuevoTelefono);

        try {
            if (!nuevoGeneroTexto.equals("Género")) {
                Genero nuevoGenero = Genero.valueOf(nuevoGeneroTexto.toUpperCase());
                pacienteActual.setGenero(nuevoGenero);
            }
        } catch (IllegalArgumentException e) {
            mostrarAlerta("Error", "Género no válido seleccionado.");
            return;
        }

        inicializarDatos(pacienteActual);
        mostrarAlerta("Datos actualizados", "Los datos del paciente se han actualizado correctamente.");
    }

    private void volver(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "paciente.fxml");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
