package co.edu.uniquindio.proyecto.arcade.model.command;

import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;

public class RegistrarEmpleadoCommand implements Command {
    private final ProductivityPalace facade;
    private final String nombre;
    private final String correo;
    private final String clave;

    public RegistrarEmpleadoCommand(ProductivityPalace facade, String nombre, String correo, String clave) {
        this.facade = facade;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;

    }

    @Override
    public void execute() {
        facade.crearEmpleado(nombre, correo, clave);
    }
}
