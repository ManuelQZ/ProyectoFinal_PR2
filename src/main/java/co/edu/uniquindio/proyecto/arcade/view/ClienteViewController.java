package co.edu.uniquindio.proyecto.arcade.view;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ClienteViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbInfo;

    @FXML
    private Label lbInfo1;

    @FXML
    private Label lbInfo11;

    @FXML
    private Label lbPrecio;

    @FXML
    private Label lbPrecio1;

    @FXML
    private Label lbPrecio11;

    @FXML
    private Tab tabComida;

    @FXML
    private Tab tabJuegos;

    @FXML
    private Tab tabProducto;

    @FXML
    private TableColumn<?, ?> tbcCategoria;

    @FXML
    private TableColumn<?, ?> tbcCategoria1;

    @FXML
    private TableColumn<?, ?> tbcCategoria11;

    @FXML
    private TableColumn<?, ?> tbcPrecioUnitario;

    @FXML
    private TableColumn<?, ?> tbcPrecioUnitario1;

    @FXML
    private TableColumn<?, ?> tbcPrecioUnitario11;

    @FXML
    private TableColumn<?, ?> tbcProducto;

    @FXML
    private TableColumn<?, ?> tbcProducto1;

    @FXML
    private TableColumn<?, ?> tbcProducto11;

    @FXML
    private TableView<?> tbvComida;

    @FXML
    private TableView<?> tbvJuegos;

    @FXML
    private TableView<?> tbvProducto;

    @FXML
    private TextField txfCantidadComida;

    @FXML
    private TextField txfCantidadJuegos;

    @FXML
    private TextField txfCantidadProducto;

    @FXML
    void pedir(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert lbInfo != null : "fx:id=\"lbInfo\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbInfo1 != null : "fx:id=\"lbInfo1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbInfo11 != null : "fx:id=\"lbInfo11\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbPrecio != null : "fx:id=\"lbPrecio\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbPrecio1 != null : "fx:id=\"lbPrecio1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbPrecio11 != null : "fx:id=\"lbPrecio11\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tabComida != null : "fx:id=\"tabComida\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tabJuegos != null : "fx:id=\"tabJuegos\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tabProducto != null : "fx:id=\"tabProducto\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcCategoria != null : "fx:id=\"tbcCategoria\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcCategoria1 != null : "fx:id=\"tbcCategoria1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcCategoria11 != null : "fx:id=\"tbcCategoria11\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcPrecioUnitario != null : "fx:id=\"tbcPrecioUnitario\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcPrecioUnitario1 != null : "fx:id=\"tbcPrecioUnitario1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcPrecioUnitario11 != null : "fx:id=\"tbcPrecioUnitario11\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcProducto != null : "fx:id=\"tbcProducto\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcProducto1 != null : "fx:id=\"tbcProducto1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbcProducto11 != null : "fx:id=\"tbcProducto11\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbvComida != null : "fx:id=\"tbvComida\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbvJuegos != null : "fx:id=\"tbvJuegos\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbvProducto != null : "fx:id=\"tbvProducto\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txfCantidadComida != null : "fx:id=\"txfCantidadComida\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txfCantidadJuegos != null : "fx:id=\"txfCantidadJuegos\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txfCantidadProducto != null : "fx:id=\"txfCantidadProducto\" was not injected: check your FXML file 'cliente.fxml'.";

    }
}