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
        this.listaProducto = new ArrayList<Producto>();
        this.listaServicio = new ArrayList<Servicio>();
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

    public void rmUsuario(int index){
        this.listaUsuario.remove(index);
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

