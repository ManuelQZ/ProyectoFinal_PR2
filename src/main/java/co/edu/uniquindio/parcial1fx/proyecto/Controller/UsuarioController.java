package co.edu.uniquindio.parcial1fx.proyecto.Controller;

import co.edu.uniquindio.parcial1fx.proyecto.Factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.proyecto.Model.Usuario;

import java.util.ArrayList;
import java.util.Objects;

public class UsuarioController {

    private ModelFactory factory;

    public UsuarioController() {
        this.factory = ModelFactory.getInstancia();
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

    public ArrayList<Usuario> obtenerUsuario(){
        return factory.getArcade().getListaUsuario();
    }

    public Usuario crearUsuario(String nombre, String correo, String saldo){
        return factory.crearUsuario(nombre, correo, saldo);
    }

    public void eliminarUsuario(String correo){
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                usuarios.remove(usuarios.get(i));
            }
        }
    }

    public void actualiarUsuario(String nombre, String correo, String saldo){
        ArrayList<Usuario> usuarios = factory.getArcade().getListaUsuario();
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                Usuario nuevoUsuario = new Usuario(nombre, correo, saldo);
                usuarios.remove(usuarios.get(i));
                usuarios.add(nuevoUsuario);
            }
        }
    }
}
