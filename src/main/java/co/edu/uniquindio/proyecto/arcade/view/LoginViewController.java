package co.edu.uniquindio.proyecto.arcade.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto.arcade.controller.UsuarioController;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import co.edu.uniquindio.proyecto.arcade.model.proxy.UsuarioProxy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {

    UsuarioController usuarioController = UsuarioController.getInstance();
    private String sesion;
    UsuarioProxy usuarioTemporal = usuarioController.getMediator().getArcade().getUsuarioTemporal();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    void crearUsuario(ActionEvent event) {

    }

    @FXML
    void ingresar(ActionEvent event) {

        Usuario usuario = usuarioController.consultarUsuario(txtCorreo.getText());
        usuarioTemporal.setUsuario(usuario);
        sesion = usuarioTemporal.acceder();

        if(!sesion.equals("error")){
            seleccionarInterfaz(sesion);
            Tools.cerrarVentana(txtCorreo);
        }else {
            Tools.mostrarMensaje("Error", "No se pudo acceder", "Ocurrio un error intentelo nuevamente", Alert.AlertType.ERROR);
        }
    }


    public void seleccionarInterfaz(String interfaz){
        switch (interfaz){
            case "cliente":
                Tools.ventanaEmergente("cliente.fxml", "cliente", "Estilos/login.css");
                break;

            case "empleado":
                Tools.ventanaEmergente("empleado.fxml", "empleado", "Estilos/empleado.css");
                break;
            case "administrador":
                Tools.ventanaEmergente("administrador.fxml", "administrador", "Estilos/administrador.css");
                break;
        }
    }

    @FXML
    void initialize() {
        assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'login.fxml'.";

    }

}