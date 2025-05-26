package co.edu.uniquindio.hospitalproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagenes/iconoApp.png")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/hospitalproject/admin.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Sistema Hospitalario");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

