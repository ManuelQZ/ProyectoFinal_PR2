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
        System.out.println("Hola");
    }

//
//    public Usuario crearUsuario(String nombre,
//                                String correo,
//                                String saldo){
//        return new Usuario(nombre,correo,saldo);
//    }

    public ProductivityPalace getArcade() {
        return arcade;
    }
}