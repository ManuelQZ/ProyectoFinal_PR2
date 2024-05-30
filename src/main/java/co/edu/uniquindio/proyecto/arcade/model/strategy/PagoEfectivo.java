package co.edu.uniquindio.proyecto.arcade.model.strategy;

public class PagoEfectivo implements PagoStrategy {
    @Override
    public void pagar(String monto) {
        System.out.println("Pagando " + monto + " en efectivo");
        // Lógica de pago en efectivo
    }
}
