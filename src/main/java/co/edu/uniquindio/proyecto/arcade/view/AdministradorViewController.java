package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AdministradorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tbcCantidad;

    @FXML
    private TableColumn<?, ?> tbcCorreoUsuario;

    @FXML
    private TableColumn<?, ?> tbcNombreUsuario;

    @FXML
    private TableColumn<?, ?> tbcPrecio;

    @FXML
    private TableColumn<?, ?> tbcProducto;

    @FXML
    private TableColumn<?, ?> tbcReserva;

    @FXML
    private TableView<?> tbvGestionProducto;

    @FXML
    private TableView<?> tbvGestionUsuario;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtProducto;

    @FXML
    private TextField txtUsuario;

    @FXML
    void addActualizarProducto(ActionEvent event) {

    }

    @FXML
    void addActualizarUsuario(ActionEvent event) {

    }

    @FXML
    void addContrasena(ActionEvent event) {

    }

    @FXML
    void addUsuario(ActionEvent event) {

    }

    @FXML
    void addcorreo(ActionEvent event) {

    }

    @FXML
    void removeEliminarProducto(ActionEvent event) {

    }

    @FXML
    void removeEliminarUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tbcCantidad != null : "fx:id=\"tbcCantidad\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbcCorreoUsuario != null : "fx:id=\"tbcCorreoUsuario\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbcNombreUsuario != null : "fx:id=\"tbcNombreUsuario\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbcPrecio != null : "fx:id=\"tbcPrecio\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbcProducto != null : "fx:id=\"tbcProducto\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbcReserva != null : "fx:id=\"tbcReserva\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbvGestionProducto != null : "fx:id=\"tbvGestionProducto\" was not injected: check your FXML file 'administrador.fxml'.";
        assert tbvGestionUsuario != null : "fx:id=\"tbvGestionUsuario\" was not injected: check your FXML file 'administrador.fxml'.";
        assert txtCantidad != null : "fx:id=\"txtCantidad\" was not injected: check your FXML file 'administrador.fxml'.";
        assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'administrador.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'administrador.fxml'.";
        assert txtPrecio != null : "fx:id=\"txtPrecio\" was not injected: check your FXML file 'administrador.fxml'.";
        assert txtProducto != null : "fx:id=\"txtProducto\" was not injected: check your FXML file 'administrador.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'administrador.fxml'.";

    }
}
