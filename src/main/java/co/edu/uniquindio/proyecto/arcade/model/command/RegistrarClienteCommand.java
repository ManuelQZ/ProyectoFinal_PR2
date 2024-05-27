package co.edu.uniquindio.proyecto.arcade.model.command;

import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;

public class RegistrarClienteCommand implements Command {
    private final ProductivityPalace facade;
    private final String nombre;
    private final String correo;
    private final String clave;
    private final String saldo;

    public RegistrarClienteCommand(ProductivityPalace facade, String nombre, String correo, String clave, String saldo) {
        this.facade = facade;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.saldo = saldo;
    }

    @Override
    public void execute() {
        facade.crearCliente(nombre, correo, clave, saldo);
    }
}
