package co.edu.uniquindio.proyecto.arcade.model;

import java.util.Date;
import java.util.UUID;

public class Reserva implements Cloneable {

    private Usuario usuario;
    private String id;
    private Servicio servicio;
    private Date fecha;
    private String estado;


    public Reserva(Usuario usuario, String id, Date fecha, Servicio servicio, String estado) {
        this.usuario = usuario;
        this.id = this.generarId();
        this.fecha = fecha;
        this.servicio = servicio;
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public String generarId() {
        UUID uniqueID = UUID.randomUUID();
        return uniqueID.toString();

    }
}
