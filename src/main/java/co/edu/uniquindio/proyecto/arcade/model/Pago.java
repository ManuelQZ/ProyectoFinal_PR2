package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoStrategy;

import java.util.Date;

public class Pago {
    private final PagoStrategy estrategiaPago;
    private String monto;
    private final Date fecha;

    public Pago(PagoStrategy estrategiaPago, String monto) {
        this.estrategiaPago = estrategiaPago;
        this.monto = monto;
        this.fecha = new Date();
    }

    public void realizarPago() {
        estrategiaPago.pagar(monto);
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getMetodoPago() {
        return estrategiaPago.getClass().getSimpleName();
    }
}
