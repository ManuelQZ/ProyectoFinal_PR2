package co.edu.uniquindio.proyecto.arcade;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoEfectivo;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoPayPal;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoStrategy;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoTarjeta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("Estilos/login.css").toExternalForm());
        stage.setTitle("Productivity Palace");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}