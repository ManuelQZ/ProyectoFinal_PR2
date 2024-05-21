package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.ModelFactory;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;

import java.util.ArrayList;
import java.util.Objects;

public class UsuarioController {

    private ModelFactory factory;
    private static UsuarioController instance;

    private UsuarioController() {
        this.factory = ModelFactory.getInstancia();
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
//
//    public Usuario crearUsuario(String nombre, String correo, String saldo){
//        return factory.crearUsuario(nombre, correo, saldo);
//    }

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

//    public void actualizarUsuario(String nombre, String correo, String saldo){
//        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
//        for (int i = 0; i < usuarios.size(); i++){
//            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
//                Usuario nuevoUsuario = new Usuario(nombre, correo, saldo);
//                usuarios.remove(usuarios.get(i));
//                usuarios.add(nuevoUsuario);
//            }
//        }
//    }
}
