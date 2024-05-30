package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentLinkedDeque;

import co.edu.uniquindio.proyecto.arcade.controller.ProductoController;
import co.edu.uniquindio.proyecto.arcade.controller.ReservaController;
import co.edu.uniquindio.proyecto.arcade.controller.ServicioController;
import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.bridge.EnvioCorreo;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoStrategy;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EmpleadoViewController {

    UsuarioController usuarioController = UsuarioController.getInstance();
    ReservaController reservaController = ReservaController.getInstance();
    ServicioController servicioController = ServicioController.getInstance();
    ProductoController productoController = ProductoController.getInstance();
    PagoStrategy pagoStrategy;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxMetodoPago;

    @FXML
    private ComboBox<String> boxServicio;

    @FXML
    private DatePicker dateFechaReserva;

    @FXML
    private ToggleGroup objetoDePago;

    @FXML
    private TableColumn<Producto, String> tbcCantidadProductos;

    @FXML
    private TableColumn<Usuario, String> tbcClaveCliente;

    @FXML
    private TableColumn<Usuario, String> tbcCorreoCliente;

    @FXML
    private TableView<Usuario> tbvCorreoElectronico;

    @FXML
    private TableColumn<Reserva, String> tbcCostoReserva;

    @FXML
    private TableColumn<Reserva, String> tbcEstadoReserva;

    @FXML
    private TableColumn<Reserva, String> tbcIdReserva;

    @FXML
    private TableColumn<Usuario, String> tbcNombreCliente;

    @FXML
    private TableColumn<Producto, String> tbcNombreProducto;

    @FXML
    private TableColumn<Producto, String> tbcPrecioProducto;

    @FXML
    private TableColumn<Usuario, String> tbcSaldoCliente;

    @FXML
    private TableColumn<Usuario, String> tbcCorreoElectronico;

    @FXML
    private TableColumn<Reserva, String> tbcServicioReserva;

    @FXML
    private TableView<Producto> tbvGestionProductos;

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
    private TextField txtCorreoInvisible;

    @FXML
    private TextField txtContrasenaCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextArea txtDesCorreo;

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
        Servicio servicio = servicioController.consultarServicio(boxServicio.getValue());

        if (usuario != null && !servicio.getNombre().isEmpty()) {
            reservaController.agregarReserva(usuario, fecha, servicio, "No pago");
        }

    }

    @FXML
    void addUsuarios(ActionEvent event) {
        String nombre = txtNombreCliente.getText();
        String correo = txtCorreoCliente.getText();
        String contrasena = txtContrasenaCliente.getText();
        String saldo = txtSaldoCliente.getText();

        if (!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty() && !saldo.isEmpty()) {

            String msj = usuarioController.crearUsuarioCliente(nombre, correo, contrasena, saldo);
            Tools.mostrarMensaje("Informacion", null, msj, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void enviarCorreo(ActionEvent event) {
        if(txtDesCorreo.getText().isEmpty()) {
            Tools.mostrarMensaje("Error", null, "El campo de texto esta vacio", Alert.AlertType.ERROR);
        } else{
            new EnvioCorreo().enviarNotificacion(txtCorreoInvisible.getText(), txtDesCorreo.getText());
            Tools.mostrarMensaje("Confirmación", null, "Se envío el correo correctamente", Alert.AlertType.CONFIRMATION);
        }
    }

    @FXML
    void realizarPago(ActionEvent event) {
    }

    @FXML
    void initialize() {
        boxServicio.getItems().addAll(servicioController.getListaNombreServicio());
        String[] metodosPago = {"Efectivo", "Paypal", "Tarjeta"};
        boxMetodoPago.getItems().addAll(metodosPago);
        initview();

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuarios.getItems().clear();
        tbvGestionReserva.getItems().clear();
        tbvGestionProductos.getItems().clear();
        tbvCorreoElectronico.getItems().clear();
        tbvGestionUsuarios.setItems(usuarioController.getListaUsuarioClienteObservable());
        tbvGestionReserva.setItems(reservaController.getListaReservaObservable());
        tbvGestionProductos.setItems(productoController.getListaProductoObservable());
        tbvCorreoElectronico.setItems(usuarioController.getListaUsuarioClienteObservable());
        listenerSelectionUsuario();
        listenerSelectionReserva();
        listenerSelectionCorreo();

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

        // lista de productos

        tbcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcPrecioProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrecio()));
        tbcCantidadProductos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadDisponible()));

        // lista de correos

        tbcCorreoElectronico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
    }

    private void listenerSelectionUsuario() {
        tbvGestionUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionUsuario((Usuario) newSelection);
        });
    }

    private void mostrarInformacionUsuario(Usuario seleccionado) {
        if (seleccionado != null) {
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

    private void listenerSelectionCorreo(){
        tbvCorreoElectronico.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            this.mostrarInformacionCorreo((Usuario) newSelection);
        });
    }

    private void mostrarInformacionCorreo(Usuario seleccionado){
        if (seleccionado != null) {
            txtCorreoInvisible.setText(String.valueOf(seleccionado.getCorreo()));
        }
    }
}

