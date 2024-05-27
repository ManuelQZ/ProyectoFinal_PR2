package co.edu.uniquindio.proyecto.arcade.model.command;

import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;

public class RealizarPagoCommand implements Command {
    private final ProductivityPalace facade;
    private final String correoUsuario;
    private final String tipoDePago;
    private final String monto;
    private final String fecha;
    private final String[] nombresProductos;
    private final double descuento;

    public RealizarPagoCommand(ProductivityPalace facade, String correoUsuario, String tipoDePago, String monto, String fecha, String[] nombresProductos, double descuento) {
        this.facade = facade;
        this.correoUsuario = correoUsuario;
        this.tipoDePago = tipoDePago;
        this.monto = monto;
        this.fecha = fecha;
        this.nombresProductos = nombresProductos;
        this.descuento = descuento;
    }

    @Override
    public void execute() {
        facade.realizarPago(correoUsuario, tipoDePago, monto, fecha, nombresProductos, descuento);
    }
}