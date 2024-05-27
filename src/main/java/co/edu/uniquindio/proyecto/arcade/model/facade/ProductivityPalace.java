package co.edu.uniquindio.proyecto.arcade.model.facade;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.builder.UsuarioBuilder;
import co.edu.uniquindio.proyecto.arcade.model.proxy.UsuarioProxy;

import java.util.ArrayList;

public class ProductivityPalace {

    private final ArrayList<Producto> listaProducto;
    private final ArrayList<Servicio> listaServicio;
    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<Reserva> listaReserva;
    private final Usuario administrador;
    private final UsuarioProxy usuarioTemporal;

    public ProductivityPalace() {
        this.administrador = new UsuarioBuilder()
                .nombre("Productivty Palace")
                .correo("arcade@admin.com")
                .clave("1234")
                .tipoUsuario(TipoUsuario.ADMINISTRADOR)
                .build();

        addUsuario(this.administrador);

        this.listaUsuario = new ArrayList<>();
        this.listaReserva = new ArrayList<>();
        this.usuarioTemporal = new UsuarioProxy();
        this.listaProducto = new ArrayList<>();
        this.listaServicio = new ArrayList<>();
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

    public Usuario crearEmpleado(String nombre, String correo, String clave) {
        return new UsuarioBuilder()
                .nombre(nombre)
                .correo(correo)
                .clave(clave)
                .tipoUsuario(TipoUsuario.EMPLEADO)
                .build();
    }

    public Usuario crearCliente(String nombre, String correo, String clave, String saldo) {
        return new UsuarioBuilder()
                .nombre(nombre)
                .correo(correo)
                .clave(clave)
                .saldo(saldo)
                .tipoUsuario(TipoUsuario.EMPLEADO)
                .build();
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public ArrayList<Servicio> getListaServicio() {
        return listaServicio;
    }

    public void addReserva(Reserva reserva) {
        listaReserva.add(reserva);
    }


    public void rmReserva(int index) {
        listaReserva.remove(index);
    }
}
