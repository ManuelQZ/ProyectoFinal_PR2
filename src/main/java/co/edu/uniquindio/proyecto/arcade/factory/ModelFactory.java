package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;

public class ModelFactory {


    protected static void inicializarDatos(ProductivityPalace arcade) {
        Usuario cliente1 = arcade.crearCliente("Juan Pérez", "juan.perez@example.com", "password123", "1500.00");
        Usuario cliente2 = arcade.crearCliente("Ana Torres", "ana.torres@example.com", "4naT0rr3s", "4500.00");

        Usuario empleado1 = arcade.crearEmpleado("María López", "maria.lopez@example.com", "m4r1a2023");
        Usuario empleado2 = arcade.crearEmpleado("Luis Martínez", "luis.martinez@example.com", "lu1sM8rt!");

        arcade.addUsuario(cliente1);
        arcade.addUsuario(cliente2);
        arcade.addUsuario(empleado1);
        arcade.addUsuario(empleado2);

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

        Servicio servicio1 = new Servicio("Máquina de Pac-Man", "500", "Disponible");
        Servicio servicio2 = new Servicio("Máquina de Pinball", "600", "No Disponible");
        Servicio servicio3 = new Servicio("Máquina de Dance Dance Revolution", "700", "Disponible");
        Servicio servicio4 = new Servicio("Máquina de Mortal Kombat", "550", "Disponible");
        Servicio servicio5 = new Servicio("Máquina de Air Hockey", "800", "No Disponible");

        arcade.addServicio(servicio1);
        arcade.addServicio(servicio2);
        arcade.addServicio(servicio3);
        arcade.addServicio(servicio4);
        arcade.addServicio(servicio5);

    }

}