package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.ProductoController;
import co.edu.uniquindio.proyecto.arcade.controller.ServicioController;
import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;
import co.edu.uniquindio.proyecto.arcade.controller.ReservaController;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdministradorViewController {

    UsuarioController usuarioController = UsuarioController.getInstance();
    ServicioController servicioController = ServicioController.getInstance();
    ProductoController productoController = ProductoController.getInstance();
    ReservaController reservaController = ReservaController.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Usuario, String> tbcTipoUsuario;

    @FXML
    private TableView<Usuario> tbvGestionUsuario;

    @FXML
    private TableView<Servicio> tbvGestionServicio;

    @FXML
    private TableView<Reserva> tbvGestionReserva;

    @FXML
    private TableColumn<Servicio, String> tbcDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtPrecioServicio;

    @FXML
    private ComboBox<String> comboModalidad;

    @FXML
    private TableColumn<Servicio, String> tbcNombreServicio;

    @FXML
    private TableColumn<Usuario, String> tbcNombreUsuario;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TableColumn<Reserva, String> tbcId;

    @FXML
    private TableColumn<Servicio, String> tbcPrecioServicio;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtProducto;

    @FXML
    private TableColumn<Servicio, String> tbcDisponibilidadReserva;

    @FXML
    private TextField txtUsuarioReserva;

     @FXML
    private ComboBox<String> comboServicio;

    @FXML
    private TableView<Producto> tbvGestionProducto;

    @FXML
    private TextField txtEstadoReserva;

    @FXML
    private TableColumn<Producto, String> tbcNombreProducto;

    @FXML
    private TableColumn<Usuario, String> tbcCorreoUsuario;

    @FXML
    private TableColumn<Reserva, String> tbcFecha;

    @FXML
    private TableColumn<Producto, String> tbcPrecio;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtTIpoUsuario;

    @FXML
    private TextField txtId;

    @FXML
    private TableColumn<Reserva, String> tbcServicio;

    @FXML
    private TableColumn<Reserva, String> tbcCosto;

    @FXML
    private TableColumn<Servicio, String> tbcModalidad;

    @FXML
    private DatePicker dateFechaReserva;

    @FXML
    private TableColumn<Producto, String> tbcCantidadProducto;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtServicio;

    @FXML
    private TextField txtDisponibilidadServicio;

    @FXML
    private TableColumn<Reserva, String> tbcEstado;

    @FXML
    void removeUsuario(ActionEvent event) {
        String correo = txtCorreo.getText();

        if (!correo.isEmpty()) {
            usuarioController.eliminarUsuario(correo);
            Tools.mostrarMensaje("Informacion", null, "Usuario eliminado exitosamente", Alert.AlertType.INFORMATION );
        } else {
            Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void addUsuario(ActionEvent event) {
        String nombre = txtUsuario.getText();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = txtTIpoUsuario.getText();
        
        if(!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty()) {

            String msj = usuarioController.crearUsuario(nombre, correo, contrasena, tipoUsuario);
            Tools.mostrarMensaje("Informacion", null, msj, Alert.AlertType.INFORMATION );
        } else {
            Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void updateUsuario(ActionEvent event) {
        String nombre = txtUsuario.getText();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = txtTIpoUsuario.getText();

        if (tipoUsuario.isEmpty()) {
            if(!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty()) {
                usuarioController.actualizarUsuario(nombre, correo, contrasena);
            } else {
            Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
        }
        } else {
            Tools.mostrarMensaje("Error", null, "No se puede modificar el tipo de usuario", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void addReserva(ActionEvent event) {
        Usuario usuario = usuarioController.consultarUsuario(txtUsuarioReserva.getText());
        Date fecha = Date.from(dateFechaReserva.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Servicio servicio = servicioController.consultarServicio(comboServicio.getValue());
        String estado = txtEstadoReserva.getText();

        if (usuario != null && servicio != null && !estado.isEmpty()) {
            reservaController.agregarReserva(usuario, fecha, servicio, estado);
        }

    }

    @FXML
    void updateReserva(ActionEvent event) {
        Usuario usuario = usuarioController.consultarUsuario(txtUsuarioReserva.getText());
        Date fecha = Date.from(dateFechaReserva.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Servicio servicio = servicioController.consultarServicio(comboServicio.getValue());
        String estado = txtEstadoReserva.getText();
        String id = txtId.getText();

        if (usuario != null && servicio != null && !estado.isEmpty()) {
            reservaController.actualizarReserva(usuario, fecha, servicio, estado, id);
        }
    }

    @FXML
    void removeReserva(ActionEvent event) {
        
        reservaController.eliminarReserva();
    }

    @FXML
    void addServicio(ActionEvent event) {

    }

    @FXML
    void updateServicio(ActionEvent event) {

    }

    @FXML
    void removeServicio(ActionEvent event) {

    }

    @FXML
    void addProducto(ActionEvent event) {

    }

    @FXML
    void removeProducto(ActionEvent event) {

    }

    @FXML
    void updateProducto(ActionEvent event) {

    }


    @FXML
    void initialize() {
        comboModalidad.getItems().addAll(Arrays.toString(Modalidad.values()).replace("[", "").replace("]", "").split(", "));
        initview();

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuario.getItems().clear();
        tbvGestionServicio.getItems().clear();
        tbvGestionReserva.getItems().clear();
        tbvGestionProducto.getItems().clear();
        tbvGestionUsuario.setItems(usuarioController.getListaUsuarioObservable());
        tbvGestionServicio.setItems(servicioController.getListaServicioObservable());
        tbvGestionReserva.setItems(reservaController.getListaReservaObservable());
        tbvGestionProducto.setItems(productoController.getListaProductoObservable());
        listenerSelectionUsuario();
        listenerSelectionServicio();
        listenerSelectionReserva();
        listenerSelectionProducto();

    }

    private void initDataBinding() {
        // lista de usuarios
        tbcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCorreoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbcTipoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoUsuario()));

        // lista de reserva
        tbcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcServicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getServicio().getNombre()));
        tbcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        tbcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));
        tbcCosto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getServicio().getPrecio()));

        // lista de servicios
        tbcNombreServicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tbcModalidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModalidad().toString()));
        tbcPrecioServicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrecio()));
        tbcDisponibilidadReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDisponibilidadReserva()));

        // lista de productos
        tbcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCantidadProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadDisponible()));
        tbcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrecio()));
    }

    private void listenerSelectionUsuario() {
        tbvGestionUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionUsuario((Usuario) newSelection);
        });
    }

    private void mostrarInformacionUsuario(Usuario seleccionado) {
        if(seleccionado != null){
            txtUsuario.setText(seleccionado.getNombre());
            txtCorreo.setText(String.valueOf(seleccionado.getCorreo()));
            txtContrasena.setText(seleccionado.getClave());
            txtTIpoUsuario.setText(seleccionado.getTipoUsuario());

        }
    }

    private void listenerSelectionReserva() {
        tbvGestionReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionReserva((Reserva) newSelection);
        });
    }

    private void mostrarInformacionReserva(Reserva seleccionado) {
        if (seleccionado != null) {
            dateFechaReserva.setValue(Tools.convertToLocalDate(seleccionado.getFecha()));
            txtEstadoReserva.setText(seleccionado.getEstado());
        }
    }

    private void listenerSelectionServicio() {
        tbvGestionServicio.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionServicio((Servicio) newSelection);
        });
    }

    private void mostrarInformacionServicio(Servicio seleccionado) {
        if (seleccionado != null) {
            txtServicio.setText(seleccionado.getNombre());
            txtDescripcion.setText(seleccionado.getDescripcion());
            comboModalidad.setValue(seleccionado.getModalidad().toString());
            txtPrecioServicio.setText(seleccionado.getPrecio());
            txtDisponibilidadServicio.setText(seleccionado.getDisponibilidadReserva());
        }
    }

    private void listenerSelectionProducto() {
        tbvGestionProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionProducto((Producto) newSelection);
        });
    }



    private void mostrarInformacionProducto(Producto seleccionado) {
        if (seleccionado != null) {
            txtProducto.setText(seleccionado.getNombre());
            txtCantidad.setText(seleccionado.getCantidadDisponible());
            txtPrecio.setText(seleccionado.getPrecio());
        }
    }


}
