package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.ReservaController;
import co.edu.uniquindio.proyecto.arcade.controller.ServicioController;
import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private ComboBox<String> boxServicio;

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
        Usuario usuario = usuarioController.consultarUsuario(txtCliente.getText());
        Date fecha = Date.from(dateFechaReserva.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Servicio servicio = reservaController.consultarReserva(boxServicio.getValue()).getServicio();
        String estado = boxMetodoPago.getValue().toString();

    }

    @FXML
    void addUsuarios(ActionEvent event) {
        String nombre = txtNombreCliente.getText();
        String correo = txtCorreoCliente.getText();
        String contrasena = txtContrasenaCliente.getText();
        String saldo = txtSaldoCliente.getText();

        if(!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty() && !saldo.isEmpty()) {

            String msj = usuarioController.crearUsuario(nombre, correo, contrasena, saldo);
            Tools.mostrarMensaje("Informacion", null, msj, Alert.AlertType.INFORMATION );
        } else {
            Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
        }

    }

    @FXML
    void realizarPago(ActionEvent event) {

    }


    @FXML
    void updateUsuarios(ActionEvent event) {
        String nombre = txtNombreCliente.getText();
        String correo = txtCorreoCliente.getText();
        String contrasena = txtContrasenaCliente.getText();
        String saldo = txtSaldoCliente.getText();

        if(!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty() && !saldo.isEmpty()) {
            usuarioController.actualizarUsuario(nombre, correo, contrasena);
        } else {
            Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void initialize() {
        boxServicio.getItems().addAll();
        initview();

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuarios.getItems().clear();
        tbvGestionReserva.getItems().clear();
        tbvGestionUsuarios.setItems(usuarioController.getListaUsuarioObservable());
        tbvGestionReserva.setItems(reservaController.getListaReservaObservable());
        listenerSelectionUsuario();
        listenerSelectionReserva();
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
            boxServicio.setValue(seleccionado.getServicio().getNombre());
            dateFechaReserva.setValue(Tools.convertToLocalDate(seleccionado.getFecha()));
        }
    }
}
