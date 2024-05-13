package co.edu.uniquindio.proyecto.arcade.model;

public class Pago {

    private String tipoDePago;
    private String Monto;
    private String fecha;

    public Pago(String tipoDePago, String monto, String fecha) {
        this.tipoDePago = tipoDePago;
        Monto = monto;
        this.fecha = fecha;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String monto) {
        Monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
