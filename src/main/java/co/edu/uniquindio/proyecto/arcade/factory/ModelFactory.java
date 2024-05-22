package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.ProductivityPalace;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;

public class ModelFactory{

    private static ModelFactory modelFactory;

    private ProductivityPalace arcade;


    private ModelFactory(){
        this.arcade = new ProductivityPalace();
        inicializarDatos();
    }

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {
        Usuario usuario1 = new Usuario("Juan Pérez", "juan.perez@example.com", "password123", "1500.00", TipoUsuario.CLIENTE);
        Usuario usuario2 = new Usuario("María López", "maria.lopez@example.com", "m4r1a2023", "2500.00", TipoUsuario.EMPLEADO);
        Usuario usuario3 = new Usuario("Carlos Gómez", "carlos.gomez@example.com", " ", "3500.00", TipoUsuario.ADMINISTRADOR);
        Usuario usuario4 = new Usuario("Ana Torres", "ana.torres@example.com", "4naT0rr3s", "4500.00", TipoUsuario.CLIENTE);
        Usuario usuario5 = new Usuario("Luis Martínez", "luis.martinez@example.com", "lu1sM8rt!", "5500.00", TipoUsuario.EMPLEADO);

        arcade.addUsuario(usuario1);
        arcade.addUsuario(usuario2);
        arcade.addUsuario(usuario3);
        arcade.addUsuario(usuario4);
        arcade.addUsuario(usuario5);

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

    public Usuario crearUsuario(String nombre,
                                String correo,
                                String clave,
                                String saldo,
                                TipoUsuario tipoUsuario){
        return new Usuario(nombre,correo,clave,saldo,tipoUsuario);
    }


    public ProductivityPalace getArcade() {
        return arcade;
    }
}