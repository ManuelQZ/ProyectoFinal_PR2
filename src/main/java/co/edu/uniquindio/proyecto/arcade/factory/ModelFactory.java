package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.ProductivityPalace;
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
        Usuario usuario3 = new Usuario("Carlos Gómez", "carlos.gomez@example.com", "c4rl0sPass!", "3500.00", TipoUsuario.ADMINISTRADOR);
        Usuario usuario4 = new Usuario("Ana Torres", "ana.torres@example.com", "4naT0rr3s", "4500.00", TipoUsuario.CLIENTE);
        Usuario usuario5 = new Usuario("Luis Martínez", "luis.martinez@example.com", "lu1sM8rt!", "5500.00", TipoUsuario.EMPLEADO);

        arcade.addUsuario(usuario1);
        arcade.addUsuario(usuario2);
        arcade.addUsuario(usuario3);
        arcade.addUsuario(usuario4);
        arcade.addUsuario(usuario5);
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