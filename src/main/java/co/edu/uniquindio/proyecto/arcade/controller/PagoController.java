package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Pago;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PagoController {

    private final ObservableList<Pago> listaPagoObservable;
    private final Mediator mediator;
    private static PagoController instance;

    private PagoController() {
        this.mediator = Mediator.getInstancia();
        this.listaPagoObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    private void sincronizarData() {

        this.listaPagoObservable.addAll(this.mediator.getArcade().getListaPago());
    }

    public static PagoController getInstance(){
        if(instance == null){
            return instance = new PagoController();
        }
        return instance;

    }

    public ObservableList<Pago> getListaPagosObservable() {
        return this.listaPagoObservable;
    }
}
