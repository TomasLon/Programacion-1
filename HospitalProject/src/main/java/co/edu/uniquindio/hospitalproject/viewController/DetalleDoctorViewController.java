package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.model.Doctor;
import co.edu.uniquindio.hospitalproject.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetalleDoctorViewController {

    CrudDoctorViewController doctorViewController;

    private Stage stage;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblDisponible;

    @FXML
    private Label lblEspecializacion;

    @FXML
    private Label lblFechaNacimiento;

    @FXML
    private Label lblGenero;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTipoSangre;

    @FXML
    private Label lblidProfesional;

    public void setDoctor(Doctor doctor) {
        lblCedula.setText("Cédula: " + doctor.getCedula());
        lblNombre.setText("Nombre: " + doctor.getNombre());
        lblApellido.setText("Apellido: " + doctor.getApellido());
        lblFechaNacimiento.setText("Nacimiento: " + doctor.getFechaNacimiento());
        lblGenero.setText("Genero: " + doctor.getGenero().genero);
        lblTipoSangre.setText("Tipo de sangre: " + doctor.getTipoSangre().tipoSangre);
        lblEspecializacion.setText("Especializacion: " + doctor.getEspecializacion());
        lblidProfesional.setText("Profesional: " + doctor.getIdProfesional());
        lblDisponible.setText("Doctor disponible: " + (doctor.getDoctorDisponible() ? "Sí" : "No"));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
        stage.close();
    }

}
