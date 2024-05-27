package co.edu.uniquindio.proyecto.arcade.model.strategy;

public class PagoTarjeta implements PagoStrategy {
    private final String numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando " + monto + " usando tarjeta con número " + numeroTarjeta);
        // Lógica de pago con tarjeta
    }
}