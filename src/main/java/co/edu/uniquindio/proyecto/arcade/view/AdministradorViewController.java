package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.ProductoController;
import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdministradorViewController {

    UsuarioController usuarioController = UsuarioController.getInstance();
    ProductoController productoController = ProductoController.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

//Tablas:
    @FXML
    private TableView<Producto> tbvGestionProducto;

    @FXML
    private TableColumn<Producto, String> tbcCantidadProducto;

    @FXML
    private TableColumn<Producto, String> tbcNombreProducto;

    @FXML
    private TableView<Usuario> tbvGestionUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcCorreoUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcNombreUsuario;

    @FXML
    private TableColumn<Usuario, String> tbcTipoUsuario;

    @FXML
    private TableView<Reserva> tbvGestionReserva;


    @FXML
    private TableColumn<?, ?> tbcNombreReserva;

    @FXML
    private TableColumn<Reserva, String> tbcFechaReserva;

    @FXML
    private TableColumn<Producto, String> tbcPrecio;

    @FXML
    private TableColumn<Usuario, String> tbcSaldo;


    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtFechaReserva;
    
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

    }

    @FXML
    void removeUsuario(ActionEvent event) {
        usuarioController.eliminarUsuario(txtUsuario.getText());
    }

    @FXML
    void addReserva(ActionEvent event) {

    }

    @FXML
    void updateReserva(ActionEvent event) {

    }

    @FXML
    void removeReserva(ActionEvent event) {

    }

    @FXML
    void initialize() {
//        initview();

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuario.getItems().clear();
        tbvGestionProducto.getItems().clear();
        tbvGestionUsuario.setItems(usuarioController.getListaUsuarioObservable());
        tbvGestionProducto.setItems(productoController.getListaProductoObservable());
        listenerSelectionProducto();
        listenerSelectionUsuario();
    }

    private void initDataBinding(){
        tbcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCorreoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbcSaldo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaldo()));
        tbcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        tbcCantidadProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadDisponible()));
    }

    private void listenerSelectionProducto() {
        tbvGestionProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionProducto((Producto) newSelection);
        });
    }

    private void listenerSelectionUsuario() {
        tbvGestionUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionUsuario((Usuario) newSelection);
        });
    }

    private void mostrarInformacionProducto(Producto seleccionado) {
        if(seleccionado != null){
            txtProducto.setText(seleccionado.getNombre());
            txtPrecio.setText(String.valueOf(seleccionado.getPrecio()));
            txtCantidad.setText(seleccionado.getCantidadDisponible());
        }
    }

    private void mostrarInformacionUsuario(Usuario seleccionado) {
        if(seleccionado != null){
            txtUsuario.setText(seleccionado.getNombre());
            txtCorreo.setText(String.valueOf(seleccionado.getCorreo()));
            txtContrasena.setText(seleccionado.getClave());
        }
    }
}
