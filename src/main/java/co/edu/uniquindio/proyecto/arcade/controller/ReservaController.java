package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.ModelFactory;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ReservaController {
    private final ObservableList<Reserva> listaReservaObservable;
    private final ModelFactory factory;
    private static ReservaController instance;

    private ReservaController() {
        this.factory = ModelFactory.getInstancia();
        this.listaReservaObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public static ReservaController getInstance(){
        if(instance == null){
            return instance = new ReservaController();
        }
        return instance;

    }

    public ModelFactory getFactory() {
        return factory;
    }

    public ArrayList<Reserva> obtenerReservas(){
        return factory.getArcade().getListaReserva();
    }


    public void eliminarReserva(String id){
        int eliminable = -1;
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
        for (int i = 0; i < reservas.size(); i++){
            if (Objects.equals(reservas.get(i).getId(), id)){
                reservas.remove(reservas.get(i));
                this.factory.getArcade().addReserva(reservas.get(i));
                eliminable = i;
            }
        }
        if (eliminable!= -1){
            this.listaReservaObservable.remove(eliminable);
        }
    }
    public  Reserva consultarReserva(String id, String clave) {
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
        for (Reserva value : reservas) {
            if (value.getId().equals(id)){
                return value;
            }
        }
        return null;
    }


    public void actualizarReserva(String nombre, String id, String clave, String saldo){
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
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
            this.factory.getArcade().rmReserva(actualizable);
            this.factory.getArcade().addReserva(reservaTemporal);
            this.listaReservaObservable.add(reservaTemporal);
        }
    }

    public ObservableList<Reserva> getListaReservaObservable() {
        return listaReservaObservable;
    }

    public void sincronizarData() {
        this.listaReservaObservable.addAll(this.factory.getArcade().getListaReserva());
    }
}

