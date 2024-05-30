package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarClienteCommand;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarEmpleadoCommand;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class UsuarioController {

    private ObservableList<Usuario> listaUsuarioObservable;
    private final Mediator mediator;
    private static UsuarioController instance;

    private UsuarioController() {
        this.mediator = Mediator.getInstancia();
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
        ArrayList<Usuario> usuarios = mediator.getArcade().getListaUsuario();
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

    public Mediator getMediator() {
        return mediator;
    }

    public ArrayList<Usuario> obtenerUsuario(){
        return mediator.getArcade().getListaUsuario();
    }

    public String crearUsuarioCliente(String nombre, String correo, String clave, String saldo) {
        ArrayList<Usuario> usuarios = mediator.getArcade().getListaUsuario();
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getCorreo(), correo)) {
                return "El correo ingresado ya se encuentra en uso";
            }
        }
            new RegistrarClienteCommand(mediator.getArcade(), nombre, correo, clave, saldo);
            return "Cliente registrado exitosamente";
    }

    public String crearUsuario(String nombre, String correo, String clave, String tipoUsuario) {
        ArrayList<Usuario> usuarios = mediator.getArcade().getListaUsuario();
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getCorreo(), correo)) {
                return "El correo ingresado ya se encuentra en uso";
            }
        }

        if (tipoUsuario.equals("empleado") || tipoUsuario.equals("EMPLEADO")) {
            new RegistrarEmpleadoCommand(mediator.getArcade(), nombre, correo, clave).execute();
            listaUsuarioObservable.clear();
            this.sincronizarData();
                return "Empleado registrado exitosamente";

        } else if (tipoUsuario.equals("cliente") || tipoUsuario.equals("CLIENTE")) {
            new RegistrarClienteCommand(mediator.getArcade(), nombre, correo, clave, "0" ).execute();
            listaUsuarioObservable.clear();
            this.sincronizarData();
                return "Cliente registrado exitosamente";
        }

        return "Error, no existe el tipo de usuario ingresado";
    }

    public  Usuario consultarUsuario(String correo){
        ArrayList<Usuario> usuarios = mediator.getArcade().getListaUsuario();
        for (Usuario value : usuarios) {
            if (value.getCorreo().equals(correo)){
                return value;
            }
        }
        return null;
    }

    public void eliminarUsuario(String correo){
        int eliminable = -1;
        ArrayList<Usuario> usuarios = mediator.getArcade().getListaUsuario();
        Usuario usuarioEliminable = this.consultarUsuario(correo);

        if (usuarioEliminable != null){
            System.out.println("Eliminando usuario: " + usuarioEliminable.getCorreo());
            eliminable = usuarios.indexOf(usuarioEliminable);
            this.mediator.getArcade().rmUsuario(eliminable);
            this.listaUsuarioObservable.remove(eliminable);
        }
    }

    public void actualizarUsuario(String nombre, String correo, String clave){
        ArrayList<Usuario> usuarios = mediator.getArcade().getListaUsuario();
        int actualizable = -1;
        Usuario usuarioTemporal = null;
        for (int i = 0; i < usuarios.size(); i++){
            if (Objects.equals(usuarios.get(i).getCorreo(), correo)){
                usuarioTemporal = usuarios.get(i);
                usuarioTemporal.setNombre(nombre);
                usuarioTemporal.setClave(clave);
                actualizable = i;
            }
        }
        if (actualizable != -1){
            this.listaUsuarioObservable.remove(actualizable);
            this.mediator.getArcade().rmUsuario(actualizable);
            this.mediator.getArcade().addUsuario(usuarioTemporal);
            this.listaUsuarioObservable.add(usuarioTemporal);
        }
    }

    public ObservableList<Usuario> getListaUsuarioObservable() {
        return listaUsuarioObservable;
    }

    public void setListaUsuarioObservable(ObservableList<Usuario> listaUsuarioObservable) {
        this.listaUsuarioObservable = listaUsuarioObservable;
    }

    public void sincronizarData() {
        this.listaUsuarioObservable.addAll(this.mediator.getArcade().getListaUsuario());
    }
}