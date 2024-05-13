package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.ProductivityPalace;
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
        Usuario usuario1 = new Usuario(
                "JorgeAniquilador" ,
                "Jorgeaniquilador@gmail.com",
                "300");
        Usuario usuario2 = new Usuario(
                "MariaGamer",
                "mariagamer@hotmail.com",
                "500");
        Usuario usuario3 = new Usuario(
                "PedroPlayer",
                "pedroplayer@gmail.com",
                "200");

        arcade.getListaUsuario().add(usuario1);
        arcade.getListaUsuario().add(usuario2);
        arcade.getListaUsuario().add(usuario3);
    }


    public Usuario crearUsuario(String nombre,
                                String correo,
                                String saldo){
        return new Usuario(nombre,correo,saldo);
    }

    public ProductivityPalace getArcade() {
        return arcade;
    }
}