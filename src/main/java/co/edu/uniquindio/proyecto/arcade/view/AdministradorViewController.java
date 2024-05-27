package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.ProductoController;
import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;
import co.edu.uniquindio.proyecto.arcade.controller.ReservaController;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdministradorViewController {

    UsuarioController usuarioController = UsuarioController.getInstance();
    ProductoController productoController = ProductoController.getInstance();
    ReservaController reservaController = ReservaController.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Producto> tbvGestionProducto;

    @FXML
    private TableColumn<Producto, String> tbcCantidadProducto;

    @FXML
    private TableColumn<Producto, String> tbcNombreProducto;

    @FXML
    private TableColumn<Producto, String> tbcPrecio;

    @FXML
    private TableView<Usuario> tbvGestionUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcCorreoUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcNombreUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcTipoUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcSaldo;

    @FXML
    private TableView<Reserva> tbvGestionReserva;

    @FXML
    private TableColumn<Reserva, String> tbcNombreReserva;

    @FXML
    private TableColumn<Reserva, String> tbcFechaReserva;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private DatePicker dateFechaReserva;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreReserva;

    @FXML
    private TextField txtTIpoUsuario;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtProducto;

    @FXML
    private TextField txtSaldo;

    @FXML
    void addProducto(ActionEvent event) {
        productoController.actualizarProducto(txtProducto.getText(), txtPrecio.getText(), txtCantidad.getText());
    }

    @FXML
    void updateProducto(ActionEvent event) {
        // Aquí puedes agregar la lógica para actualizar el producto si es necesario
    }

    @FXML
    void removeProducto(ActionEvent event) {
        productoController.eliminarProducto(txtProducto.getText());
    }

    @FXML
    void addUsuario(ActionEvent event) {
        usuarioController.actualizarUsuario(txtUsuario.getText(), txtCorreo.getText(), txtContrasena.getText(), txtSaldo.getText());
    }

    @FXML
    void updateUsuario(ActionEvent event) {
        // Aquí puedes agregar la lógica para actualizar el usuario si es necesario
    }

    @FXML
    void removeUsuario(ActionEvent event) {
        usuarioController.eliminarUsuario(txtUsuario.getText());
    }

    @FXML
    void addReserva(ActionEvent event) {
        // Aquí puedes agregar la lógica para agregar reservas si es necesario
    }

    @FXML
    void updateReserva(ActionEvent event) {
        // Aquí puedes agregar la lógica para actualizar reservas si es necesario
    }

    @FXML
    void removeReserva(ActionEvent event) {
        reservaController.eliminarReserva(txtNombreReserva.getText());
    }

    @FXML
    void initialize() {

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuario.getItems().clear();
        tbvGestionReserva.getItems().clear();
        tbvGestionUsuario.setItems(usuarioController.getListaUsuarioObservable());
        tbvGestionReserva.setItems(reservaController.getListaReservaObservable());
        listenerSelectionUsuario();
    }

    private void initDataBinding() {
        // lista de usuarios
        tbcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCorreoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbcTipoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoUsuario()));

        // lista de reserva
        tbcNombreReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFecha())));

        // lista de productos
        tbcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCantidadProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadDisponible()));
    }

    private void listenerSelectionUsuario() {
        tbvGestionUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionUsuario((Usuario) newSelection);
        });
    }

    private void mostrarInformacionUsuario(Usuario seleccionado) {
        if(seleccionado != null){
            txtNombre.setText(seleccionado.getNombre());
            txtCorreo.setText(String.valueOf(seleccionado.getCorreo()));
            txtContrasena.setText(seleccionado.getClave());
            txtSaldo.setText(seleccionado.getSaldo());
        }
    }



    private void mostrarInformacionProducto(Producto seleccionado) {
        if (seleccionado != null) {
            txtProducto.setText(seleccionado.getNombre());
            txtPrecio.setText(seleccionado.getPrecio());
            txtCantidad.setText(seleccionado.getCantidadDisponible());
        }
    }

    private void listenerSelectionReserva() {
        tbvGestionReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionReserva((Reserva) newSelection);
        });
    }

    private void mostrarInformacionReserva(Reserva seleccionado) {
        if (seleccionado != null) {
            txtNombreReserva.setText(seleccionado.getId());
            dateFechaReserva.setValue(LocalDate.parse(seleccionado.getFecha().toString()));
        }
    }
}
