package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.*;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarClienteCommand;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarEmpleadoCommand;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;
import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoEfectivo;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoPayPal;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoStrategy;
import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoTarjeta;

import java.util.Calendar;
import java.util.Date;

public class ModelFactory {


    protected static void inicializarDatos(ProductivityPalace arcade) {
        registrarUsuarios(arcade);
        agregarProductos(arcade);
        agregarServicios(arcade);
        crearReservas(arcade);
        crearPagos(arcade);
    }

    private static void registrarUsuarios(ProductivityPalace arcade) {
        registrarCliente(arcade, "Juan Pérez", "juan.perez@example.com", "password123", "1500.00");
        registrarCliente(arcade, "Ana Torres", "ana.torres@example.com", "4naT0rr3s", "4500.00");
        registrarEmpleado(arcade, "María López", "maria.lopez@example.com", "123");
        registrarEmpleado(arcade, "Luis Martínez", "luis.martinez@example.com", "lu1sM8rt!");
    }

    private static void registrarCliente(ProductivityPalace arcade, String nombre, String email, String contraseña, String saldo) {
        new RegistrarClienteCommand(arcade, nombre, email, contraseña, saldo).execute();
    }

    private static void registrarEmpleado(ProductivityPalace arcade, String nombre, String email, String contraseña) {
        new RegistrarEmpleadoCommand(arcade, nombre, email, contraseña).execute();
    }

    private static void agregarProductos(ProductivityPalace arcade) {
        Producto producto1 = new Producto("GTA V", "5.99", "50");
        Producto producto2 = new Producto("Warframe", "3.49", "30");
        Producto producto3 = new Producto("Call of Duty", "2.99", "100");
        Producto producto4 = new Producto("Minecraft", "1.89", "75");
        Producto producto5 = new Producto("League of Legends", "2.50", "40");

        arcade.addProducto(producto1);
        arcade.addProducto(producto2);
        arcade.addProducto(producto3);
        arcade.addProducto(producto4);
        arcade.addProducto(producto5);
    }

    private static void agregarServicios(ProductivityPalace arcade) {
        Servicio servicio1 = new Servicio("Arcade Nocturno", "Acceso ilimitado al arcade durante las noches", Modalidad.TIEMPO, "12.99", "Disponible de 8 PM a 6 AM");
        Servicio servicio2 = new Servicio("Suscripción VIP", "Acceso completo a todas las máquinas y eventos especiales del arcade", Modalidad.SUSCRIPCION, "49.99 al mes", "Disponible");
        Servicio servicio3 = new Servicio("Partida Única", "Pago por una sola partida en cualquier juego del arcade", Modalidad.PAGO_POR_USO, "2.99 por partida", "Disponible");
        Servicio servicio4 = new Servicio("Membresía Gratuita", "Acceso gratuito a una selección limitada de juegos y eventos comunitarios", Modalidad.GRATUITO, "0.00", "Disponible");
        Servicio servicio5 = new Servicio("Pase de Evento Especial", "Acceso a eventos temáticos y torneos de fin de semana", Modalidad.TIEMPO, "24.99", "Disponible solo los fines de semana");

        arcade.addServicio(servicio1);
        arcade.addServicio(servicio2);
        arcade.addServicio(servicio3);
        arcade.addServicio(servicio4);
        arcade.addServicio(servicio5);
    }

    private static void crearReservas(ProductivityPalace arcade) {
        Usuario usuario1 = arcade.obtenerUsuario("juan.perez@example.com");
        Usuario usuario2 = arcade.obtenerUsuario("ana.torres@example.com");
        Usuario usuario3 = arcade.obtenerUsuario("maria.lopez@example.com");
        Usuario usuario4 = arcade.obtenerUsuario("luis.martinez@example.com");

        Date fecha1 = new Date();
        Calendar cal = Calendar.getInstance();

        cal.set(2024, Calendar.JUNE, 10);
        Date fecha2 = cal.getTime();

        cal.set(2024, Calendar.JULY, 15);
        Date fecha3 = cal.getTime();

        cal.set(2024, Calendar.AUGUST, 20);
        Date fecha4 = cal.getTime();

        cal.set(2024, Calendar.SEPTEMBER, 25);
        Date fecha5 = cal.getTime();

        // Crear reservas
        Reserva reserva1 = new Reserva(usuario1,  fecha1, arcade.obtenerServicio("Arcade Nocturno"), "pendiente");
        Reserva reserva2 = new Reserva(usuario2,  fecha2, arcade.obtenerServicio("Suscripción VIP"), "confirmada");
        Reserva reserva3 = new Reserva(usuario3,  fecha3, arcade.obtenerServicio("Partida Única"), "cancelada");
        Reserva reserva4 = new Reserva(usuario4,  fecha4, arcade.obtenerServicio("Membresía Gratuita"), "pendiente");
        Reserva reserva5 = new Reserva(usuario1,  fecha5, arcade.obtenerServicio("Pase de Evento Especial"), "confirmada");

        arcade.addReserva(reserva1);
        arcade.addReserva(reserva2);
        arcade.addReserva(reserva3);
        arcade.addReserva(reserva4);
        arcade.addReserva(reserva5);
    }

    private static void crearPagos(ProductivityPalace arcade) {
        PagoStrategy estrategiaPago1 = new PagoEfectivo();
        PagoStrategy estrategiaPago2 = new PagoPayPal("juan.perez@example.com");
        PagoStrategy estrategiaPago3 = new PagoTarjeta("142054211510L");
        PagoStrategy estrategiaPago4 = new PagoEfectivo();
        PagoStrategy estrategiaPago5 = new PagoTarjeta("142064211510L");

        Pago pago1 = new Pago(estrategiaPago1, "150.00");
        Pago pago2 = new Pago(estrategiaPago2, "250.00");
        Pago pago3 = new Pago(estrategiaPago3, "350.00");
        Pago pago4 = new Pago(estrategiaPago4, "450.00");
        Pago pago5 = new Pago(estrategiaPago5, "550.00");

        arcade.addPago(pago1);
        arcade.addPago(pago2);
        arcade.addPago(pago3);
        arcade.addPago(pago4);
        arcade.addPago(pago5);
    }

}