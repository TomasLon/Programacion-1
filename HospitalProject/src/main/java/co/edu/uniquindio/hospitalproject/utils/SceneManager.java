package co.edu.uniquindio.hospitalproject.utils;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//Este metodo nos permite cambiar entre interfaces sin necesidad de estarlas cerrando y abriendo
//Cada vez que necesitamos
public class SceneManager {
    public static <T> T cambiarEscena(Stage stage, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/co/edu/uniquindio/hospitalproject/"+rutaFXML));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            return loader.getController();
        } catch (IOException e) {
//            System.out.println("Error al cambiar de escena: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
