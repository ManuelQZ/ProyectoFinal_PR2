package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtUsuario;

    @FXML
    void crearUsuario(ActionEvent event) {

    }

    @FXML
    void ingresar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'login.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'login.fxml'.";

    }

}