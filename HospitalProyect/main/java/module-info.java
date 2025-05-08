module org.edu.uniquindio.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.edu.uniquindio.proyectofinal to javafx.fxml;
    exports org.edu.uniquindio.proyectofinal;
}