package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.model.strategy.PagoStrategy;

public class Pago {
    private PagoStrategy estrategiaPago;
    private double monto;
    private String fecha;

    public Pago(PagoStrategy estrategiaPago, double monto, String fecha) {
        this.estrategiaPago = estrategiaPago;
        this.monto = monto;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
