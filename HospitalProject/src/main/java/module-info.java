module co.edu.uniquindio.hospitalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.hospitalproject to javafx.fxml;
    exports co.edu.uniquindio.hospitalproject;

    opens co.edu.uniquindio.hospitalproject.controller to javafx.fxml;
    exports co.edu.uniquindio.hospitalproject.controller;

    opens co.edu.uniquindio.hospitalproject.model to javafx.fxml;
    exports co.edu.uniquindio.hospitalproject.model;

    opens co.edu.uniquindio.hospitalproject.viewController to javafx.fxml;
    exports co.edu.uniquindio.hospitalproject.viewController;


}