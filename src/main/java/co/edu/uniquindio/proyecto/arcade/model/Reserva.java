package co.edu.uniquindio.proyecto.arcade.model;

public class Reserva {

    private String fecha;
    private String objetoReserva;

    public Reserva(String fecha, String objetoReserva) {
        this.fecha = fecha;
        this.objetoReserva = objetoReserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObjetoReserva() {
        return objetoReserva;
    }

    public void setObjetoReserva(String objetoReserva) {
        this.objetoReserva = objetoReserva;
    }
}