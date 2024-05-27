package co.edu.uniquindio.proyecto.arcade.model.facade;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.builder.UsuarioBuilder;

import java.util.ArrayList;

public class ProductivityPalaceFacade {
    private final ProductivityPalace productivityPalace;

    public ProductivityPalaceFacade() {
        this.productivityPalace = new ProductivityPalace();
    }

    // Métodos de gestión de usuarios
    public void registrarUsuario(String nombre, String correo, String clave, String saldo, TipoUsuario tipoUsuario) {
        Usuario usuario = new UsuarioBuilder()
                .nombre(nombre)
                .correo(correo)
                .clave(clave)
                .saldo(saldo)
                .tipoUsuario(tipoUsuario)
                .build();
        productivityPalace.addUsuario(usuario);
    }

    public Usuario getUserByCorreo(String correo) {
        for (Usuario usuario : productivityPalace.getListaUsuario()) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null; // o lanzar una excepción
    }

    public void actualizarUsuario(String correo, String nuevoCorreo, String nuevoSaldo) {
        Usuario usuario = getUserByCorreo(correo);
        if (usuario != null) {
            usuario.setCorreo(nuevoCorreo);
            usuario.setSaldo(nuevoSaldo);
        }
    }

    public void eliminarUsuario(String correo) {
        Usuario usuario = getUserByCorreo(correo);
        if (usuario != null) {
            productivityPalace.getListaUsuario().remove(usuario);
        }
    }

    // Métodos de gestión de reservas
    public void crearReserva(String correoUsuario, String nombreServicio, String fecha, String estado) {
        Usuario usuario = getUserByCorreo(correoUsuario);
        Servicio servicio = getServiceByName(nombreServicio);
        if (usuario != null && servicio != null) {
            Reserva reserva = new Reserva(usuario, fecha, servicio, estado);
            // Agregar la reserva a una lista de reservas (deberías tener una lista de reservas en ProductivityPalace)
        }
    }

    public Reserva getReservation(String correoUsuario, String fecha) {
        // Implementar la búsqueda de una reserva específica
        return null;
    }

    public void updateReservation(String correoUsuario, String fecha, String nuevoNombreServicio, String nuevaFecha, String nuevoEstado) {
        // Implementar la actualización de una reserva
    }

    public void cancelReservation(String correoUsuario, String fecha) {
        // Implementar la cancelación de una reserva
    }

    // Métodos de gestión de servicios
    public void addService(String nombre, String precio, String disponibilidadReserva) {
        Servicio servicio = new Servicio(nombre, precio, disponibilidadReserva);
        productivityPalace.addServicio(servicio);
    }

    public Servicio getServiceByName(String nombre) {
        for (Servicio servicio : productivityPalace.getListaServicio()) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;
            }
        }
        return null; // o lanzar una excepción
    }

    public void updateService(String nombre, String nuevoPrecio, String nuevaDisponibilidadReserva) {
        Servicio servicio = getServiceByName(nombre);
        if (servicio != null) {
            servicio.setPrecio(nuevoPrecio);
            servicio.setDisponibilidadReserva(nuevaDisponibilidadReserva);
        }
    }

    public void deleteService(String nombre) {
        Servicio servicio = getServiceByName(nombre);
        if (servicio != null) {
            productivityPalace.getListaServicio().remove(servicio);
        }
    }

    // Métodos de gestión de productos
    public void addProduct(String nombre, String precio, String cantidadDisponible) {
        Producto producto = new Producto(nombre, precio, cantidadDisponible);
        productivityPalace.addProducto(producto);
    }

    public Producto getProductByName(String nombre) {
        for (Producto producto : productivityPalace.getListaProducto()) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null; // o lanzar una excepción
    }

    public void updateProduct(String nombre, String nuevoPrecio, String nuevaCantidadDisponible) {
        Producto producto = getProductByName(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            producto.setCantidadDisponible(nuevaCantidadDisponible);
        }
    }

    public void deleteProduct(String nombre) {
        Producto producto = getProductByName(nombre);
        if (producto != null) {
            productivityPalace.getListaProducto().remove(producto);
        }
    }

    // Métodos de gestión de pagos
    public void registerPayment(String correoUsuario, String tipoDePago, String monto, String fecha, String[] nombresProductos) {
        Usuario usuario = getUserByCorreo(correoUsuario);
        if (usuario != null) {
            ArrayList<Producto> productos = new ArrayList<>();
            for (String nombreProducto : nombresProductos) {
                Producto producto = getProductByName(nombreProducto);
                if (producto != null) {
                    productos.add(producto);
                }
            }
            Pago pago = new Pago(estrategiaPago, monto, fecha);
            pago.realizarPago();
            // Agregar el pago a una lista de pagos del usuario (deberías tener una lista de pagos)
        }
    }

    public Pago getPayment(String correoUsuario, String fecha) {
        // Implementar la búsqueda de un pago específico
        return null;
    }

    public void updatePayment(String correoUsuario, String fecha, String nuevoTipoDePago, String nuevoMonto) {
        // Implementar la actualización de un pago
    }

    public void deletePayment(String correoUsuario, String fecha) {
        // Implementar la eliminación de un pago
    }
}
