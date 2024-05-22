package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.ModelFactory;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;

import java.util.ArrayList;
import java.util.Objects;

public class ServicioController {

    private ModelFactory factory;
    private static ServicioController instance;

    private ServicioController() {
        this.factory = ModelFactory.getInstancia();
    }

    public static ServicioController getInstance(){
        if(instance == null){
            return instance = new ServicioController();
        }
        return instance;

    }

    public ModelFactory getFactory() {
        return factory;
    }

    public void eliminarUsuario(String correo){
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                usuarios.remove(usuarios.get(i));
            }
        }
    }
    public  Usuario consultarUsuario(String correo, String clave){
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        for (Usuario value : usuarios) {
            if (value.getCorreo().equals(correo)){
                return value;
            }
        }
        return null;
    }

    public void actualizarUsuario(String nombre, String correo, String clave, String saldo, TipoUsuario tipoUsuario){
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                Usuario nuevoUsuario = new Usuario(nombre,  correo,  clave,  saldo, tipoUsuario);
                usuarios.remove(usuarios.get(i));
                usuarios.add(nuevoUsuario);
            }
        }
    }

}
