package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.CrudPacienteController;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import co.edu.uniquindio.hospitalproject.model.enums.Genero;
import co.edu.uniquindio.hospitalproject.model.enums.TipoSangre;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CrudPacienteViewController {

    private CrudPacienteController pacienteController;
    private ObservableList<Paciente> listPacientes = FXCollections.observableArrayList();
    private Paciente selectedPaciente;

    @FXML
    private Button btnBack, btnActualizarPaciente, btnAgregarPaciente, btnDeseleccionar, btnEliminarPaciente, btnMostrarInformacion;

    @FXML
    private MenuItem btnABNegativo, btnABPositivo, btnANegativo, btnAPositivo, btnBNegativo, btnBPositivo, btnONegativo, btnOPositivo;

    @FXML
    private MenuItem btnGeneroFemenino, btnGeneroMasculino, btnOtroGenero;

    @FXML
    private DatePicker dateFechaNacimiento;

    @FXML
    private MenuButton menuGeneroPaciente, menuTipoSangre;

    @FXML
    private TableView<Paciente> tblListPaciente;

    @FXML
    private TableColumn<Paciente, String> tbcCedula, tbcNombre, tbcApellido;

    @FXML
    private TextField txtApellidoPaciente, txtEmailPaciente, txtID, txtNombrePaciente, txtTelefonoPaciente;

    @FXML
    void initialize() {
        pacienteController = new CrudPacienteController(Hospital.getInstancia());
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerPacientes();
        tblListPaciente.getItems().clear();
        tblListPaciente.setItems(listPacientes);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tbcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    }

    private void obtenerPacientes() {
        listPacientes.addAll(pacienteController.listarPacientes());
    }

    private void listenerSelection() {
        tblListPaciente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPaciente = newSelection;
            informacionPaciente(newSelection);
        });
    }

    private void informacionPaciente(Paciente paciente) {
        if (paciente != null) {
            txtID.setText(paciente.getCedula());
            txtNombrePaciente.setText(paciente.getNombre());
            txtApellidoPaciente.setText(paciente.getApellido());
            txtEmailPaciente.setText(paciente.getEmail());
            txtTelefonoPaciente.setText(paciente.getTelefono());
            dateFechaNacimiento.setValue(paciente.getFechaNacimiento());
            menuGeneroPaciente.setText(paciente.getGenero().genero);
            menuTipoSangre.setText(paciente.getTipoSangre().tipoSangre);
        }
    }

    @FXML
    void agregarPaciente(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        Paciente nuevo = buildPaciente();
        if (pacienteController.crearPaciente(nuevo)) {
            listPacientes.add(nuevo);
            limpiarCampos();
        }
    }

    @FXML
    void actualizarPaciente(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        if (selectedPaciente != null && pacienteController.modificarPaciente(selectedPaciente.getCedula(), buildPaciente())) {
            int index = listPacientes.indexOf(selectedPaciente);
            listPacientes.set(index, buildPaciente());
            tblListPaciente.refresh();
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void eliminarPaciente(ActionEvent event) {
        if (pacienteController.eliminarPaciente(txtID.getText())) {
            listPacientes.remove(selectedPaciente);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void deseleccionarPaciente(ActionEvent event) {
        limpiarSeleccion();
    }

    private void limpiarSeleccion() {
        tblListPaciente.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtID.clear();
        txtNombrePaciente.clear();
        txtApellidoPaciente.clear();
        txtEmailPaciente.clear();
        txtTelefonoPaciente.clear();
        dateFechaNacimiento.setValue(null);
        menuGeneroPaciente.setText("Género");
        menuTipoSangre.setText("Tipo de sangre");
    }

    private Paciente buildPaciente() {
        return new Paciente(
                txtID.getText(),
                txtNombrePaciente.getText(),
                txtApellidoPaciente.getText(),
                dateFechaNacimiento.getValue(),
                Genero.fromTexto(menuGeneroPaciente.getText()),
                TipoSangre.fromTexto(menuTipoSangre.getText()),
                txtEmailPaciente.getText(),
                txtTelefonoPaciente.getText()
        );
    }

    //Botones tipo de sangre (A,B,AB,O - Positivo o negativo)

    @FXML
    void btnABNegativo() {
        menuTipoSangre.setText(TipoSangre.ABNEGATIVO.tipoSangre);
    }

    @FXML
    void btnABPositivo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.ABPOSITIVO.tipoSangre);
    }

    @FXML
    void btnANegativo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.ANEGATIVO.tipoSangre);
    }

    @FXML
    void btnAPositivo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.APOSITIVO.tipoSangre);
    }

    @FXML
    void btnBNegativo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.BNEGATIVO.tipoSangre);
    }

    @FXML
    void btnBPositivo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.BPOSITIVO.tipoSangre);
    }

    @FXML
    void btnONegativo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.ONEGATIVO.tipoSangre);
    }

    @FXML
    void btnOPositivo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.OPOSITIVO.tipoSangre);
    }


    //Botones de género (masculino, femenino, otro)
    @FXML
    void btnGeneroFemenino(ActionEvent event) {
        menuGeneroPaciente.setText(Genero.FEMENINO.genero);
    }

    @FXML
    void btnGeneroMasculino(ActionEvent event) {
        menuGeneroPaciente.setText(Genero.MASCULINO.genero);
    }

    @FXML
    void btnOtroGenero(ActionEvent event) {
        menuGeneroPaciente.setText(Genero.OTRO.genero);
    }

    @FXML
    void btnBackToAdmin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "admin.fxml");
    }


    @FXML
    void mostrarInformacionPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = tblListPaciente.getSelectionModel().getSelectedItem();
        if (pacienteSeleccionado == null) return;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospitalproject/detallePaciente.fxml"));
            Parent root = loader.load();

            DetallePacienteViewController controller = loader.getController();
            Stage dialog = new Stage();
            controller.setPaciente(pacienteSeleccionado);
            controller.setStage(dialog);

            dialog.setTitle("Información del Paciente");
            dialog.setScene(new Scene(root));
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private boolean validarCampos() {
        if (txtID.getText().isEmpty() ||
                txtNombrePaciente.getText().isEmpty() ||
                txtApellidoPaciente.getText().isEmpty() ||
                txtEmailPaciente.getText().isEmpty() ||
                dateFechaNacimiento.getValue() == null ||
                menuGeneroPaciente.getText().equals("Género") ||
                menuTipoSangre.getText().equals("Tipo de sangre") ||
                txtTelefonoPaciente.getText().isEmpty()){

            showAlert("Por favor complete todos los campos obligatorios.");
            return false;
        }
        return true;
    }

}
