package co.edu.uniquindio.proyecto.arcade.model.bridge;

public class EnvioCorreo implements MetodoNotificacion {
    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando correo a " + destinatario + ":");
        System.out.println("Mensaje: " + mensaje);
        // Lógica para enviar el correo electrónico
    }
}
