package co.edu.uniquindio.proyecto.arcade.model;

public class Reserva implements Cloneable {

    private Usuario usuario;
    private String id;
    private Servicio servicio;
    private String fecha;
    private String estado;


    public Reserva(Usuario usuario, String id, String fecha, Servicio servicio, String estado) {
        this.usuario = usuario;
        this.id = id;
        this.fecha = fecha;
        this.servicio = servicio;
        this.estado = estado;
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

    @Override
    public Reserva clone() throws CloneNotSupportedException {
        return (Reserva) super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
