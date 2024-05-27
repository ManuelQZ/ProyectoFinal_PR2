package co.edu.uniquindio.proyecto.arcade;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalaceFacade;
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
        ProductivityPalaceFacade facade = new ProductivityPalaceFacade();

        // Gestión de usuarios
        System.out.println("Registrando usuarios...");
        facade.registrarUsuario("Juan Perez", "juan.perez@example.com", "clave123", "100.0", TipoUsuario.CLIENTE);
        facade.registrarUsuario("Maria Gomez", "maria.gomez@example.com", "clave456", "200.0", TipoUsuario.EMPLEADO);

        // Gestión de pagos
        System.out.println("Registrando pagos...");
        String[] productos = {"Palomitas"};

        PagoStrategy pagoTarjeta = new PagoTarjeta("1234-5678-9876-5432");
        facade.registerPayment("maria.gomez@example.com", pagoTarjeta, 5.50, "2024-05-27", productos);

        PagoStrategy pagoEfectivo = new PagoEfectivo();
        facade.registerPayment("juan.perez@example.com", pagoEfectivo, 3.00, "2024-05-28", productos);

        PagoStrategy pagoPayPal = new PagoPayPal("juan.perez@paypal.com");
        facade.registerPayment("maria.gomez@example.com", pagoPayPal, 7.00, "2024-05-29", productos);

        System.out.println("Operaciones completadas.");


        launch();
    }
}