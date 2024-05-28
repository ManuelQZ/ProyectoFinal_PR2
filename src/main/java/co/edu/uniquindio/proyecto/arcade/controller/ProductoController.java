package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;
import co.edu.uniquindio.proyecto.arcade.model.command.RegistrarClienteCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ProductoController {

    private ObservableList<Producto> listaProductoObservable;
    private Mediator mediator;
    private static ProductoController instance;

    private ProductoController() {
        this.mediator = Mediator.getInstancia();
        this.listaProductoObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public static ProductoController getInstance(){
        if(instance == null){
            return instance = new ProductoController();
        }
        return instance;

    }

    public Mediator getMediator() {
        return mediator;
    }


    public void eliminarProducto(String nombre){
        ArrayList<Producto> productos = mediator.getArcade().getListaProducto();
        for (int i = 0; i < productos.size(); i++){
            if (Objects.equals(productos.get(i).getNombre(), nombre)){
                productos.remove(productos.get(i));
                this.listaProductoObservable.remove(productos.get(i));
            }
        }
    }

    public void actualizarProducto(String nombre, String precio, String cantidadDisponible){
        ArrayList<Producto> productos = mediator.getArcade().getListaProducto();
        for (int i = 0; i < productos.size(); i++){
            if (Objects.equals(productos.get(i).getNombre(), nombre)){
                Producto nuevoProducto = new Producto(nombre, precio, cantidadDisponible);
                productos.remove(productos.get(i));
                productos.add(nuevoProducto);
                this.listaProductoObservable.remove(productos.get(i));
                this.listaProductoObservable.add(nuevoProducto);
            }
        }
    }

    public  Producto consultarProducto(String nombre){
        ArrayList<Producto> productos = mediator.getArcade().getListaProducto();
        for (Producto value : productos) {
            if (value.getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }

    public String crearProducto(String nombre, String precio, String cantidadDisponible) {
        ArrayList<Producto> productos = mediator.getArcade().getListaProducto();
        for (Producto producto : productos) {
            if (Objects.equals(producto.getNombre(), nombre)) {
                return "El producto ingresado ya se existe";
            }
        }
        Producto nuevoProducto = new Producto(nombre, precio, cantidadDisponible);
        this.mediator.getArcade().addProducto(nuevoProducto);
        this.listaProductoObservable.add(nuevoProducto);
        return "Producto registrado exitosamente";
    }

    public ObservableList<Producto> getListaProductoObservable() {
        return listaProductoObservable;
    }


    public void sincronizarData() {
        this.listaProductoObservable.addAll(this.mediator.getArcade().getListaProducto());
    }
}
