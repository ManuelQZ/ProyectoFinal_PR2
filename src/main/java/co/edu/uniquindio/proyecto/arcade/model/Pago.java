package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoStrategy;

import java.util.Date;

public class Pago {
    private final PagoStrategy estrategiaPago;
    private double monto;
    private final Date fecha;

    public Pago(PagoStrategy estrategiaPago, double monto) {
        this.estrategiaPago = estrategiaPago;
        this.monto = monto;
        this.fecha = new Date();
    }

    public void realizarPago() {
        estrategiaPago.pagar(monto);
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }
}
