package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.model.CitaMedica;
import co.edu.uniquindio.hospitalproject.model.enums.EstadoCita;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CambiarEstadoCitaViewController {

    @FXML
    private MenuButton menuEstadoCita;

    @FXML
    private MenuItem optCancelada;

    @FXML
    private MenuItem optConfirmar;

    @FXML
    private MenuItem optEnEspera;

    @FXML
    private MenuItem optFinalizada;

    @FXML
    private MenuItem optPendiente;

    @FXML
    private MenuItem optReprogramada;

    @FXML
    private TableView<CitaMedica> tblListCitas;

    @FXML
    private TableColumn<CitaMedica, String> tbcNombre;

    @FXML
    private TableColumn<CitaMedica, String> tbcApellido;

    @FXML
    private TableColumn<CitaMedica, String> tbcCedula;

    @FXML
    void initialize() {
        optConfirmar.setOnAction(e -> cambiarEstadoCita(EstadoCita.CONFIRMADA));
        optCancelada.setOnAction(e -> cambiarEstadoCita(EstadoCita.CANCELADA));
        optEnEspera.setOnAction(e -> cambiarEstadoCita(EstadoCita.ENESPERA));
        optFinalizada.setOnAction(e -> cambiarEstadoCita(EstadoCita.FINALIZADA));
        optPendiente.setOnAction(e -> cambiarEstadoCita(EstadoCita.PENDIENTE));
        optReprogramada.setOnAction(e -> cambiarEstadoCita(EstadoCita.REPROGRAMADA));
    }

    private void cambiarEstadoCita(EstadoCita nuevoEstado) {
        CitaMedica cita = tblListCitas.getSelectionModel().getSelectedItem();
        if (cita != null) {
            cita.setEstadoCita(nuevoEstado);
            menuEstadoCita.setText(nuevoEstado.name());
            tblListCitas.refresh();
        }
    }
}
