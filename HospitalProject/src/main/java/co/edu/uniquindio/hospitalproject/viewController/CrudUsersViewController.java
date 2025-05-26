package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.CrudUserController;
import co.edu.uniquindio.hospitalproject.model.*;
import co.edu.uniquindio.hospitalproject.model.enums.TipoRol;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CrudUsersViewController {

    private CrudUserController userController;
    private ObservableList<Usuario> listUsers = FXCollections.observableArrayList();
    private Usuario selectedUser;

    @FXML
    private Button btnActualizarUser;

    @FXML
    private Button btnAgregarUser;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private MenuItem btnRolDoctor;

    @FXML
    private MenuItem btnRolPaciente;

    @FXML
    private MenuButton menuRolUser;

    @FXML
    private TableColumn<String, Usuario> tbcUsername, tbcRol;

    @FXML
    private TableView<Usuario> tblListUsers;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPersonaAsignar;

    //Tipo de rol del Usuario

    @FXML
    void rolDoctor(ActionEvent event) {
        menuRolUser.setText(TipoRol.DOCTOR.tipoRol);
    }

    @FXML
    void rolPaciente(ActionEvent event) {
        menuRolUser.setText(TipoRol.PACIENTE.tipoRol);
    }

    @FXML
    void initialize() {
        userController = new CrudUserController(Hospital.getInstancia());
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerUsers();
        tblListUsers.getItems().clear();
        tblListUsers.setItems(listUsers);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcUsername.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tbcRol.setCellValueFactory(new PropertyValueFactory<>("tipoRol"));
    }

    private void obtenerUsers() {
        listUsers.addAll(userController.listarUsuarios());
    }

    private void listenerSelection() {
        tblListUsers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedUser = newSelection;
            informacionUser(newSelection);
        });
    }

    private void informacionUser(Usuario usuario) {
        if (usuario != null) {
            txtUser.setText(usuario.getUsuario());
            txtPassword.setText(usuario.getPassword());
            menuRolUser.setText(usuario.getTipoRol().toString());
            txtPersonaAsignar.setText(usuario.getPersona().getCedula());
        }
    }

    private void limpiarSeleccion() {
        tblListUsers.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtUser.clear();
        txtPassword.clear();
        menuRolUser.setText("Rol");
        txtPersonaAsignar.clear();
    }

    private Usuario buildUsuario() {
        String personaId = txtPersonaAsignar.getText().trim();
        if(personaId.isEmpty()) {
            showAlert("Debe ingresar el ID de la persona a vincular.");
            return null;
        }
        Persona personaAsignar = userController.buscarPersonaID(personaId);
        if(personaAsignar == null) {
            showAlert("Esta persona no está en la base de datos, registrela primero");
            return null;
        }

        return new Usuario(
                txtUser.getText(),
                txtPassword.getText(),
                TipoRol.fromTexto(menuRolUser.getText()),
                personaAsignar
        );
    }



    @FXML
    void actualizarUser(ActionEvent event) {
        if (!validarCampos()){
            return;
        }
        if (selectedUser != null && userController.modificarUsuario(selectedUser.getUsuario(), buildUsuario())) {
            int index = listUsers.indexOf(selectedUser);
            listUsers.set(index, buildUsuario());
            tblListUsers.refresh();
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    @FXML
    void agregarUser(ActionEvent event) {
        if (!validarCampos()){
            return;
        }
        Usuario nuevo = buildUsuario();
        ;
        if(nuevo == null) {
            return;
        }
        Persona nuevoValidar = nuevo.getPersona();
        if(nuevoValidar == null) {
            return;
        }
        if (nuevoValidar instanceof Paciente && menuRolUser.getText().equalsIgnoreCase("Paciente")) {
            if (userController.crearUser(nuevo)) {
                listUsers.add(nuevo);
                limpiarCampos();
            }
        } else if (nuevoValidar instanceof Doctor && menuRolUser.getText().equalsIgnoreCase("Doctor")) {
            if (userController.crearUser(nuevo)) {
                listUsers.add(nuevo);
                limpiarCampos();
            }
        }else {
            showAlert("El rol no coincide con la persona ingresada, intente nuevamente.");
        }

    }

    @FXML
    void btnBackToAdmin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "admin.fxml");
    }

    @FXML
    void deseleccionarUsuario(ActionEvent event) {
        limpiarSeleccion();
    }

    @FXML
    void eliminarUsuario(ActionEvent event) {
        if (userController.eliminarUsuario(txtUser.getText())) {
            listUsers.remove(selectedUser);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    //Validaciones de que se llenen todos los campos
    private void showAlert(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private boolean validarCampos() {
        if (txtUser.getText().isEmpty() ||
                txtPassword.getText().isEmpty() ||
        menuRolUser.getText().equals("Rol")) {
            showAlert("Por favor complete todos los campos obligatorios.");
            return false;
        }
        return true;
    }
}
