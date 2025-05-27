package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.controller.AdminController;
import co.edu.uniquindio.hospitalproject.controller.DoctorController;
import co.edu.uniquindio.hospitalproject.controller.PacienteController;
import co.edu.uniquindio.hospitalproject.model.Administrador;
import co.edu.uniquindio.hospitalproject.model.Hospital;
import co.edu.uniquindio.hospitalproject.model.Usuario;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import co.edu.uniquindio.hospitalproject.controller.LoginController;

import java.util.LinkedList;


public class LoginViewController {
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLoginBack;

    @FXML
    private MenuItem btnRolAdmin;

    @FXML
    private MenuItem btnRolDoctor;

    @FXML
    private MenuItem btnRolPaciente;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private MenuButton menuRol;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnRolAdmin(ActionEvent event) {
        menuRol.setText("Administrador");
    }

    @FXML
    void btnRolDoctor(ActionEvent event) {
        menuRol.setText("Doctor");
    }

    @FXML
    void btnRolPaciente(ActionEvent event) {
        menuRol.setText("Paciente");
    }

    @FXML
    void onBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "main.fxml");
    }

    Hospital hospital;

    AdminController controllerAdmin;

    LoginController controller;

    private LinkedList<Administrador> listAdmins;

    public void setListAdmins(LinkedList<Administrador> listAdmins) {
        this.listAdmins = listAdmins;
        this.controller = new LoginController();
        controller.setListAdmins(listAdmins);
    }

    private LinkedList<Usuario>listUsers;

    public void setListUsuarios(LinkedList<Usuario> listUsers) {
        this.listUsers = listUsers;
        this.controller = new LoginController();
        controller.setListUsers(listUsers);
    }
    @FXML
    void validarLogin(ActionEvent event) {
        String username = txtUsername.getText().trim();
        String password = fieldPassword.getText().trim();
        String userRol = menuRol.getText().trim();


        controller.setListUsers(listUsers);
        boolean validarLogin = controller.validarUsuario(username, password, userRol);

        if (validarLogin) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            switch (userRol){
                case "Doctor" -> {
                    DoctorViewController doctorVC = SceneManager.cambiarEscena(stage, "doctor.fxml");
                    if(doctorVC != null){
                        DoctorController doctorC = new DoctorController(hospital.getInstancia());
                        String nombreDoctor = doctorC.retornarNombreDoc(username);
                        doctorVC.agregarNombreDoctor(nombreDoctor);
                    }

                }
                case "Administrador" -> {
                    AdminViewController adminVC = SceneManager.cambiarEscena(stage, "admin.fxml");
                    if(adminVC != null){
                        AdminController adminC = new AdminController(hospital.getInstancia());
                        String nombreAdmin = adminC.retornarNombreAdmin(username);
                        adminVC.agregarNombreAdminTitulo(nombreAdmin);
                    }

                }
                case "Paciente" -> {
                    PacienteViewController pacienteVC = SceneManager.cambiarEscena(stage, "paciente.fxml");
                    if(pacienteVC != null){
                        PacienteController pacienteC = new PacienteController(hospital.getInstancia());
                        String nombrePaciente = pacienteC.retornarNombrePaciente(username);
                        pacienteVC.agregarNombrePaciente(nombrePaciente);
                    }
                }
            }
        }else {
            mostrarAlertaError("Usuario, contraseña o rol incorrecto, intente nuevamente");
        }
    }

    private void mostrarAlertaError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de inicio de sesión");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

