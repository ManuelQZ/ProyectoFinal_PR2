package co.edu.uniquindio.proyecto.arcade.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CrearUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtUsuario1;

    @FXML
    void Cancelar(ActionEvent event) {

    }

    @FXML
    void CrearUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'CrearUsuario.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'CrearUsuario.fxml'.";
        assert txtUsuario1 != null : "fx:id=\"txtUsuario1\" was not injected: check your FXML file 'CrearUsuario.fxml'.";

    }
}