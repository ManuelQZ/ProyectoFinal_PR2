package co.edu.uniquindio.proyecto.arcade.factory;

import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;

public class Mediator {

    private static Mediator mediator;

    private ProductivityPalace arcade;


    private Mediator(){
        this.arcade = new ProductivityPalace();
        ModelFactory.inicializarDatos(arcade);
    }

    public static Mediator getInstancia() {
        if(mediator == null) {
            mediator = new Mediator();
        }
        return mediator;
    }

    public ProductivityPalace getArcade() {
        return arcade;
    }
}
