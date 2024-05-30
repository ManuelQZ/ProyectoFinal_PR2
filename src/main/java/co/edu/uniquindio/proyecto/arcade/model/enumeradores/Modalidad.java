package co.edu.uniquindio.proyecto.arcade.model.enumeradores;

public enum Modalidad {
    TIEMPO,
    SUSCRIPCION,
    PAGO_POR_USO,
    GRATUITO;

    // Getter
    public static Modalidad getModalidad(String modalidad) {
            return switch (modalidad) {
            case "TIEMPO" -> TIEMPO;
            case "SUSCRIPCION" -> SUSCRIPCION;
            case "PAGO_POR_USO" -> PAGO_POR_USO;
            case "GRATUITO" -> GRATUITO;
            default -> null;
        };
    }
}