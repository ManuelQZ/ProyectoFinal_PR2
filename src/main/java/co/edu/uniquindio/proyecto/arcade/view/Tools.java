package co.edu.uniquindio.proyecto.arcade.view;

import co.edu.uniquindio.proyecto.arcade.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tools {

    private static void mostrarMensaje(String title, String header, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void ventanaEmergente(String url, String title) {
        Scene scene = new Scene(new Pane());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(url));
            scene = new Scene(fxmlLoader.load());
        }catch (Exception e){
            mostrarMensaje("Error", "Error al cargar la ventana", e.getMessage(), Alert.AlertType.ERROR);
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
    }
