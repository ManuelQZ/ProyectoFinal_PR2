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

    Usuario usuarioProcesado;


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
        System.out.println(validarFormulario());

        if(validarFormulario()){
            Usuario newUsuario = usuarioController.crearUsuario(txtnombre.getText(), txtCorreo.getText(), txtSaldo.getText());
            boolean existe = false;
            for (int i = 0; i < listaUsuarios.size(); i++) {
                Usuario usuario = listaUsuarios.get(i);
                if (usuario.getCorreo().equals(newUsuario.getCorreo())){
                    existe = true;
                }
            }

            if(!existe){
                listaUsuarios.add(newUsuario);
                mostrarMensaje("Notificación cliente", "Cliente creado", "El cliente se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else{
                mostrarMensaje("Notificación cliente", "Cliente no creado", "El usuario especificado ya existe", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación cliente", "Cliente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String title, String header, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void limpiarCampos(){
        txtnombre.setText("");
        txtCorreo.setText("");
        txtSaldo.setText("");
    }

    @FXML
    void filtrarUsuario(ActionEvent event) {
        obtenerUsuarios();
        tableViewUsuario.getItems().clear();
        tableViewUsuario.setItems(listaUsuarios);
    }

    @FXML
    void removeUsuario(ActionEvent event) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getCorreo().equals(txtCorreo.getText())){
                listaUsuarios.remove(usuario);
                mostrarMensaje("Notificación cliente", "Cliente eliminado", "El cliente se ha eliminado con éxito", Alert.AlertType.INFORMATION);
            }
        }
        limpiarCampos();

    }

    @FXML
    void updateUsuario(ActionEvent event) {
        Usuario usuario = usuarioController.crearUsuario(txtnombre.getText(), txtCorreo.getText(), txtSaldo.getText());
        listaUsuarios.add(usuario);
        listaUsuarios.remove(usuarioProcesado);
        mostrarMensaje("Notificación cliente", "Cliente actualizado", "El cliente se ha actualizado con éxito", Alert.AlertType.INFORMATION);
        limpiarCampos();
    }

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
        listenerSelection();
    }

    private void listenerSelection() {
        tableViewUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            mostrarInformacionUsuario(newSelection);
            usuarioProcesado = newSelection;
        });
    }

    private void mostrarInformacionUsuario(Usuario seleccionado) {
        if(seleccionado != null){
            txtnombre.setText(seleccionado.getNombre());
            txtCorreo.setText(seleccionado.getCorreo());
            txtSaldo.setText(seleccionado.getSaldo());
        }
    }

    private void initDataBinding(){
        columNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        columSaldo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaldo()));
    }

    private boolean validarFormulario(){
        boolean cond = txtnombre.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtSaldo.getText().isEmpty();
        if (cond){
            return false;
        } else {
            return  true;
        }
    }

    private void obtenerUsuarios () {
        listaUsuarios.addAll(usuarioController.obtenerUsuario());
    }
}


