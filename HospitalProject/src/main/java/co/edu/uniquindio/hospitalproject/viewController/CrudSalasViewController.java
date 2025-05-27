package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.CrudSalasController;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Sala;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CrudSalasViewController {

    private boolean salaDisponible;
    private CrudSalasController salasController;
    private ObservableList<Sala> listSalas = FXCollections.observableArrayList();
    private Sala selectedSala;

    @FXML
    private Button btnActualizarSala;

    @FXML
    private Button btnAgregarSala;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private MenuItem btnDisponibleNo;

    @FXML
    private MenuItem btnDisponibleSi;

    @FXML
    private Button btnEliminarSala;

    @FXML
    private MenuButton menuDisponible;

    @FXML
    private TableColumn<String, Sala> tbcIdSala, tbcNombreSala;

    @FXML
    private TableColumn<Sala, String> tbcDisponible;

    @FXML
    private TableView<Sala> tblListSalas;

    @FXML
    private TextField txtSalaID;

    @FXML
    private TextField txtSalaNombre;

    public void initialize() {
        salasController = new CrudSalasController(Hospital.getInstancia());
        initView();
    }

    void initView() {
        initDataBinding();
        obtenerSalas();
        tblListSalas.getItems().clear();
        tblListSalas.setItems(listSalas);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcIdSala.setCellValueFactory(new PropertyValueFactory<>("idSala"));
        tbcNombreSala.setCellValueFactory(new PropertyValueFactory<>("nombreSala"));
        tbcDisponible.setCellValueFactory(cellData -> {
            Boolean estado = cellData.getValue().getEstadoSala();
            String estadoTexto = (estado != null && estado) ? "Si" : "No";
            return new ReadOnlyStringWrapper(estadoTexto);
        });

    }

    private void obtenerSalas() {
        listSalas.addAll(salasController.listarSalas());
    }

    private void listenerSelection() {
        tblListSalas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedSala = newSelection;
            informacionSala(newSelection);
        });
    }

    private void informacionSala(Sala salaInf) {
        if (salaInf != null) {
            txtSalaID.setText(salaInf.getIdSala());
            txtSalaNombre.setText(salaInf.getNombreSala());
            menuDisponible.setText(salaInf.getEstadoSala() ? "Disponible" : "Ocupada");
        }
    }

    private void limpiarSeleccion() {
        tblListSalas.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtSalaID.clear();
        txtSalaNombre.clear();
        menuDisponible.setText("¿Disponible?");
    }

    private Sala buildSala() {
        return new Sala(
                txtSalaID.getText().trim(),
                txtSalaNombre.getText().trim(),
                salaDisponible);
    }

    @FXML
    void btnBackToAdmin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "admin.fxml");
    }

    //Botones CRUD (Create, Read, Update, Delete)
    @FXML
    void deseleccionar(ActionEvent event) {
        limpiarSeleccion();
    }

    @FXML
    void eliminar(ActionEvent event) {
        if (salasController.eliminarSala(txtSalaID.getText())) {
            listSalas.remove(selectedSala);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void actualizar(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        if (selectedSala != null && salasController.modificarSala(selectedSala.getIdSala(), buildSala())) {
            int index = listSalas.indexOf(selectedSala);
            listSalas.set(index, buildSala());
            tblListSalas.refresh();
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void agregar(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        Sala newSala = buildSala();
        if (salasController.crearSala(newSala)) {
            listSalas.add(newSala);
            limpiarCampos();
        }
    }

    //Opción para elegir si una sala está o no disponible
    @FXML
    void disponibleNo(ActionEvent event) {
        salaDisponible = false;
        menuDisponible.setText("Ocupada");
    }

    @FXML
    void disponibleSi(ActionEvent event) {
        salaDisponible = true;
        menuDisponible.setText("Disponible");
    }

    //Validaciones para que todos los campos sean rellenados
    private void showAlert(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private boolean validarCampos() {
        if (txtSalaID.getText().isEmpty() ||
                txtSalaNombre.getText().isEmpty() ||
                menuDisponible.getText().equals("¿Disponible?")) {
            showAlert("Por favor, complete todos los campos obligatorios.");
            return false;
        }
        return true;
    }
}
