package co.edu.uniquindio.proyecto.arcade.model.command;

import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalaceFacade;

public class RegistrarUsuarioCommand implements Command {
    private final ProductivityPalaceFacade facade;
    private final String nombre;
    private final String correo;
    private final String clave;
    private final String saldo;
    private final TipoUsuario tipoUsuario;

    public RegistrarUsuarioCommand(ProductivityPalaceFacade facade, String nombre, String correo, String clave, String saldo, TipoUsuario tipoUsuario) {
        this.facade = facade;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.saldo = saldo;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public void execute() {
        facade.registrarUsuario(nombre, correo, clave, saldo, tipoUsuario);
    }
}
