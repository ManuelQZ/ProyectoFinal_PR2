package co.edu.uniquindio.proyecto.arcade.model.strategy;

public class PagoPayPal implements PagoStrategy {
    private String email;

    public PagoPayPal(String email) {
        this.email = email;
    }

    @Override
    public void pagar(String monto) {
        System.out.println("Pagando " + monto + " usando PayPal con cuenta " + email);
        // Lógica de pago con PayPal
    }
}