package co.edu.uniquindio.parcial1fx.proyecto.ViewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageViewLogo;

    @FXML
    private TableView<?> tableViewVehiculoTransporte;

    @FXML
    private TableColumn<?, ?> tbCorreo;

    @FXML
    private TableColumn<?, ?> tbNombre;

    @FXML
    private TableColumn<?, ?> tbSaldo;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtSaldo;

    @FXML
    void UpdateUsuario(ActionEvent event) {

    }

    @FXML
    void addUsuario(ActionEvent event) {

    }

    @FXML
    void removeUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert imageViewLogo != null : "fx:id=\"imageViewLogo\" was not injected: check your FXML file 'main.fxml'.";
        assert tableViewVehiculoTransporte != null : "fx:id=\"tableViewVehiculoTransporte\" was not injected: check your FXML file 'main.fxml'.";
        assert tbCorreo != null : "fx:id=\"tbCorreo\" was not injected: check your FXML file 'main.fxml'.";
        assert tbNombre != null : "fx:id=\"tbNombre\" was not injected: check your FXML file 'main.fxml'.";
        assert tbSaldo != null : "fx:id=\"tbSaldo\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'main.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'main.fxml'.";
        assert txtSaldo != null : "fx:id=\"txtSaldo\" was not injected: check your FXML file 'main.fxml'.";

    }

}
