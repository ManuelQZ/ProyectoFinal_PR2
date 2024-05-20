package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class TrabajadorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tbcInformacionCliente;

    @FXML
    private TableColumn<?, ?> tbcInformacionReserva;

    @FXML
    private TableColumn<?, ?> tbcNombreCliente;

    @FXML
    private TableColumn<?, ?> tbcProducto;

    @FXML
    private Text tbv;

    @FXML
    private TableView<?> tbvListaClientes;

    @FXML
    private TableView<?> tbvListaReserva;

    @FXML
    void initialize() {
        assert tbcInformacionCliente != null : "fx:id=\"tbcInformacionCliente\" was not injected: check your FXML file 'Trabajador.fxml'.";
        assert tbcInformacionReserva != null : "fx:id=\"tbcInformacionReserva\" was not injected: check your FXML file 'Trabajador.fxml'.";
        assert tbcNombreCliente != null : "fx:id=\"tbcNombreCliente\" was not injected: check your FXML file 'Trabajador.fxml'.";
        assert tbcProducto != null : "fx:id=\"tbcProducto\" was not injected: check your FXML file 'Trabajador.fxml'.";
        assert tbv != null : "fx:id=\"tbv\" was not injected: check your FXML file 'Trabajador.fxml'.";
        assert tbvListaClientes != null : "fx:id=\"tbvListaClientes\" was not injected: check your FXML file 'Trabajador.fxml'.";
        assert tbvListaReserva != null : "fx:id=\"tbvListaReserva\" was not injected: check your FXML file 'Trabajador.fxml'.";

    }
}
