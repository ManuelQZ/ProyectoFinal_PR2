package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;

public class Servicio {

    private String nombre;
    private String descripcion;
    private Modalidad modalidad;
    private String precio;
    private String disponibilidadReserva;


    public Servicio(String nombre, String descripcion, Modalidad modalidad, String precio, String disponibilidadReserva) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.precio = precio;
        this.disponibilidadReserva = disponibilidadReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public String getDisponibilidadReserva() {
        return disponibilidadReserva;
    }

    public void setDisponibilidadReserva(String disponibilidadReserva) {
        this.disponibilidadReserva = disponibilidadReserva;
    }
}
