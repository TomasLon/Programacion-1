package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.CrudDoctorController;
import co.edu.uniquindio.hospitalproject.model.Doctor;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.enums.Especializacion;
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

public class CrudDoctorViewController {

    private CrudDoctorController doctorController;
    private ObservableList<Doctor> listDoctores = FXCollections.observableArrayList();
    private Doctor selectedDoctor;

    @FXML
    private MenuItem btnMedicoGeneral, btnOdontologo, btnOftalmologo, btnInmunologo, btnOncologo, btnNeurologo, btnReumatologo;

    @FXML
    private MenuItem btnABNegativo;

    @FXML
    private MenuItem btnABPositivo;

    @FXML
    private MenuItem btnANegativo;

    @FXML
    private MenuItem btnAPositivo;

    @FXML
    private Button btnActualizarDoctor;

    @FXML
    private Button btnAgregarDoctor;

    @FXML
    private MenuItem btnBNegativo;

    @FXML
    private MenuItem btnBPositivo;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnEliminarDoctor;

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
    private CheckBox checkDisponible;

    @FXML
    private DatePicker dateFechaNacimiento;

    @FXML
    private MenuButton menuEspecializacion;

    @FXML
    private MenuButton menuGeneroDoctor;

    @FXML
    private MenuButton menuTipoSangre;

    @FXML
    private TableColumn<Doctor, String> tbcApellido, tbcCedula, tbcNombre;

    @FXML
    private TableView<Doctor> tblListDoctor;

    @FXML
    private TextField txtApellidoDoctor;

    @FXML
    private TextField txtCedulaProfesional;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombreDoctor;

    @FXML
    void onDoctorDisponible(ActionEvent event) {
        if(checkDisponible.isSelected()){
            checkDisponible.setText("Disponible");
        }else {
            checkDisponible.setText("No Disponible");
        }
    }

    //Botones especializacion

    @FXML
    void especializacionInmunólogo(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.INMUNOLOGO.especializacion);
    }

    @FXML
    void especializacionMedicoGeneral(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.MEDICOGENERAL.especializacion);
    }

    @FXML
    void especializacionNeurologo(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.NEUROLOGO.especializacion);
    }

    @FXML
    void especializacionOdontologo(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.ODONTOLOGO.especializacion);
    }

    @FXML
    void especializacionOftalmologo(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.OFTALMOLOGO.especializacion);
    }

    @FXML
    void especializacionOncologo(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.ONCOLOGO.especializacion);
    }

    @FXML
    void especializacionReumatologo(ActionEvent event) {
        menuEspecializacion.setText(Especializacion.REUMATOLOGO.especializacion);
    }


    //Botones tipo sangre

    @FXML
    void btnONegativo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.ONEGATIVO.tipoSangre);
    }

    @FXML
    void btnOPositivo(ActionEvent event) {
        menuTipoSangre.setText(TipoSangre.OPOSITIVO.tipoSangre);
    }

    @FXML
    void btnABNegativo(ActionEvent event) {
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

    //Boton para volver a Admin

    @FXML
    void btnBackToAdmin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "admin.fxml");
    }

    //Botones género

    @FXML
    void btnGeneroFemenino(ActionEvent event) {
        menuGeneroDoctor.setText(Genero.FEMENINO.genero);
    }

    @FXML
    void btnGeneroMasculino(ActionEvent event) {
        menuGeneroDoctor.setText(Genero.MASCULINO.genero);
    }


    @FXML
    void btnOtroGenero(ActionEvent event) {
        menuGeneroDoctor.setText(Genero.OTRO.genero);
    }


    //Metodos necesarios

    private Doctor buildDoctor(){
        return new Doctor(
                txtID.getText(),
                txtNombreDoctor.getText(),
                txtApellidoDoctor.getText(),
                dateFechaNacimiento.getValue(),
                Genero.fromTexto(menuGeneroDoctor.getText()),
                TipoSangre.fromTexto(menuTipoSangre.getText()),
                Especializacion.fromTexto(menuEspecializacion.getText()),
                txtCedulaProfesional.getText(),
                checkDisponible.isSelected()
        );
    }

    private void limpiarCampos() {
        txtID.clear();
        txtNombreDoctor.clear();
        txtApellidoDoctor.clear();
        txtCedulaProfesional.clear();
        menuEspecializacion.setText("Especialización");
        dateFechaNacimiento.setValue(null);
        menuGeneroDoctor.setText("Género");
        menuTipoSangre.setText("Tipo de sangre");
        checkDisponible.setSelected(false);
    }

    private void limpiarSeleccion() {
        tblListDoctor.getSelectionModel().clearSelection();
        limpiarCampos();
    }


    //Botones con funciones de agregar, eliminar, etc

    @FXML
    void agregarDoctor(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        Doctor nuevo = buildDoctor();
        if(doctorController.agregarDoctor(nuevo)){
            listDoctores.add(nuevo);
            limpiarCampos();
        }
    }

    @FXML
    void actualizarDoctor(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        if (selectedDoctor != null && doctorController.actualizarDoctor(selectedDoctor.getCedula(), buildDoctor())) {
            int index = listDoctores.indexOf(selectedDoctor);
            listDoctores.set(index, buildDoctor());
            tblListDoctor.refresh();
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void deseleccionarDoctor(ActionEvent event) {
        limpiarSeleccion();
    }

    @FXML
    void eliminarDoctor(ActionEvent event) {
        if (doctorController.eliminarDoctor(txtID.getText())) {
            listDoctores.remove(selectedDoctor);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void mostrarInformacionDoctor(ActionEvent event) {
        Doctor doctorSeleccionado = tblListDoctor.getSelectionModel().getSelectedItem();
        if (doctorSeleccionado == null) return;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospitalproject/detalleDoctor.fxml"));
            Parent root = loader.load();

            DetalleDoctorViewController controller = loader.getController();
            Stage dialog = new Stage();
            controller.setDoctor(doctorSeleccionado);
            controller.setStage(dialog);

            dialog.setTitle("Información del doctor");
            dialog.setScene(new Scene(root));
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void actualizarCheckDisponible(boolean disponible) {
//        checkDisponible.setSelected(disponible);
//    }

    @FXML
    void initialize() {
        doctorController = new CrudDoctorController(Hospital.getInstancia());
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerDoctores();
        tblListDoctor.getItems().clear();
        tblListDoctor.setItems(listDoctores);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tbcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    }

    private void obtenerDoctores() {
        listDoctores.addAll(doctorController.listarDoctores());
    }

    private void listenerSelection() {
        tblListDoctor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedDoctor = newSelection;
            informacionDoctor(newSelection);
        });
    }

    private void informacionDoctor(Doctor doctor) {
        if (doctor != null) {
            txtID.setText(doctor.getCedula());
            txtNombreDoctor.setText(doctor.getNombre());
            txtApellidoDoctor.setText(doctor.getApellido());
            txtCedulaProfesional.setText(doctor.getIdProfesional());
            checkDisponible.setText(doctor.getDoctorDisponible() ? "Disponible" : "No Disponible");
            dateFechaNacimiento.setValue(doctor.getFechaNacimiento());
            menuGeneroDoctor.setText(doctor.getGenero().genero);
            menuTipoSangre.setText(doctor.getTipoSangre().tipoSangre);
            menuEspecializacion.setText(doctor.getEspecializacion().especializacion);
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
                txtNombreDoctor.getText().isEmpty() ||
                txtApellidoDoctor.getText().isEmpty() ||
                txtCedulaProfesional.getText().isEmpty() ||
                dateFechaNacimiento.getValue() == null ||
                menuEspecializacion.getText().equals("Especialización") ||
                menuGeneroDoctor.getText().equals("Género") ||
                menuTipoSangre.getText().equals("Tipo de sangre")) {

            showAlert("Por favor complete todos los campos obligatorios.");
            return false;
        }
        return true;
    }

}
