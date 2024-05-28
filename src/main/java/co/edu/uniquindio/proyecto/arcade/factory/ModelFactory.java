package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarClienteCommand;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarEmpleadoCommand;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;
import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;

import java.util.Calendar;
import java.util.Date;

public class ModelFactory {


    protected static void inicializarDatos(ProductivityPalace arcade) {
        new RegistrarClienteCommand(arcade, "Juan Pérez", "juan.perez@example.com", "password123", "1500.00").execute();
        new RegistrarClienteCommand(arcade, "Ana Torres", "ana.torres@example.com", "4naT0rr3s", "4500.00").execute();
        new RegistrarEmpleadoCommand(arcade, "María López", "maria.lopez@example.com", "123").execute();
        new RegistrarEmpleadoCommand(arcade, "Luis Martínez", "luis.martinez@example.com", "lu1sM8rt!").execute();

        Usuario usuario1 = arcade.obtenerUsuario("juan.perez@example.com");
        Usuario usuario2 = arcade.obtenerUsuario("ana.torres@example.com");
        Usuario usuario3 = arcade.obtenerUsuario("maria.lopez@example.com");
        Usuario usuario4 = arcade.obtenerUsuario("luis.martinez@example.com");

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
        Reserva reserva1 = new Reserva(usuario1, "1", fecha1, servicio1, "pendiente");
        Reserva reserva2 = new Reserva(usuario2, "2", fecha2, servicio2, "confirmada");
        Reserva reserva3 = new Reserva(usuario3, "3", fecha3, servicio3, "cancelada");
        Reserva reserva4 = new Reserva(usuario4, "4", fecha4, servicio4, "pendiente");
        Reserva reserva5 = new Reserva(usuario1, "5", fecha5, servicio5, "confirmada");

        arcade.addReserva(reserva1);
        arcade.addReserva(reserva2);
        arcade.addReserva(reserva3);
        arcade.addReserva(reserva4);
        arcade.addReserva(reserva5);
    }

}