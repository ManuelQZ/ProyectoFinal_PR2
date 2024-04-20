package co.edu.uniquindio.parcial1fx.proyecto.ViewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial1fx.proyecto.Controller.UsuarioController;
import co.edu.uniquindio.parcial1fx.proyecto.Model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    UsuarioController usuarioController;

    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<Usuario, String> columCorreo;

    @FXML
    private TableColumn<Usuario, String> columNombre;

    @FXML
    private TableColumn<Usuario, String> columSaldo;

    @FXML
    private TableView<Usuario> tableViewUsuario;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtSaldo;

    @FXML
    private TextField txtnombre;

    @FXML
    private RadioButton radioBuscarCorrreo;

    @FXML
    private RadioButton radioBuscarNombre;

    @FXML
    private TextField textFiltro;

    @FXML
    void addUsuario(ActionEvent event) {

    }

    @FXML
    void filtrarUsuario(ActionEvent event) {
        obtenerUsuarios();
        tableViewUsuario.getItems().clear();
        tableViewUsuario.setItems(listaUsuarios);
    }

    @FXML
    void removeUsuario(ActionEvent event) {

    }

    @FXML
    void updateUsuario(ActionEvent event) {}

    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
        initView();
    }

    private void initView(){
        initDataBinding();
        obtenerUsuarios();
        tableViewUsuario.getItems().clear();
        tableViewUsuario.setItems(listaUsuarios);
    }

    private void initDataBinding(){
        columNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        columSaldo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaldo()));
    }

    private void obtenerUsuarios () {
        System.out.println("paso por huevo landia mamahuevo");
        listaUsuarios.addAll(usuarioController.obtenerUsuario());
    }

//    private void agregarUsuarios() {
//        if(validarFormulario()){
//            usuarioController = crearUsuario();
//            if(usuarioController.crearUsuario(Usuario);){
//                listaUsuarios.add(Usuario);
//                mostrarMensaje("Notificación cliente", "Cliente creado", "El cliente se ha creado con éxito", Alert.AlertType.INFORMATION);
//                limpiarCamposEmpleado();
//            }else{
//                mostrarMensaje("Notificación cliente", "Cliente no creado", "El cliente no se ha creado con éxito", Alert.AlertType.ERROR);
//            }
//        }else{
//            mostrarMensaje("Notificación cliente", "Cliente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
//        }
//
}


