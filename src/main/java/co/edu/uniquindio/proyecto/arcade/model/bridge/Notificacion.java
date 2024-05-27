package co.edu.uniquindio.proyecto.arcade.model.bridge;

public abstract class Notificacion {
    protected MetodoNotificacion metodoNotificacion;

    public Notificacion(MetodoNotificacion metodoNotificacion) {
        this.metodoNotificacion = metodoNotificacion;
    }

    public abstract void enviar(String destinatario, String mensaje);
}
