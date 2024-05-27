package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmpleadoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> boxMetodoPago;

    @FXML
    private ComboBox<?> boxServicio;

    @FXML
    private DatePicker dateFechaReserva;

    @FXML
    private TableColumn<Usuario, String> tbcClaveCliente;

    @FXML
    private TableColumn<Usuario, String> tbcCorreoCliente;

    @FXML
    private TableColumn<Reserva, String> tbcCostoReserva;

    @FXML
    private TableColumn<Reserva, String> tbcEstadoReserva;

    @FXML
    private TableColumn<Reserva, String> tbcIdReserva;

    @FXML
    private TableColumn<Usuario, String> tbcNombreCliente;

    @FXML
    private TableColumn<Usuario, String> tbcSaldoCliente;

    @FXML
    private TableColumn<Reserva, String> tbcServicioReserva;

    @FXML
    private TableView<Reserva> tbvGestionReserva;

    @FXML
    private TableView<Usuario> tbvGestionUsuarios;

    @FXML
    private Label textCosto;

    @FXML
    private Label textMonto;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtContrasenaCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtSaldoCliente;

    @FXML
    void addReserva(ActionEvent event) {

    }

    @FXML
    void addUsuarios(ActionEvent event) {

    }

    @FXML
    void realizarPago(ActionEvent event) {

    }

    @FXML
    void removeUsuarios(ActionEvent event) {

    }

    @FXML
    void updateUsuarios(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
