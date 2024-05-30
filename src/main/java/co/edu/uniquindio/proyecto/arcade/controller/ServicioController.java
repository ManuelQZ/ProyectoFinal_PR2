package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Reserva;
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
        Servicio servicioEliminable = this.consultarServicio(nombre);
        int eliminable;
        if (servicioEliminable != null){
            eliminable = servicios.indexOf(servicioEliminable);
            this.listaServicioObservable.remove(eliminable);
            this.mediator.getArcade().rmServicio(eliminable);
        }
    }

    public void actualizarServicio(String nombre, String descripcion, Modalidad modalidad, String precio, String disponibilidadReserva){
        ArrayList<Servicio> servicios = mediator.getArcade().getListaServicio();
        int actualizable = -1;
        Servicio servicioTemporal = null;

        for (int i = 0; i < servicios.size(); i++){
            if (Objects.equals(servicios.get(i).getNombre(), nombre)){
                servicioTemporal = servicios.get(i);
                servicioTemporal.setDescripcion(descripcion);
                servicioTemporal.setModalidad(modalidad);
                servicioTemporal.setPrecio(precio);
                servicioTemporal.setDisponibilidadReserva(disponibilidadReserva);
                actualizable = i;
            }
        }

        if (actualizable != -1){
            this.listaServicioObservable.remove(actualizable);
            this.mediator.getArcade().rmServicio(actualizable);
            this.mediator.getArcade().addServicio(servicioTemporal);
            this.listaServicioObservable.add(servicioTemporal);
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

    public String[] getListaNombreServicio(){
        ArrayList<Servicio> servicios = mediator.getArcade().getListaServicio();
        String[] nombres = new String[servicios.size()];
        for (int i = 0; i < servicios.size(); i++){
            nombres[i] = servicios.get(i).getNombre();
        }
        return nombres;
    }



    public ObservableList<Servicio> getListaServicioObservable() {
        return listaServicioObservable;
    }

    public void sincronizarData() {
        this.listaServicioObservable.addAll(this.mediator.getArcade().getListaServicio());
    }
}

