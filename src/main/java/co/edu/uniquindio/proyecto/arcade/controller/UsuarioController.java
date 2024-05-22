package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.ModelFactory;
import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class UsuarioController {

    private ObservableList<Usuario> listaUsuarioObservable;
    private ModelFactory factory;
    private static UsuarioController instance;

    private UsuarioController() {
        this.factory = ModelFactory.getInstancia();
        this.listaUsuarioObservable = FXCollections.observableArrayList();
    }

    public static UsuarioController getInstance(){
        if(instance == null){
            return instance = new UsuarioController();
        }
        return instance;

    }
    public ArrayList<Usuario> filtrarUsuario(Boolean esCorreo, String busqueda) {
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        ArrayList<Usuario> usuariosFiltrado = new ArrayList<>();
        if (esCorreo) {
            for (Usuario usuario : usuarios) {
                if (Objects.equals(usuario.getCorreo(), busqueda)) {
                    usuariosFiltrado.add(usuario);
                }
            }
        }
        else {
            for (Usuario usuario : usuarios) {
                if (Objects.equals(usuario.getNombre(), busqueda)) {
                    usuariosFiltrado.add(usuario);
                }
            }
        }

        return usuariosFiltrado;
    }

    public ModelFactory getFactory() {
        return factory;
    }

    public ArrayList<Usuario> obtenerUsuario(){
        return factory.getArcade().getListaUsuario();
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

    public void sincronizarData() {
        this.listaUsuarioObservable.addAll(this.factory.getArcade().getListaUsuario());
    }
}
