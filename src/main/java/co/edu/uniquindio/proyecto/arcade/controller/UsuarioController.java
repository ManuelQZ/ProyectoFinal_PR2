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
        this.sincronizarData();
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
        int eliminable = -1;
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                usuarios.remove(usuarios.get(i));
                this.factory.getArcade().addUsuario(usuarios.get(i));
                eliminable = i;
            }
        }
        if (eliminable!= -1){
            this.listaUsuarioObservable.remove(eliminable);
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


    public void actualizarUsuario(String nombre, String correo, String clave, String saldo){
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        int actualizable = -1;
        Usuario usuarioTemporal = null;
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                usuarioTemporal = usuarios.get(i);
                usuarioTemporal.setNombre(nombre);
                usuarioTemporal.setClave(clave);
                usuarioTemporal.setSaldo(saldo);
                actualizable = i;
            }
        }
        if (actualizable!= -1 && usuarioTemporal != null){
            this.listaUsuarioObservable.remove(actualizable);
            this.factory.getArcade().rmUsuario(actualizable);
            this.factory.getArcade().addUsuario(usuarioTemporal);
            this.listaUsuarioObservable.add(usuarioTemporal);
        }
    }

    public ObservableList<Usuario> getListaUsuarioObservable() {
        return listaUsuarioObservable;
    }

    public void sincronizarData() {
        this.listaUsuarioObservable.addAll(this.factory.getArcade().getListaUsuario());
    }
}
