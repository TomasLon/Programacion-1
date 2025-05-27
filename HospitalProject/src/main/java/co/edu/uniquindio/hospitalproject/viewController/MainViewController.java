package co.edu.uniquindio.hospitalproject.viewController;

//import co.edu.uniquindio.hospitalproject.model.Administrador;
import co.edu.uniquindio.hospitalproject.model.Administrador;
import co.edu.uniquindio.hospitalproject.model.Hospital;
//import co.edu.uniquindio.hospitalproject.model.Usuario;
import co.edu.uniquindio.hospitalproject.model.Usuario;
import co.edu.uniquindio.hospitalproject.model.enums.TipoRol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import co.edu.uniquindio.hospitalproject.utils.SceneManager;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.LinkedList;

public class MainViewController {


    @FXML
    private Button btnToLogin;

    @FXML
    private Label lblNombreHospitalBienvenida;


    @FXML
    void goToLogin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Hospital hospital = Hospital.getInstancia();
        hospital.precargarDatos();

        Collection<Administrador> listAdmins = hospital.listarAdmin();
        LinkedList<Usuario> listUsers = hospital.getListUsers();
        LoginViewController loginVC = SceneManager.cambiarEscena(stage, "login.fxml");
        if(loginVC != null) {
            loginVC.setListAdmins((LinkedList<Administrador>) listAdmins);
            loginVC.setListUsuarios(listUsers);
        }

    }


}
