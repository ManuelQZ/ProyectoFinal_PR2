package co.edu.uniquindio.parcial1fx.proyecto.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> tableViewUsuario;

    @FXML
    private TextField txtSaldo;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtnombre;

    @FXML
    void addUsuario(ActionEvent event) {

    }

    @FXML
    void removeUsuario(ActionEvent event) {

    }

    @FXML
    void updateUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tableViewUsuario != null : "fx:id=\"tableViewUsuario\" was not injected: check your FXML file 'main.fxml'.";
        assert txtSaldo != null : "fx:id=\"txtSaldo\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'main.fxml'.";
        assert txtnombre != null : "fx:id=\"txtnombre\" was not injected: check your FXML file 'main.fxml'.";

    }
}
