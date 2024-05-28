package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.ReservaController;
import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;

import co.edu.uniquindio.proyecto.arcade.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmpleadoViewController {

    UsuarioController usuarioController = UsuarioController.getInstance();
    ReservaController reservaController = ReservaController.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Pago> boxMetodoPago;

    @FXML
    private ComboBox<Servicio> boxServicio;

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

        initview();

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuarios.getItems().clear();
        tbvGestionReserva.getItems().clear();
        tbvGestionUsuarios.setItems(usuarioController.getListaUsuarioObservable());
        tbvGestionReserva.setItems(reservaController.getListaReservaObservable());
        listenerSelectionUsuario();
    }

    private void initDataBinding() {
        // lista de cliente
        tbcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCorreoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbcClaveCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClave()));
        tbcSaldoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaldo()));

        // lista de reserva
        tbcIdReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcServicioReserva.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getServicio().getNombre())));
        tbcEstadoReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));
        tbcCostoReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getServicio().getPrecio()));

    }

    private void listenerSelectionUsuario() {
        tbvGestionUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionUsuario((Usuario) newSelection);
        });
    }

    private void mostrarInformacionUsuario(Usuario seleccionado) {
        if(seleccionado != null){
            txtNombreCliente.setText(seleccionado.getNombre());
            txtCorreoCliente.setText(String.valueOf(seleccionado.getCorreo()));
            txtContrasenaCliente.setText(seleccionado.getClave());
            txtSaldoCliente.setText(seleccionado.getSaldo());
        }
    }
    private void listenerSelectionReserva() {
        tbvGestionReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionReserva((Reserva) newSelection);
        });
    }
    private void mostrarInformacionReserva(Reserva seleccionado) {
        if (seleccionado != null) {
            txtCliente.setText(seleccionado.getUsuario().getNombre());
            boxServicio.setValue(seleccionado.getServicio());
            dateFechaReserva.setValue(LocalDate.parse(seleccionado.getFecha().toString()));
        }
    }
}
