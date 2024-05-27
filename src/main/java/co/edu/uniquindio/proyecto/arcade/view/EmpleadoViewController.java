package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmpleadoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tbcCorreoUsuarios;

    @FXML
    private TableColumn<Reserva, String> tbcFechaReservas;

    @FXML
    private TableColumn<Reserva, String> tbcNombreReservas;

    @FXML
    private TableColumn<Usuario, String> tbcNombreUsuarios;

    @FXML
    private TableView<Reserva> tbvGestionFecha;

    @FXML
    private TableView<Usuario> tbvGestionUsuarios;

    @FXML
    private TextField txtCantidadReservas;

    @FXML
    private TextField txtContrasenaUsuarios;

    @FXML
    private TextField txtCorreoUsuario;

    @FXML
    private TextField txtNombreReservas;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    void addReserva(ActionEvent event) {

    }

    @FXML
    void addUsuarios(ActionEvent event) {

    }

    @FXML
    void removeReserva(ActionEvent event) {

    }

    @FXML
    void removeUsuarios(ActionEvent event) {

    }

    @FXML
    void updateReserva(ActionEvent event) {

    }

    @FXML
    void updateUsuarios(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tbcCorreoUsuarios != null : "fx:id=\"tbcCorreoUsuarios\" was not injected: check your FXML file 'empleado.fxml'.";
        assert tbcFechaReservas != null : "fx:id=\"tbcFechaReservas\" was not injected: check your FXML file 'empleado.fxml'.";
        assert tbcNombreReservas != null : "fx:id=\"tbcNombreReservas\" was not injected: check your FXML file 'empleado.fxml'.";
        assert tbcNombreUsuarios != null : "fx:id=\"tbcNombreUsuarios\" was not injected: check your FXML file 'empleado.fxml'.";
        assert tbvGestionFecha != null : "fx:id=\"tbvGestionFecha\" was not injected: check your FXML file 'empleado.fxml'.";
        assert tbvGestionUsuarios != null : "fx:id=\"tbvGestionUsuarios\" was not injected: check your FXML file 'empleado.fxml'.";
        assert txtCantidadReservas != null : "fx:id=\"txtCantidadReservas\" was not injected: check your FXML file 'empleado.fxml'.";
        assert txtContrasenaUsuarios != null : "fx:id=\"txtContrasenaUsuarios\" was not injected: check your FXML file 'empleado.fxml'.";
        assert txtCorreoUsuario != null : "fx:id=\"txtCorreoUsuario\" was not injected: check your FXML file 'empleado.fxml'.";
        assert txtNombreReservas != null : "fx:id=\"txtNombreReservas\" was not injected: check your FXML file 'empleado.fxml'.";
        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'empleado.fxml'.";

    }

}
