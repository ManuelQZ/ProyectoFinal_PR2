package co.edu.uniquindio.proyecto.arcade.model;

import java.util.ArrayList;
import co.edu.uniquindio.proyecto.arcade.model.*;

public class ProductivityPalace {

    private ArrayList<Producto> listaProducto;
    private ArrayList<Servicio> listaServicio;
    private ArrayList<Usuario> listaUsuario;

    private UsuarioProxy usuarioTemporal;

    public ProductivityPalace() {
        this.listaUsuario = new ArrayList<Usuario>();
        this.usuarioTemporal = new UsuarioProxy();
    }

    public UsuarioProxy getUsuarioTemporal() {
        return usuarioTemporal;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void addUsuario(Usuario usuario){
        this.listaUsuario.add(usuario);
    }

    public void rmUsuario(Usuario usuario){
        this.listaUsuario.remove(usuario);
    }

    public void addProducto(Producto producto) {
        this.listaProducto.add(producto);
    }

    public void addServicio(Servicio servicio) {
        this.listaServicio.add(servicio);
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }
}

