package co.edu.uniquindio.proyecto.arcade.model.bridge;

public class NotificacionReserva extends Notificacion {
    public NotificacionReserva(MetodoNotificacion metodoNotificacion) {
        super(metodoNotificacion);
    }

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviando notificación de reserva...");
        metodoNotificacion.enviarNotificacion(destinatario, mensaje);
    }
}