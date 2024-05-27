package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ReservaController {
    private final ObservableList<Reserva> listaReservaObservable;
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

    public ArrayList<Reserva> obtenerReservas(){
        return mediator.getArcade().getListaReserva();
    }


    public void eliminarReserva(String id){
        int eliminable = -1;
        ArrayList<Reserva> reservas = mediator.getArcade().getListaReserva();
        for (int i = 0; i < reservas.size(); i++){
            if (Objects.equals(reservas.get(i).getId(), id)){
                reservas.remove(reservas.get(i));
                this.mediator.getArcade().addReserva(reservas.get(i));
                eliminable = i;
            }
        }
        if (eliminable!= -1){
            this.listaReservaObservable.remove(eliminable);
        }
    }
    public  Reserva consultarReserva(String id, String clave) {
        ArrayList<Reserva> reservas = mediator.getArcade().getListaReserva();
        for (Reserva value : reservas) {
            if (value.getId().equals(id)){
                return value;
            }
        }
        return null;
    }


    public void actualizarReserva(String nombre, String id, String clave, String saldo){
        ArrayList<Reserva> reservas = mediator.getArcade().getListaReserva();
        int actualizable = -1;
        Reserva reservaTemporal = null;
        for (int i = 0; i < reservas.size(); i++){
            if (Objects.equals(reservas.get(i).getId(), id)){
                reservaTemporal = reservas.get(i);
                reservaTemporal.setEstado(nombre);
                reservaTemporal.setFecha(clave);
                actualizable = i;
            }
        }
        if (actualizable!= -1 && reservaTemporal != null){
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

