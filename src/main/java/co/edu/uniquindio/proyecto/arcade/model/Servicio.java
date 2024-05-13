package co.edu.uniquindio.proyecto.arcade.model;

public class Servicio {

    private String nombre;
    private String precio;
    private String disponibilidadReserva;

    public Servicio(String nombre, String precio, String disponibilidadReserva) {
        this.nombre = nombre;
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

    public String getDisponibilidadReserva() {
        return disponibilidadReserva;
    }

    public void setDisponibilidadReserva(String disponibilidadReserva) {
        this.disponibilidadReserva = disponibilidadReserva;
    }
}
