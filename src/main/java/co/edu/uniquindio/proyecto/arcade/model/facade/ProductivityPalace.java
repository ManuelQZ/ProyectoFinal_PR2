package co.edu.uniquindio.proyecto.arcade.model.facade;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.bridge.EnvioCorreo;
import co.edu.uniquindio.proyecto.arcade.model.bridge.Notificacion;
import co.edu.uniquindio.proyecto.arcade.model.bridge.NotificacionReserva;
import co.edu.uniquindio.proyecto.arcade.model.builder.UsuarioBuilder;
import co.edu.uniquindio.proyecto.arcade.model.proxy.UsuarioProxy;

import java.util.ArrayList;

public class ProductivityPalace {

    private final ArrayList<Producto> listaProducto;
    private final ArrayList<Servicio> listaServicio;
    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<Usuario> listaCliente;
    private final ArrayList<Reserva> listaReserva;
    private final Usuario administrador;
    private final UsuarioProxy usuarioTemporal;

    public ProductivityPalace() {
        this.listaCliente = new ArrayList<>();
        this.listaUsuario = new ArrayList<>();
        this.listaReserva = new ArrayList<>();
        this.usuarioTemporal = new UsuarioProxy();
        this.listaProducto = new ArrayList<>();
        this.listaServicio = new ArrayList<>();

        this.administrador = new UsuarioBuilder()
                .nombre("Productivty Palace")
                .correo("arcade@admin.com")
                .clave("1234")
                .tipoUsuario(TipoUsuario.ADMINISTRADOR)
                .build();

        this.addUsuario(this.administrador);

    }

    public UsuarioProxy getUsuarioTemporal() {
        return usuarioTemporal;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void addUsuario(Usuario usuario){
        this.listaUsuario.add(usuario);
        System.out.println("la lista tiene los elementos: " + this.listaUsuario.toString());
    }
    public void addCliente(Usuario usuario){
        this.listaUsuario.add(usuario);
        System.out.println("la lista tiene los elementos: " + this.listaUsuario.toString());
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

    public void crearEmpleado(String nombre, String correo, String clave) {
        Usuario empleado = new UsuarioBuilder()
                .nombre(nombre)
                .correo(correo)
                .clave(clave)
                .tipoUsuario(TipoUsuario.EMPLEADO)
                .build();
        this.addUsuario(empleado);
    }

    public void crearCliente(String nombre, String correo, String clave, String saldo) {
        Usuario cliente =  new UsuarioBuilder()
                .nombre(nombre)
                .correo(correo)
                .clave(clave)
                .saldo(saldo)
                .tipoUsuario(TipoUsuario.CLIENTE)
                .build();

        this.addCliente(cliente);
        this.addUsuario(cliente);
    }

    public void enviarNotificacionReserva(String destinatario, String mensaje) {
        Notificacion notificacion = new NotificacionReserva(new EnvioCorreo());
        notificacion.enviar(destinatario, mensaje);
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

    public void realizarPago(String correoUsuario, String tipoDePago, String monto, String fecha, String[] nombresProductos, double descuento) {
        Usuario usuario = null;
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getCorreo().equals(correoUsuario)) {
                usuario = listaUsuario.get(i);
            }
        }
        if (usuario!= null) {
            usuario.realizarPago(tipoDePago, monto, fecha, nombresProductos, descuento);
        }
    }
}

