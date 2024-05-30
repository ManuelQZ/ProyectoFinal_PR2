package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ReservaController {
    private ObservableList<Reserva> listaReservaObservable;
    private final Mediator mediator;
    private static ReservaController instance;

    private ReservaController() {
        this.mediator = Mediator.getInstancia();
        this.listaReservaObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public static ReservaController getInstance(){
        if(instance == null){
            return instance = new ReservaController();
        }
        return instance;

    }

    public Mediator getMediator() {
        return mediator;
    }

    public void agregarReserva(Usuario usuario, Date fecha, Servicio servicio, String estado){
        Reserva reserva = new Reserva(usuario, fecha, servicio, estado);
        this.mediator.getArcade().addReserva(reserva);
        this.listaReservaObservable.add(reserva);
    }

    public  Reserva consultarReserva(String id) {
        ArrayList<Reserva> reservas = mediator.getArcade().getListaReserva();
        for (Reserva value : reservas) {
            if (value.getId().equals(id)){
                return value;
            }
        }
        return null;
    }

    public ArrayList<Reserva> obtenerReservas(){
        return mediator.getArcade().getListaReserva();
    }


    public void eliminarReserva(String id){
        ArrayList<Reserva> reservas = mediator.getArcade().getListaReserva();
        Reserva reservaEliminable = this.consultarReserva(id);
        int eliminable;
        if (reservaEliminable!= null){
            eliminable = reservas.indexOf(reservaEliminable);
            this.listaReservaObservable.remove(eliminable);
            this.mediator.getArcade().rmReserva(eliminable);
        }
    }

    public void actualizarReserva(Usuario usuario, Date fecha, Servicio servicio, String estado, String id){
        ArrayList<Reserva> reservas = mediator.getArcade().getListaReserva();
        int actualizable = -1;
        Reserva reservaTemporal = null;

        for (int i = 0; i < reservas.size(); i++){
            if (Objects.equals(reservas.get(i).getId(), id)){
                reservaTemporal = reservas.get(i);
                reservaTemporal.setEstado(estado);
                
                actualizable = i;
            }
        }

        if (actualizable != -1){
            this.listaReservaObservable.remove(actualizable);
            this.mediator.getArcade().rmReserva(actualizable);
            this.mediator.getArcade().addReserva(reservaTemporal);
            this.listaReservaObservable.add(reservaTemporal);
        }
    }

  

    public ObservableList<Reserva> getListaReservaObservable() {
        return listaReservaObservable;
    }


    public void sincronizarData() {
        this.listaReservaObservable.addAll(this.mediator.getArcade().getListaReserva());
    }
}

