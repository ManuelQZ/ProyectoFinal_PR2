package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Servicio;
import co.edu.uniquindio.proyecto.arcade.model.enumeradores.Modalidad;
import co.edu.uniquindio.proyecto.arcade.model.facade.ProductivityPalace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ServicioController {

    private ObservableList<Servicio> listaServicioObservable;
    private Mediator mediator;
    private static ServicioController instance;

    private ServicioController() {
        this.mediator = Mediator.getInstancia();
        this.listaServicioObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public static ServicioController getInstance(){
        if(instance == null){
            return instance = new ServicioController();
        }
        return instance;

    }

    public Mediator getMediator() {
        return mediator;
    }


    public void eliminarServicio(String nombre){
        ArrayList<Servicio> servicios = mediator.getArcade().getListaServicio();
        for (int i = 0; i < servicios.size(); i++){
            if (Objects.equals(servicios.get(i).getNombre(), nombre)){
                servicios.remove(servicios.get(i));
                this.listaServicioObservable.remove(servicios.get(i));
            }
        }
    }

    public void actualizarServicio(String nombre, String descripcion, Modalidad modalidad, String precio, String disponibilidadReserva){
        ArrayList<Servicio> servicios = mediator.getArcade().getListaServicio();
        for (int i = 0; i < servicios.size(); i++){
            if (Objects.equals(servicios.get(i).getNombre(), nombre)){
                Servicio nuevoServicio = new Servicio(nombre,descripcion, modalidad, precio, disponibilidadReserva);
                servicios.remove(servicios.get(i));
                servicios.add(nuevoServicio);
                this.listaServicioObservable.remove(servicios.get(i));
                this.listaServicioObservable.add(nuevoServicio);
            }
        }
    }

    public String crearServicio(String nombre, String descripcion, Modalidad modalidad, String precio, String disponibilidadReserva) {
        ArrayList<Servicio> servicios = mediator.getArcade().getListaServicio();
        for (Servicio servicio : servicios) {
            if (Objects.equals(servicio.getNombre(), nombre)) {
                return "El servicio ingresado ya se existe";
            }
        }
        Servicio nuevoServicio = new Servicio(nombre,descripcion, modalidad, precio, disponibilidadReserva);
        this.mediator.getArcade().addServicio(nuevoServicio);
        this.listaServicioObservable.add(nuevoServicio);
        return "Servicio registrado exitosamente";
    }

    public  Servicio consultarServicio(String nombre){
        ArrayList<Servicio> servicios = mediator.getArcade().getListaServicio();
        for (Servicio value : servicios) {
            if (value.getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }

    public Servicio obtenerServicio(String nombre) {
        ArrayList<Servicio> listaServicio = this.mediator.getArcade().getListaServicio();
        for (Servicio servicio : listaServicio) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;
            }
        }
        return null;
    }

    public ObservableList<Servicio> getListaServicioObservable() {
        return listaServicioObservable;
    }

    public void sincronizarData() {
        this.listaServicioObservable.addAll(this.mediator.getArcade().getListaServicio());
    }
}

