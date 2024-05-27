package co.edu.uniquindio.proyecto.arcade.model;

public class Reserva {

    private Usuario usuario;
    private Servicio servicio;
    private String fecha;
    private String estado;


    public Reserva(Usuario usuario, String fecha, Servicio servicio, String estado) {
        this.fecha = fecha;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Servicio getServicio() {
        return servicio;
    }
}