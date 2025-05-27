package co.edu.uniquindio.hospitalproject.viewController;

import co.edu.uniquindio.hospitalproject.model.HistorialMedico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class ConsultarHistorialMedico {

        @FXML
        private Button btmVolver;

        @FXML
        private Label lblCedulaPaciente;

        @FXML
        private Label lblNombrePaciente;

        @FXML
        private TableColumn<HistorialMedico, String> tbcNombre;

        @FXML
        private TableColumn<HistorialMedico, String> tbcDiagnostico;

        @FXML
        private TableColumn<HistorialMedico, String> tbcTratamiento;

        @FXML
        private TableColumn<HistorialMedico, LocalDate> tbcFecha;

        @FXML
        private TableView<HistorialMedico> tblHistorialMedico;

        @FXML
        public void initialize() {
                configurarTabla();
        }

        private void configurarTabla() {
                tbcNombre.setCellValueFactory(cellData ->
                        javafx.beans.binding.Bindings.createStringBinding(() ->
                                cellData.getValue().paciente().getNombre()));

                tbcDiagnostico.setCellValueFactory(cellData ->
                        javafx.beans.binding.Bindings.createObjectBinding(() ->
                                cellData.getValue().diagnostico()));

                tbcTratamiento.setCellValueFactory(cellData ->
                        javafx.beans.binding.Bindings.createObjectBinding(() ->
                                cellData.getValue().tratamiento()));

                tbcFecha.setCellValueFactory(cellData ->
                        javafx.beans.binding.Bindings.createObjectBinding(() ->
                                cellData.getValue().fechaConsulta()));
        }


        public void setHistorialMedico(javafx.collections.ObservableList<HistorialMedico> historial) {
                tblHistorialMedico.setItems(historial);
        }
}
