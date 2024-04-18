package co.edu.uniquindio.parcial1fx.proyecto.ViewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial1fx.proyecto.Controller.UsuarioController;
import co.edu.uniquindio.parcial1fx.proyecto.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void removeUsuario(ActionEvent event) {

    }

    @FXML
    void updateUsuario(ActionEvent event) {

    @FXML
    void initialize() { // TODO: investigar como convertir datos a datos observables
        columNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        columCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());
        columSaldo.setCellValueFactory(cellData -> cellData.getValue().getSaldo());

        UsuarioController controller = new UsuarioController();

        ArrayList<Usuario> usuarios = controller.filtrarUsuario(radioBuscarCorrreo.isSelected(), textFiltro.getText());

        ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(usuarios);

    }
}
