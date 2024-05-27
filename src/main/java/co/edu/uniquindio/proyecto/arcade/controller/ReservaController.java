package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.ModelFactory;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ReservaController {
    private ObservableList<Usuario> listaReservaObservable;
    private ModelFactory factory;
    private static ReservaController instance;

    private UsuarioController() {
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
    public ArrayList<Reserva> filtrarReserva(Boolean esCorreo, String busqueda) {
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
        ArrayList<Reserva> reservasFiltrado = new ArrayList<>();
        if (esCorreo) {
            for (Reserva reserva : reservas) {
                if (Objects.equals(reserva.getFecha(), busqueda)) {
                    reservasFiltrado.add(reserva);
                }
            }
        }
        else {
            for (Reserva reserva : reservas) {
                if (Objects.equals(reserva.getNombre(), busqueda)) {
                    usuariosFiltrado.add(usuario);
                }
            }
        }

        return usuariosFiltrado;
    }

    public ModelFactory getFactory() {
        return factory;
    }

    public ArrayList<Reserva> obtenerReservas(){
        return factory.getArcade().getListaReserva();
    }


    public void eliminarReserva(String correo){
        int eliminable = -1;
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
        for (int i = 0; i < reservas.size(); i++){
            if (Objects.equals(reservas.get(i).getFecha(), correo)){
                reservas.remove(reservas.get(i));
                this.factory.getArcade().addReserva(reservas.get(i));
                eliminable = i;
            }
        }
        if (eliminable!= -1){
            this.listaReservaObservable.remove(eliminable);
        }
    }
    public  Reserva consultarReserva(String correo, String clave){
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
        for (Reserva value : reservas) {
            if (value.getCorreo().equals(correo)){
                return value;
            }
        }
        return null;
    }


    public void actualizarReserva(String nombre, String correo, String clave, String saldo){
        ArrayList<Reserva> reservas = factory.getArcade().getListaReserva();
        int actualizable = -1;
        Reserva reservaTemporal = null;
        for (int i = 0; i < reservas.size(); i++){
            if (Objects.equals(reservas.get(i).getCorreo(), correo)){
                reservaTemporal = usuarios.get(i);
                reservaTemporal.setNombre(nombre);
                reservaTemporal.setClave(clave);
                reservaTemporal.setSaldo(saldo);
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
}
