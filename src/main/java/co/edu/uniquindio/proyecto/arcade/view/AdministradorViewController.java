package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.*;
import co.edu.uniquindio.proyecto.arcade.model.*;
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

    PagoController pagoController = PagoController.getInstance();


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
    private TableView<Pago> tbvPagos;

    @FXML
    private TableColumn<Pago, String> tbcMontoPago;

    @FXML
    private TableColumn<Pago, String> tbcMetodoPago;

    @FXML
    private TableColumn<Pago, String> tbcFechaPago;

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
    void limpiarCampos(ActionEvent event) {
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtServicio.setText("");
        txtUsuario.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
        txtTIpoUsuario.setText("");
        txtProducto.setText("");
        txtPrecioServicio.setText("");
        txtDisponibilidadServicio.setText("");
        txtUsuarioReserva.setText("");
        txtEstadoReserva.setText("");
        txtDescripcion.setText("");

        txtId.setDisable(false);
        txtCorreo.setDisable(false);
        txtContrasena.setDisable(false);
        txtTIpoUsuario.setDisable(false);
        txtProducto.setDisable(false);
        txtPrecioServicio.setDisable(false);
        txtDisponibilidadServicio.setDisable(false);
        txtUsuarioReserva.setDisable(false);
        txtCantidad.setDisable(false);
        txtPrecio.setDisable(false);
        txtServicio.setDisable(false);
        txtUsuario.setDisable(false);
        txtCorreo.setDisable(false);
        txtContrasena.setDisable(false);
        txtTIpoUsuario.setDisable(false);
        txtProducto.setDisable(false);
        txtPrecioServicio.setDisable(false);
        txtDisponibilidadServicio.setDisable(false);
        txtUsuarioReserva.setDisable(false);
        txtEstadoReserva.setDisable(false);
        txtDescripcion.setDisable(false);
    }

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
        Usuario usuario = usuarioController.consultarUsuario(correo);
        if (usuario != null) {
            String tipoUsuarioOriginal = usuario.getTipoUsuario();
            if (tipoUsuario.equals(tipoUsuarioOriginal)) {
                if(!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty()) {
                    usuarioController.actualizarUsuario(nombre, correo, contrasena);
                } else {
                    Tools.mostrarMensaje("Error", null, "Los campos están vacíos", Alert.AlertType.ERROR);
                }
            } else {
                Tools.mostrarMensaje("Error", null, "No se puede modificar el tipo de usuario", Alert.AlertType.ERROR);
            }
        }else{
            Tools.mostrarMensaje("Error", null, "El usuario no existe", Alert.AlertType.ERROR);
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

        if (usuario != null) {
            if(!estado.isEmpty()){
                reservaController.actualizarReserva(usuario, fecha, servicio, estado, id);
            }else{
                Tools.mostrarMensaje("Error", null, "El campo estado está vacío", Alert.AlertType.ERROR);
            }
        }else {
            Tools.mostrarMensaje("Error", null, "El usuario no existe", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void removeReserva(ActionEvent event) {
        String id = txtId.getText();

        if (!id.isEmpty()) {
            reservaController.eliminarReserva(id);
            Tools.mostrarMensaje("Informacion", null, "Reserva eliminada exitosamente", Alert.AlertType.INFORMATION );
        } else {
            Tools.mostrarMensaje("Error", null, "No se selecciono una reserva eliminable", Alert.AlertType.ERROR);
        }
    }


    @FXML
    void addServicio(ActionEvent event) {
        String nombre = txtServicio.getText();
        String descripcion = txtDescripcion.getText();
        String disponibilidad = txtDisponibilidadServicio.getText();
        Modalidad modalidad = Modalidad.getModalidad(comboModalidad.getValue());
        String precio = txtPrecioServicio.getText();

        if (!nombre.isEmpty() && !descripcion.isEmpty() && !disponibilidad.isEmpty() && !precio.isEmpty() && modalidad != null) {

            servicioController.crearServicio(nombre, descripcion, modalidad, precio, disponibilidad);
            }
    }

    @FXML
    void updateServicio(ActionEvent event) {
        String nombre = txtServicio.getText();
        String descripcion = txtDescripcion.getText();
        String disponibilidad = txtDisponibilidadServicio.getText();
        String precio = txtPrecioServicio.getText();
        Modalidad modalidad = Modalidad.getModalidad(comboModalidad.getValue());

        if(!nombre.isEmpty() && !descripcion.isEmpty() && !disponibilidad.isEmpty() && !precio.isEmpty() && modalidad != null){
            servicioController.actualizarServicio(nombre, descripcion, modalidad, precio, disponibilidad);
        }else{
                Tools.mostrarMensaje("Error", null, "El campo estado está vacío", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void removeServicio(ActionEvent event) {
        String nombre = txtServicio.getText();

        if (!nombre.isEmpty()) {
            servicioController.eliminarServicio(nombre);
            Tools.mostrarMensaje("Informacion", null, "Servicio eliminado exitosamente", Alert.AlertType.INFORMATION );
        } else {
            Tools.mostrarMensaje("Error", null, "No se selecciono un servicio eliminable", Alert.AlertType.ERROR);
        }
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
        comboServicio.getItems().addAll(servicioController.getListaNombreServicio());
        initview();

    }

    private void initview() {
        initDataBinding();
        tbvGestionUsuario.getItems().clear();
        tbvGestionServicio.getItems().clear();
        tbvGestionReserva.getItems().clear();
        tbvGestionProducto.getItems().clear();
        tbvPagos.getItems().clear();
        tbvGestionUsuario.setItems(usuarioController.getListaUsuarioObservable());
        tbvGestionServicio.setItems(servicioController.getListaServicioObservable());
        tbvGestionReserva.setItems(reservaController.getListaReservaObservable());
        tbvGestionProducto.setItems(productoController.getListaProductoObservable());
        tbvPagos.setItems(pagoController.getListaPagosObservable());
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

        // Lista de pagos
        tbcMetodoPago.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMetodoPago()));
        tbcMontoPago.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMonto()));
        tbcFechaPago.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
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
            txtCorreo.setDisable(true);
            txtContrasena.setText(seleccionado.getClave());
            txtTIpoUsuario.setText(seleccionado.getTipoUsuario());
            txtTIpoUsuario.setDisable(true);

        }
    }

    private void listenerSelectionReserva() {
        tbvGestionReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionReserva((Reserva) newSelection);
        });
    }

    private void mostrarInformacionReserva(Reserva seleccionado) {
        if (seleccionado != null) {
            txtUsuarioReserva.setText(seleccionado.getUsuario().getCorreo());
            comboServicio.setValue(seleccionado.getServicio().getNombre());
            dateFechaReserva.setValue(Tools.convertToLocalDate(seleccionado.getFecha()));
            txtEstadoReserva.setText(seleccionado.getEstado());
            txtId.setText(seleccionado.getId());
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
            txtServicio.setDisable(true);
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

//    //Pago
//    private void listenerSelectionPago() {
//        tbvGestionProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            this.mostrarInformacionPago((Pago) newSelection);
//        });
//    }
//
//
//
//    private void mostrarInformacionPago(Pago seleccionado) {
//        if (seleccionado != null) {
//            txtProducto.setText(seleccionado.getMetodoPago());
//            txtCantidad.setText(seleccionado.getMonto());
//            txtPrecio.setText(seleccionado.getFecha().toString());
//        }
//    }
}
